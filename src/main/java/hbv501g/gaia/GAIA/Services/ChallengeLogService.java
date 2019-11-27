package hbv501g.gaia.GAIA.Services;

import hbv501g.gaia.GAIA.Entities.ChallengeLog;

import java.util.List;

public interface ChallengeLogService {
    ChallengeLog save(ChallengeLog challengeLog);
    void delete(ChallengeLog challengeLog);
    List<ChallengeLog> findAll();
    /* Test */
    // ChallengeLog findByChallengeId(long challengeId);
    /* End of */
    ChallengeLog addChallengeToUser(long userId, long challengeId);
}
