package bong.service.collector.controller;

import bong.service.collector.domain.Item;
import bong.service.collector.service.ItemService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ImageController {

    private final ItemService itemService;

    @GetMapping("/list")
    public  String image(Model model){

        List<Item> imageList = itemService.findItem();

        List<ImagesEntity> images = new ArrayList<>();
        for(Item image : imageList){
            ImagesEntity entity = new ImagesEntity();
            entity.setFilePath(image.getImageUrl());
            entity.setFilename(image.getImageUrl());
            images.add(entity);

        }

        model.addAttribute("images", images);

        return "images";
    }

}
