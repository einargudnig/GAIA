package hbv501g.gaia.GAIA.Controllers;

import hbv501g.gaia.GAIA.Entities.Challenge;
import hbv501g.gaia.GAIA.Entities.ChallengeLog;
import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Services.ChallengeLogService;
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
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;
    private ChallengeService challengeService;
    private ChallengeLogService challengeLogService;

    @Autowired
    public UserController(UserService userService, ChallengeService challengeService, ChallengeLogService challengeLogService) {
        this.userService = userService;
        this.challengeService = challengeService;
        this.challengeLogService = challengeLogService;
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
            System.out.println("KEMST EG HINGAD??" + user.consIndex);

            userService.save(user);

            // System.out.println("Hvad er her " + user);
        }

        model.addAttribute("users", userService.findAll());
        return "/login";

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
            return "redirect:/loggedin";
        }
        return "redirect:/";
    }

    /* ******************************************************** */
    /* To see logged in user */
    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedinGET(HttpSession httpSession, Model model){
        model.addAttribute("user", userService.findAll());
        // Find all users
        User sessionUser = (User) httpSession.getAttribute("LoggedInUser");
        // Gets User that has httpSession from login.
        System.out.println("Sess " + sessionUser);
        // prints out that user.
        if(sessionUser  != null) {
            // if sessionUser is not null we have logged someone in.
            model.addAttribute("loggedInUser", sessionUser);
            // Give that user a "loggedinUser" 'value'
            User myUser = userService.findByUserName(sessionUser.userName);
            System.out.println("Herna aetti eg ad vera med loggedin user" + myUser);
            // Search for the username of that sessionUser.
            model.addAttribute("user", myUser);
            // Give that user a myuser 'value'
            /* ****************************************************************************************** */
            /* At this point we have the username of the loggedin user, by searching in the
            * User table, with User myUser we get the whole loggedIn user entity so
            * we can acces username, email, etc
            */

            /* *********************** */
            // Her thyrftum vid ad finna challid, kannski a challenges? eda tengi
            Challenge myChall = (Challenge) challengeService.findAll();
            long challengeId = 0;
            Optional<ChallengeLog> mychallId = challengeLogService.findById(challengeId);
            model.addAttribute(myChall);
            System.out.println("HER er Challenge " + myChall);
            model.addAttribute(mychallId);
            System.out.println("HERNA er CHALLENGE ID " + mychallId);

            model.addAttribute("challenges", challengeLogService.findAll());
            /* Here we search for all in challengeLog. For some reason we can only get the
            * id from that table. Maybe we always get ALL, because we are loggedin. */

            // System.out.println();



            // model.addAttribute("userChallenges", challengeService.findAll());
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
    public String userSubmit(@Valid @ModelAttribute("users") User user, BindingResult result, Model model, String userName) {
        System.out.println("hallo eg er inni userSubmit!");
        if(result.hasErrors()){
            return "redirect:/error";
        }
        model.addAttribute("users", userService.findByUserName(userName));
        return "users";

    }

}
