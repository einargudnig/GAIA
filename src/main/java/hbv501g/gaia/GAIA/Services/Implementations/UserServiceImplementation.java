package hbv501g.gaia.GAIA.Services.Implementations;

import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Repositories.UserRepository;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repository.save(user);
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
    * Function that updates user.
    * username must be uniqe!
    */
    @Override
    public User updateUser(User user) {
        User exists = findByUserName(user.userName);

        if (exists != null) {
            return updateUser(user);
        }
        return null;
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
    public User findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    /*
     * Function that finds user by his
     * email
     */
    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    /*
     * Function that log in user by his
     */
    @Override
    public User login(User user) {
        User exists = findByUserName(user.userName);

        System.out.println("HERNA er update" + exists);
        System.out.println(exists.userName);
        System.out.println(exists.email);
        System.out.println(exists.password);
        System.out.println(exists.originalIndex);
        System.out.println(exists.userInfo);

        if (exists != null) {
            if(exists.password.equals(user.password)) {
                return user;
            }
        }
        return null;
    }
}
