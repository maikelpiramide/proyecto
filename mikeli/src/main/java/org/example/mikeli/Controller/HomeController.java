package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home/usuario")
    public String homeUser(HttpSession httpSession){

        httpSession.getAttribute("user");
        return "home";
    }
}
