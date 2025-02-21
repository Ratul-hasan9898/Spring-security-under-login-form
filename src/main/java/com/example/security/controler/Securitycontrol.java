package com.example.security.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Securitycontrol {
    @RequestMapping("/")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    public String index(){
        return "index";
    }
    @RequestMapping("/about")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    public String about(){
        return "about";
    }
    @RequestMapping("/home")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String home(){
        return "home";
    }
 
}
