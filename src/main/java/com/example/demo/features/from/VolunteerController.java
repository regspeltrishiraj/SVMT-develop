package com.example.demo.features.from;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @GetMapping("/volunteer/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("volunteer", new Volunteer());
        return "volunteerForm";
    }

    @PostMapping("/volunteer/register")
    public String registerVolunteer(@ModelAttribute("volunteer") Volunteer volunteer) {
        volunteerService.registerVolunteer(volunteer);
        return "redirect:/success2";
    }
    @GetMapping("/success2")
    public String showLoginPage() {
        return "success2";  // Corresponds to Volunteer_login.html in templates folder
    }
    
    
    @GetMapping("HTML/Volunteer_login.html")
	public String VolunteerPage() {
		return "Volunteer_login";
	}
    
    @PostMapping("/login/volunteer")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Validate credentials
        boolean isValidUser = volunteerService.validateVolunteer(username, password);
        
        if (isValidUser) {
            return "redirect:/index"; // Redirect to home page on successful login
        } else {
            return "redirect:/login/volunteer?error"; // Redirect back to login page with an error message
        }
    }
    
    
    

}
