package hbv501g.gaia.GAIA.Controllers;


import hbv501g.gaia.GAIA.Entities.User;
import hbv501g.gaia.GAIA.Security.JwtTokenUtil;
import hbv501g.gaia.GAIA.Security.Model.JwtRequest;
import hbv501g.gaia.GAIA.Security.Model.JwtResponse;
import hbv501g.gaia.GAIA.Services.Implementations.JwtUserDetailService;
import hbv501g.gaia.GAIA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    private JwtUserDetailService jwtUserDetailService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, JwtUserDetailService jwtUserDetailService, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtUserDetailService = jwtUserDetailService;
    }

    /**
     * Authenticate using a simple Username/Password entity
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtUserDetailService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * Register using a normal User entity
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        if(userService.findByUName(user.getUName()) != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already taken");
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

