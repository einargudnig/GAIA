package hbv501g.gaia.GAIA.Repositories;

import hbv501g.gaia.GAIA.Entities.ChallengeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChallengeLogRepository extends JpaRepository<ChallengeLog, Long> {

    ChallengeLog save(ChallengeLog challengeLog);
    void delete(ChallengeLog challengeLog);
    List<ChallengeLog> findAll();
    Optional<ChallengeLog> findById(long id);
}
