package org.epam.controller;

import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    @GetMapping("/login_form")
    public String showLogin(){
        return "login_form";
    }

    @PostMapping("/login_form")
    public String loginForm(HttpServletRequest request){
        Object username = request.getAttribute("username");
        Map<String, String[]> parameterMap = request.getParameterMap();
        return "redirect:/";
    }
}
