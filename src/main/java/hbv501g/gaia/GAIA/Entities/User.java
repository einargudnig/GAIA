package hbv501g.gaia.GAIA.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="username")
    @NotNull
    @JsonProperty(value = "UName")
    public String UName;

    @Column(name="password")
    // @Size(min=4, max=20)
    public String password;


    @Column(name="email")
    @Email
    @JsonProperty(value = "email")
    public String email;



    /* USER */
    public User(String UName, String email, String password) {
        this.UName = UName;
        this.email = email;


    }

    public User() {

    }


    /*
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    } */

    @Override
    public String toString() {
        return UName;
    }

    @Override
    public String getName() {
        return null;
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





    /* Extra stuff from Spring Security */


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }


}
