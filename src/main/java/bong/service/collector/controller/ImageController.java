package bong.service.collector.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("images")
@Controller
@Slf4j
public class ImageController {
    @GetMapping("/list")
    public  String image(Model model){

        List<ImagesEntity> images = new ArrayList<>();
        ImagesEntity image1 = new ImagesEntity();
        image1.setFilePath("dup1.png");
        image1.setFilename("dup1.png");
        images.add(image1);

        model.addAttribute("images", images);

        return "images";
    }
}
