package hbv501g.gaia.GAIA.Services.Implementations;

import hbv501g.gaia.GAIA.Entities.Challenge;
import hbv501g.gaia.GAIA.Repositories.ChallengeRepository;
import hbv501g.gaia.GAIA.Services.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeServiceImplementation implements ChallengeService {
    ChallengeRepository repository;

    @Autowired
    public ChallengeServiceImplementation(ChallengeRepository challengeRepository) {
        this.repository = challengeRepository;
    }

    @Override
    public Challenge save(Challenge challenge) {
        return null;
    }

    @Override
    public void delete(Challenge challenge) {

    }

    @Override
    public List<Challenge> findAll() {
        return null;
    }

    @Override
    public Optional<Challenge> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Challenge> findByTitle(String title) {
        return null;
    }
}
