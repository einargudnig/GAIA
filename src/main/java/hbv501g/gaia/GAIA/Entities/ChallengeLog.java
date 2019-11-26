package hbv501g.gaia.GAIA.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tengi", schema = "public")
public class ChallengeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Challenge challenge;

    @ManyToOne
    private User user;

    public Date fromdate;
    public Date todate;

    public ChallengeLog() {
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getToDate() {
        return todate;
    }

    public void setToDate(Date todate) {
        this.todate = todate;
    }


    public ChallengeLog(Challenge challenge, User user, Date fromdate, Date todate) {
        this.challenge = challenge;
        this.user = user;
        this.fromdate = fromdate;
        this.todate = todate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
