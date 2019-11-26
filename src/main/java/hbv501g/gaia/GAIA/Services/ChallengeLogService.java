package hbv501g.gaia.GAIA.Services;

import hbv501g.gaia.GAIA.Entities.Challenge;
import hbv501g.gaia.GAIA.Entities.ChallengeLog;
import hbv501g.gaia.GAIA.Entities.User;

import java.util.List;

public interface ChallengeLogService {
    ChallengeLog save(ChallengeLog challengeLog);
    void delete(ChallengeLog challengeLog);
    List<ChallengeLog> findAll();
    ChallengeLog addChallengeToUser(long userId, long challengeId);
}
