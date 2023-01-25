package edu.school21.javainfo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {
    @GetMapping("/main")
    public String getMain() {
        return "html/main/main";
    }
}
