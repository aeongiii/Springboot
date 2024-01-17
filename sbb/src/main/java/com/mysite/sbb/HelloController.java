package com.mysite.sbb; 

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ResponseBody; 

@Controller 
public class HelloController { 
    @GetMapping("/maratang") 
    @ResponseBody 
    public String maratang() { 
        return "마라탕먹고싶다! "; 
    } 
}
