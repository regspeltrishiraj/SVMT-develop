package com.example.demo.upload.link;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController2 {

    @Autowired
    private LinkService linkService;

    @GetMapping("/newHome")
    public String homePage(Model model) {
        List<Link> links = linkService.getDisplayedLinks();
        model.addAttribute("links", links);
        return "index";
    }
    
   
        
    
}

