package hbv501g.gaia.GAIA.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tengi")
public class  ChallengeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="challengeid")
    private long challengeid;

    @Column(name="userid")
    private long userid;

    public ChallengeLog() {
    }

    public ChallengeLog(long challengeid, long userid) {
        this.challengeid = challengeid;
        this.userid = userid;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long id) {
        this.userid = userid;
    }

    public long getChallengeid() { return challengeid; }

    public void setChallengeid(long id) { this.challengeid = challengeid; }
}
