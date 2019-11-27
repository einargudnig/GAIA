package hbv501g.gaia.GAIA.Controllers;


import hbv501g.gaia.GAIA.Entities.ChallengeLog;
import hbv501g.gaia.GAIA.Services.ChallengeLogService;
import hbv501g.gaia.GAIA.Services.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    private ChallengeService challengeService;
    private ChallengeLogService challengeLogService;

    @Autowired
    public HomeController( ChallengeService challengeService, ChallengeLogService challengeLogService) {
        this.challengeService = challengeService;
        this.challengeLogService = challengeLogService;
    }

    @RequestMapping("/")
    public String Home() {
        return "Index";
    }


    @RequestMapping("challenges")
    public String ChallengePage() { return "ChallengePage"; }

    @RequestMapping("skilmalar")
    public String Skilmalar() { return "Skilmalar"; }


    /* ******************************************************** */
    /* To see challenges in the database */
    /* Virkar ad skoda /challenges */
    @RequestMapping(value = "/challenges", method = RequestMethod.GET)
    public String challengesGET(Model model) {
        model.addAttribute("challenges", challengeService.findAll());
        return "challenges";
    }

    /* ******************************************************** */
    /* To see challenges user has accepted */
   @RequestMapping(value = "/showChallenge", method = {RequestMethod.GET, RequestMethod.POST})
    public String showChallenge(@PathVariable("id") long id, Model model, HttpSession httpSession) {
       // Challenge challenge = challengeService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid challenge ID"));



       return null;
   }



}
