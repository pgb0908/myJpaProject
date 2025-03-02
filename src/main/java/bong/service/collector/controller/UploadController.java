package bong.service.collector.controller;

import bong.service.collector.config.WebConfig;
import bong.service.collector.dto.uploadImageDto;
import bong.service.collector.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequiredArgsConstructor
public class UploadController {

    private final ItemService itemService;


    @PostMapping("/upload")
    public String handleFileUpload(
            @ModelAttribute uploadImageDto uploadImageRequest,
            RedirectAttributes redirectAttributes
            ){

        String imageUrl = WebConfig.UPLOAD_DIR;

        File uploadFolder = new File(imageUrl);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs(); // 디렉토리 생성
        }

        if (uploadImageRequest.getFile().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/main";
        }


        MultipartFile file = uploadImageRequest.getFile();
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/main";
        }


        try {
            // 1. 저장할 경로 설정
            Path savePath = Paths.get(imageUrl, file.getOriginalFilename());

            // 2. 파일을 해당 경로로 저장
            file.transferTo(savePath.toFile());

            // 3. DB에 저장할 파일 경로를 생성
            String savedUrl = imageUrl + file.getOriginalFilename();

            // 4. itemService를 호출하여 정보 저장
            itemService.saveImage(uploadImageRequest.getTitle(), savedUrl,
                    uploadImageRequest.getDesc(), uploadImageRequest.getFile());

            redirectAttributes.addFlashAttribute("message", "File uploaded successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "File upload failed.");
        }

        return "redirect:/main";
    }
}
