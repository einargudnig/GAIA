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
        return "LoginPage";
    }

    @RequestMapping("challenges")
    public String ChallengePage() { return "ChallengePage"; }

    @RequestMapping("signup")
    public String SignUp() { return "SignUp"; }

    @RequestMapping("skilmalar")
    public String Skilmalar() { return "Skilmalar"; }

}
