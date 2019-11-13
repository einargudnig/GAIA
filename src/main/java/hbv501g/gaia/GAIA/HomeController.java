package hbv501g.gaia.GAIA;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String Home() {
        return "Velkominn";
    }

    @RequestMapping("login")
    public String LoginPage() {
        return "LoginPage";
    }

    @RequestMapping("challenges")
    public String ChallengePage() { return "ChallengePage"; }

}
