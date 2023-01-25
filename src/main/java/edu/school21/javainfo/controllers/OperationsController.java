package edu.school21.javainfo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operations")
public class OperationsController {
    @GetMapping()
    public String getOperations() {
        return "html/operations/operations";
    }
}
