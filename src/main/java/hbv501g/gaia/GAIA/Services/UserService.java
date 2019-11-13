package hbv501g.gaia.GAIA.Services;

import hbv501g.gaia.GAIA.Entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByUserName(String userName);
    User login(User user);
}
