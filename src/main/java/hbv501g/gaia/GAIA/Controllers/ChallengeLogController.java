package hbv501g.gaia.GAIA.Controllers;

import hbv501g.gaia.GAIA.Entities.Challenge;
import hbv501g.gaia.GAIA.Entities.ChallengeLog;
import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Services.ChallengeLogService;
import hbv501g.gaia.GAIA.Services.ChallengeService;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ChallengeLogController {

    private UserService userService;
    private ChallengeService challengeService;
    private ChallengeLogService challengeLogService;

    @Autowired
    public ChallengeLogController(UserService userService, ChallengeService challengeService, ChallengeLogService challengeLogService) {
        this.userService = userService;
        this.challengeService = challengeService;
        this.challengeLogService = challengeLogService;
    }


    @RequestMapping(value = "/addChallenge/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String addChallengeToUser(@PathVariable("id") long id, Model model, HttpSession httpSession){
        Challenge challenge = challengeService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid challenge ID"));
        User sessionUser = (User) httpSession.getAttribute("LoggedInUser");
        System.out.println("--------");
        System.out.println("Hér er user og challenge title sem er verið að skrá");
        System.out.println(sessionUser);
        System.out.println(challenge.getTitle());
        System.out.println("--------");
        long challengeId = challenge.getId();
        User myUser = userService.findByUserName(sessionUser.userName);
        long sessionUserId = myUser.getId();
        model.addAttribute("tengi", challengeLogService.addChallengeToUser(sessionUserId, challengeId));
        return "redirect:/challenges";
    }


}
