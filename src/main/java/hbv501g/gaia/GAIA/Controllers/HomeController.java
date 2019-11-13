package hbv501g.gaia.GAIA.Controllers;

import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

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

    @RequestMapping("signup")
    public String SignUp(User user) { return "SignUp"; }

    @RequestMapping("skilmalar")
    public String Skilmalar() { return "Skilmalar"; }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersGET(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }



}
