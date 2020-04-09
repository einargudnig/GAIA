package hbv501g.gaia.GAIA.Security.Model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
        System.out.println(jwtToken + "HALLOOOO");
    }

    public String getToken() {
        return this.jwtToken;
    }
}
