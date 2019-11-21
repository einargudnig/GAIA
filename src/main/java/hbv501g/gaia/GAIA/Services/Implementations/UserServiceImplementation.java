package hbv501g.gaia.GAIA.Services.Implementations;

import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Repositories.UserRepository;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User login(User user) {
        User exists = findByUserName(user.userName);
        System.out.println("LARPERA " + exists);
        if (exists != null) {
            if(exists.password.equals(user.password)) {
                return user;
            }
        }
        return null;
    }
}
