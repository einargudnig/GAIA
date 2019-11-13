package hbv501g.gaia.GAIA.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String userName;
    public String password;


    @OneToMany(mappedBy = "user")
    private List<ChallengeLog> challenges = new ArrayList<>();

    public List<ChallengeLog> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<ChallengeLog> challenges) {
        this.challenges = challenges;
    }

    public User() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
