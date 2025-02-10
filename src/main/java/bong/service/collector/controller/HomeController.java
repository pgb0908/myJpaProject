package bong.service.collector.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        Boolean hasSession = false;

        if(!hasSession){
            return "login";
        }

        return "index";
    }

    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}
