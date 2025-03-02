package bong.service.collector.controller;


import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpSession session){
        SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (securityContext == null) {
            return "redirect:/login";
        }

        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            log.info("log-in: " + authentication.getName());
            return "main";
        } else {
            return "redirect:/login";
        }
    }


    @RequestMapping("/main")
    public String index(){

        return "main";
    }

}
