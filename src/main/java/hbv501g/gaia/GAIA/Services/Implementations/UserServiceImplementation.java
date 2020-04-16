package hbv501g.gaia.GAIA.Services.Implementations;

import hbv501g.gaia.GAIA.Entities.Challenge;
import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Repositories.UserRepository;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.repository = userRepository;
    }

    /*
    * Function that saves user
    * to database
    */
    @Override
    public User save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return repository.save(new User(user.getUName(), user.getEmail(), encoder.encode(user.getPassword()), user.getCurrIndex(), user.getUserInfo()));
    }

    /*
    * Function that finds
    * user from ID
    */
    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }


    /*
    * function that deletes user from database
    */
    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    /*
    * Function that finds all users
    * returns list
    */
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    /*
    * Function that finds user by his
    * username
    */
    @Override
    public User findByUName(String uName) {
        return repository.findByUName(uName);
    }

    /*
     * Function that finds user by his
     * email

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    } */



}
