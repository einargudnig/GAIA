package hbv501g.gaia.GAIA.Services;

import hbv501g.gaia.GAIA.Entities.Challenge;
import hbv501g.gaia.GAIA.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findById(Long id);
    void delete(User user);
    List<User> findAll();
    User findByUName(String userName);
    //User findByEmail(String email);
}
