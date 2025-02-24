package bong.service.collector.controller;

import bong.service.collector.dto.UploadImageRequest;
import bong.service.collector.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
public class UploadController {

    private final ItemService itemService;
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public String handleFileUpload(
            @ModelAttribute UploadImageRequest uploadImageRequest,
            RedirectAttributes redirectAttributes
            ){

        if (uploadImageRequest.getFile().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/main";
        }

        itemService.addNewOne(uploadImageRequest.getTitle(),
                uploadImageRequest.getDesc(),
                uploadImageRequest.getFile());


        return "redirect:/main";
    }
}
