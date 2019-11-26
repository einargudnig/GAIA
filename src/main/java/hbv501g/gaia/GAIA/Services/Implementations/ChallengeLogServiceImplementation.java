package hbv501g.gaia.GAIA.Services.Implementations;

import hbv501g.gaia.GAIA.Entities.Challenge;
import hbv501g.gaia.GAIA.Entities.ChallengeLog;
import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Repositories.ChallengeLogRepository;
import hbv501g.gaia.GAIA.Services.ChallengeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeLogServiceImplementation implements ChallengeLogService {
    ChallengeLogRepository repository;

    @Autowired
    public ChallengeLogServiceImplementation(ChallengeLogRepository challengeLogRepository) {
        this.repository = challengeLogRepository;
    }


    @Override
    public ChallengeLog save(ChallengeLog challengeLog) {
        return repository.save(challengeLog);
    }

    @Override
    public void delete(ChallengeLog challengeLog) {
        repository.delete(challengeLog);
    }

    @Override
    public List<ChallengeLog> findAll() {
        return repository.findAll();
    }

    @Override
    public ChallengeLog addChallengeToUser(long userId, long challengeId) {
        ChallengeLog ourLog = new ChallengeLog(challengeId, userId);
        System.out.println(userId);
        System.out.println(challengeId);
        return repository.save(ourLog);
    }
}
