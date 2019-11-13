package hbv501g.gaia.GAIA.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String Home() {
        return "Index";
    }

    @RequestMapping("login")
    public String LoginPage() {
        return "login";
    }

    @RequestMapping("challenges")
    public String ChallengePage() { return "ChallengePage"; }

}
