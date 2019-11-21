package hbv501g.gaia.GAIA.Controllers;

import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Services.ChallengeService;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    // private ChallengeService challengeService;

    @Autowired
    public UserController(UserService userService, ChallengeService challengeService) {
        this.userService = userService;
        // this.challengeService = challengeService;
    }

    /*
    @RequestMapping("signup")
    public String SignUp(User user) { return "SignUp"; }
     */

    /* ******************************************************** */
    /* SignUp for Users */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpGET(User user){
        return "SignUp";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpPOST(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "SignUp";
        }
        User exists = userService.findByUserName(user.userName);
        if(exists == null){
            userService.save(user);
        }
        model.addAttribute("users", userService.findAll());
        return "/users";
    }

    /* Login
    @RequestMapping("login")
    public String LoginPage() {
        return "login";
    } */

    /* ******************************************************** */
    /* To Log in user */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(User user){
        return "login";
    }

    /* ATHATH Þurfum að breyta public breytum í private entities. Fyrir ALLT!
     * Breytum svo hér fyrir neðan..
     * User exists = userService.findUserByEmail(user.getEmail()) */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@Valid User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "login";
        }
        model.addAttribute("challenges", userService.findAll());
        User exists = userService.login(user);
        if(exists != null){
            session.setAttribute("LoggedInUser", user);
            return "redirect:/";
        }
        return "redirect:/";
    }

    /* ******************************************************** */
    /* To see logged in user */
    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedinGET(HttpSession session, Model model){
        model.addAttribute("challenges", userService.findAll());
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser  != null){
            model.addAttribute("loggedinuser", sessionUser);
            return "loggedInUser";
        }
        return "redirect:/users";
    }

    /* ***************************************************** */
    /* To see what users are in the database */
    /* Virkar ad skoda /users */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersGET(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }


}
