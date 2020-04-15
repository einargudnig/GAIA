package hbv501g.gaia.GAIA.Controllers;

import hbv501g.gaia.GAIA.Entities.Challenge;
import hbv501g.gaia.GAIA.Entities.ChallengeLog;
import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Services.ChallengeLogService;
import hbv501g.gaia.GAIA.Services.ChallengeService;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
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


    /** Function that add challenges to the user
     * has id as parameter. Id for that unique challenge.
     * @return*
    @RequestMapping(value = "/addChallenge/{id}", method = {RequestMethod.POST})
    public ChallengeLog addChallengeToUser(@PathVariable("id") long id, Authentication authentication){
        Challenge challenge = challengeService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid challenge ID"));
        Authentication username = (User) SecurityContextHolder.getContext().getAuthentication();
        String loggedInUser = username.getName();
        // User jwtUser = userService.findByUName(authentication.getName());
        System.out.println("--------");
        System.out.println("Hér er user og challenge title sem er verið að skrá");
        System.out.println(loggedInUser);
        System.out.println(challenge.getTitle());
        System.out.println("--------");
        long challengeId = challenge.getId();
        User myUser = userService.findByUName(loggedInUser);
        long loggedinUserId = myUser.getId();
        return challengeLogService.addChallengeToUser(loggedinUserId, challengeId);

    } */


}
