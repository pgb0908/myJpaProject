package bong.service.collector.controller;

import bong.service.collector.dto.imageDto;
import bong.service.collector.dto.uploadImageDto;
import bong.service.collector.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainPageController {

    private final ItemService itemService;

    @GetMapping
    public String mainPage(Model model){
        var items = itemService.findItem();

        List<imageDto> itemDTOs = items.stream().map(item -> {

            return new imageDto(item.getId(), item.getTitle(), item.getType(), item.getImageUrl(), item.getDescription(), item.getUpdatedAt());
        }).toList();

        model.addAttribute("items", itemDTOs);
        return "main";
    }

    @RequestMapping("/uploadImage")
    public String uploadImage(){

        return "upload";
    }

}
