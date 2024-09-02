package com.example.demo.features.from;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("form", new Form());
        return "signup_form";
    }

    @PostMapping("/register")
    public String registerForm(@ModelAttribute Form form) {
        formService.registerForm(form);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
