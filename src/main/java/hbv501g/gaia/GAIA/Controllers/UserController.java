package hbv501g.gaia.GAIA.Controllers;


import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Services.ChallengeLogService;
import hbv501g.gaia.GAIA.Services.ChallengeService;
import hbv501g.gaia.GAIA.Services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
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

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpPOST(@Valid User user, BindingResult result, Model model){
        // System.out.println("HERNA " + user);
        if(result.hasErrors()){
            return "SignUp";
        }
        User exists = userService.findByUserName(user.userName);
        // System.out.println("HALLO " + exists);
        if(exists == null){
            System.out.println("KEMST EG HINGAD??" + user.consIndex);

            userService.save(user);
            int trans = user.getTransIndex();
            int food = user.getFoodIndex();
            int house = user.getHouseIndex();
            int cons = user.getConsIndex();
            int original = trans + food + house + cons;
            System.out.println(original);
            double d = original;
            // System.out.println(d);
            user.setOriginalIndex(d);
            user.setCurrIndex(d);
            user.setWorstCase(original);
            user.setCurrCase(original);
            userService.save(user);

        }

        model.addAttribute("users", userService.findAll());
        return "/login";
    } */

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

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession httpSession){
        System.out.println("Fallið logout");
        User sessionUser = (User) httpSession.getAttribute("LoggedInUser");
        if(sessionUser  != null) {
            System.out.println("Rassamaðurinn");
            model.addAttribute("loggedInUser", sessionUser);
            User myUser = userService.findByUserName(sessionUser.userName);
            httpSession.removeAttribute(myUser.userName);
            System.out.println("Logged out");
            return "redirect:/";
        }
        System.out.println("Ekki logged out");
        return "/error";
    } */

    /* Erum held med JWT auth sem ser um thetta
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@Valid User user, BindingResult result, Model model, HttpSession httpSession){
        if(result.hasErrors()){
            return "login";
        }
        model.addAttribute("user", userService.findAll());
        User exists = userService.login(user);

        if(exists != null){
            httpSession.setAttribute("LoggedInUser", user);
            return "redirect:/loggedin";
        }
        return "redirect:/";
    } */

    /* ******************************************************** */
    /* To see logged in user
    * ATH Buid ad uppfaera med tilliti til JWT auth
    *
    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public User loggedinGET(Authentication authentication){
            return userService.findByUName(authentication.getName);
    } */

    //BUID AD LAGA
    /*
    * Search for other users.
     */
    @RequestMapping("/users")
    public List<User> userPage() {
        return userService.findAll();
    }

    /*
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String userSubmit(@Valid @ModelAttribute("users") User user, BindingResult result, Model model, String userName) {
        System.out.println("hallo eg er inni userSubmit!");
        if(result.hasErrors()){
            return "redirect:/error";
        }
        model.addAttribute("users", userService.findByUserName(userName));
        return "users";
    } */

}
