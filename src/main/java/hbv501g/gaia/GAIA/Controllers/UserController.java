package hbv501g.gaia.GAIA.Controllers;

import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Services.ChallengeService;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class UserController {

    private UserService userService;
    private ChallengeService challengeService;

    @Autowired
    public UserController(UserService userService, ChallengeService challengeService) {
        this.userService = userService;
        this.challengeService = challengeService;
    }


    /* ******************************************************** */
    /* SignUp for Users */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpGET(User user){
        return "SignUp";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpPOST(@Valid User user, BindingResult result, Model model){
        System.out.println("HERNA " + user);
        if(result.hasErrors()){
            return "SignUp";
        }
        User exists = userService.findByUserName(user.userName);
        // System.out.println("HALLO " + exists);
        if(exists == null){
            // System.out.println("KEMST EG HINGAD??");
            userService.save(user);
            System.out.println("Hvad er her " + user);
        }
        model.addAttribute("users", userService.findAll());
        return "/userInfo";
    }



    /* ******************************************************** */
    /* To Log in user
    *  First part of this login functionality is just to
    *  "fetch" the login page
    */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(User user){
        return "login";
    }

    /* ATHATH Þurfum að breyta public breytum í private entities. Fyrir ALLT!
     * Breytum svo hér fyrir neðan..
     * User exists = userService.findUserByEmail(user.getEmail())
     * This part should use the POST method from the login field
     * and use that data for the login procedure.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@Valid User user, BindingResult result, Model model, HttpSession httpSession){
        // System.out.println("BANANI " + user);
        if(result.hasErrors()){
            return "login";
        }
        model.addAttribute("user", userService.findAll());
        // System.out.println("EPLI");
        User exists = userService.login(user);
        // System.out.println("Ananas " + exists);
        if(exists != null){
            httpSession.setAttribute("LoggedInUser", user);
            return "redirect:/";
        }
        return "redirect:/";
    }

    /* ******************************************************** */
    /* To see logged in user */
    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedinGET(HttpSession httpSession, Model model){
        model.addAttribute("user", userService.findAll());
        User sessionUser = (User) httpSession.getAttribute("LoggedInUser");
        System.out.println("Sess " + sessionUser);
        if(sessionUser  != null){
            model.addAttribute("loggedInUser", sessionUser);
            return "loggedInUser";
        }
        return "redirect:/";
    }

    /* ***************************************************** */
    /* To see what users are in the database */
    /* Virkar ad skoda /users */
    /* //  Taka sma út til að testa search
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersGET(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }
    */

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userGET(Model model) {
        model.addAttribute("users", new User());
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String userSubmit(@Valid @ModelAttribute("users") User users, BindingResult result, Model model, String userName) {
        System.out.println("hallo eg er inni userSubmit!");
        if(result.hasErrors()){
            return "redirect:/error";
        }
        model.addAttribute("users", userService.findByUserName(userName));
        return "users";

    }
}
