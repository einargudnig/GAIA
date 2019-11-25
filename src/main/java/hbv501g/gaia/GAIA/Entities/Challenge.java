package hbv501g.gaia.GAIA.Entities;

import javax.persistence.*;

@Entity
@Table(name = "challenges") //nafn a SQL toflu i database
public class Challenge {
    @Id   //einkvæmt tag, engar tvær challenges með sama ID
    @GeneratedValue(strategy = GenerationType.AUTO) //Java haekkar ID sjalfkrafa ef vid buum til nytt
    @Column(name = "id",
            columnDefinition = "NUMERIC(19,0)"
    )
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="info")
    public String description;

    @Column(name="count")
    private long count;

    @Column(name="carbonindex")
    private Double carbonIndex;
    // private image picture;

    public Challenge() {
        // VERDUM ad hafa toman constructor svo JPA geti buid til tilvik af thessum klosum
    }

    public Challenge(String title, String description, Double carbonIndex) {
        this.title = title;
        this.description = description;
        this.carbonIndex = carbonIndex;
    }

    /*  GETTERS & SETTERS */
    public Challenge getChallenge(Challenge challenge) { return challenge; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Double getCarbonIndex() {
        return carbonIndex;
    }

    public void setCarbonIndex(Double carbonIndex) {
        this.carbonIndex = carbonIndex;
    }

}
