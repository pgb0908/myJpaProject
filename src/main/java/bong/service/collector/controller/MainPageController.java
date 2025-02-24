package bong.service.collector.controller;

import bong.service.collector.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final ItemService itemService;

    @RequestMapping("/main")
    public String mainPage(Model model){
        var items = itemService.findItem();

        model.addAttribute("items", items);
        return "main";
    }

    @RequestMapping("/main/uploadImage")
    public String uploadImage(){


        return "upload";
    }
}
