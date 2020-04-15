package hbv501g.gaia.GAIA.Controllers;


import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Services.ChallengeLogService;
import hbv501g.gaia.GAIA.Services.ChallengeService;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController

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
    /* NOTE!!!
    * We MUST change and encript password, can't store them like regular strings
    * That's bad :(
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpGET(User user){
        return "SignUp";
    }

    
    /* ******************************************************** */
    /* To Log in user
    *  First part of this login functionality is just to
    *  "fetch" the login page

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(User user){
        return "login";
    }
    */

    /*
     * User exists = userService.findUserByEmail(user.getEmail())
     * This part should use the POST method from the login field
     * and use that data for the login procedure.





    //BUID AD LAGA
    /*
    * Search for other users.
     */
    @RequestMapping("/users")
    public List<User> userPage() {
        return userService.findAll();
    }



}
