package hbv501g.gaia.GAIA.Services;

import hbv501g.gaia.GAIA.Entities.Challenge;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    Challenge save(Challenge challenge);
    void delete(Challenge challenge);
    List<Challenge> findAll();
    Optional<Challenge> findById(long id);
    List<Challenge> findByTitle(String title);
}
