package hbv501g.gaia.GAIA.Services;

import hbv501g.gaia.GAIA.Entities.ChallengeLog;

import java.util.List;
import java.util.Optional;

public interface ChallengeLogService {
    ChallengeLog save(ChallengeLog challengeLog);
    void delete(ChallengeLog challengeLog);
    List<ChallengeLog> findAll();
    /* Test */
    Optional<ChallengeLog> findById(long id);
    /* End of */
    ChallengeLog addChallengeToUser(long userId, long challengeId);
}
