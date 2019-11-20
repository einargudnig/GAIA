package hbv501g.gaia.GAIA.Repositories;

import hbv501g.gaia.GAIA.Entities.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    Challenge save(Challenge challenge);
    void delete(Challenge challenge);
    List<Challenge> findAll();
    List<Challenge> findByTitle(String title);
    Optional<Challenge> findById(BigInteger id);
}
