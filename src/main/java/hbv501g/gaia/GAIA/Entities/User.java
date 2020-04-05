package hbv501g.gaia.GAIA.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="username")
    @NotNull
    public String UName;

    @Column(name="email")
    @Email
    public String email;

    @Column(name="password")
    @Size(min=4, max=20)
    public String password;

    @Column(name="userinfo")
    public String userInfo;

    @Column(name="originalindex")
    public double originalIndex;

    @Column(name="currindex")
    public double currIndex;

    @Column(name="transIndex")
    public int transIndex;

    @Column(name="foodIndex")
    public int foodIndex;

    @Column(name="houseIndex")
    public int houseIndex;

    @Column(name="consIndex")
    public int consIndex;

    @Column(name="worstCase")
    public int worstCase;

    @Column(name="currCase")
    public int currCase;


    /* USER */
    public User(String UName, String email, String password, String userInfo, double originalIndex, double currIndex,
                int transIndex, int foodIndex, int houseIndex, int consIndex, int worstCase, int currCase) {
        this.UName = UName;
        this.email = email;
        this.password = password;
        this.userInfo = userInfo;
        this.originalIndex = originalIndex;
        this.currIndex = currIndex;
        this.transIndex = transIndex;
        this.foodIndex = foodIndex;
        this.houseIndex = houseIndex;
        this.consIndex = consIndex;
        this.worstCase = worstCase;
        this.currCase = currCase;
    }

    public User(String uName, String encode) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return UName;
    }

    /* GETTERS & SETTERS for name */
    public String getUName() {
        return UName;
    }

    public void setUName(String userName) {
        this.UName = userName;
    }


    /* GETTERS & SETTERS for email */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* GETTERS & SETTERS for password */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /* GETTERS & SETTERS for userInfo */
    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.password = userInfo;
    }


    /* GETTERS & SETTERS for originalIndex */
    public double getOriginalIndex() { return originalIndex; }

    public void setOriginalIndex(double originalIndex) {
        this.originalIndex = originalIndex;
    }

    /* GETTERS & SETTERS for currIndex */
    public double getCurrIndex() {
        return currIndex;
    }

    public void setCurrIndex(double currIndex) {
        this.currIndex = currIndex;
    }

    /* GETTERS & SETTERS for transIndex */
    public int getTransIndex() { return transIndex; }

    public void setTransIndex(int transIndex) { this.transIndex = transIndex; }

    /* GETTERS & SETTERS for foodIndex */
    public int getFoodIndex() { return foodIndex; }

    public void setFoodIndex(int foodIndex) { this.foodIndex = foodIndex; }

    /* GETTERS & SETTERS for houseIndex */
    public int getHouseIndex() { return houseIndex; }

    public void setHouseIndex(int houseIndex) { this.houseIndex = houseIndex; }

    /* GETTERS & SETTERS for consIndex */
    public int getConsIndex() { return consIndex; }

    public void setConsIndex(int consIndex) { this.consIndex = consIndex; }

    /* GETTERS & SETTERS for worstCase */
    public int getWorstCase() { return worstCase; }

    public void setWorstCase(int worstCase) { this.worstCase = worstCase; }

    /* GETTERS & SETTERS for consIndex */
    public int getCurrCase() { return currCase; }

    public void setCurrCase(int currCase) { this.currCase = currCase; }

    /*
    * Test for signUp
     */

}
