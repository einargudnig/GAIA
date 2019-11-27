package hbv501g.gaia.GAIA.Entities;

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
    public String userName;

    @Column(name="email")
    @Email
    public String email;

    @Column(name="password")
    @Size(min=4, max=20)
    public String password;

    @Column(name="userinfo")
    public String userInfo;

    @Column(name="originalindex")
    public Double originalIndex;

    @Column(name="currindex")
    public Double currIndex;

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

    public User() {
    }

    /* USER */
    public User(String userName, String email, String password, String userInfo, Double originalIndex, Double currIndex,
                int transIndex, int foodIndex, int houseIndex, int consIndex, int worstCase, int currCase) {
        this.userName = userName;
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

    /* GETTERS & SETTERS for name */
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    /* GETTERS & SETTERS for email */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* GETTERS & SETTERS for password */
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
    public void setOriginalIndex(Double originalIndex) {
        this.originalIndex = originalIndex;
    }

    /* GETTERS & SETTERS for currIndex */
    public Double getCurrIndex() {
        return currIndex;
    }

    public void setCurrIndex(Double currIndex) {
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
