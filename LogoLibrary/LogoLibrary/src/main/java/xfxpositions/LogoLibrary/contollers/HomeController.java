package xfxpositions.LogoLibrary.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String responseBody(){
        return "It works!";
    }
}
