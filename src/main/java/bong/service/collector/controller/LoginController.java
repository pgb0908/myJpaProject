package bong.service.collector.controller;

import bong.service.collector.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }
}
