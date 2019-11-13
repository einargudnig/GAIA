package hbv501g.gaia.GAIA.Services.Implementations;

import hbv501g.gaia.GAIA.Entities.ChallengeLog;
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
        return null;
    }

    @Override
    public void delete(ChallengeLog challengeLog) {

    }

    @Override
    public List<ChallengeLog> findAll() {
        return null;
    }
}
