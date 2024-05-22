package org.example.mikeli.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapaCentroController {
    @GetMapping("/home/mapaCentros")
    public String mapaCentros() {
        return "mapaCentros";
    }
}
