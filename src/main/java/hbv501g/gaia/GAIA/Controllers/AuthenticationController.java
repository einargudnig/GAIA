package hbv501g.gaia.GAIA.Controllers;


import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Security.JwtTokenUtil;
import hbv501g.gaia.GAIA.Security.Model.JwtRequest;
import hbv501g.gaia.GAIA.Security.Model.JwtResponse;
import hbv501g.gaia.GAIA.Services.Implementations.JwtUserDetailsService;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private UserService userService;

    private JwtUserDetailsService jwtUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, JwtUserDetailsService jwtUserDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    /**
     * This is for user login.
     * Authenticate using a simple Username/Password entity
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        // authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        System.out.println(token + "HER ER TOKEN");
        return ResponseEntity.ok(new JwtResponse(token));

    }

    /** Function that returns the logged in user
     * Uses Authentication and the JWT token to find the logged in user
     * Authentication loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication();
     *         String username = loggedInUser.getName();
     *
     * @return*/
    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public User loggedIntGET(Authentication authentication) {
        return userService.findByUName(authentication.getName());
    }

    /**
     * This is for user Registration
     * Register using a normal User entity
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        System.out.println("ER EG HER??");
        if(userService.findByUName(user.getUName()) != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already taken");
            System.out.println("EN HER????");
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    private void authenticate(String UName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(UName, password));

        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

