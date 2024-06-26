package org.example.mikeli.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession httpSession) {
        if(httpSession.getAttribute("user") != null) {
            httpSession.invalidate();
        }
        return new ModelAndView("redirect:/login");
    }
}
