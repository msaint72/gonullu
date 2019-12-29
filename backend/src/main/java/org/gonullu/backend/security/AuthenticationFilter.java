package org.gonullu.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.SignatureAlgorithm;
import org.gonullu.backend.SpringApplicationContext;
import org.gonullu.backend.service.UserService;
import org.gonullu.backend.ws.model.request.LoginRequestModel;
import org.gonullu.backend.ws.shared.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import io.jsonwebtoken.Jwts;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager=authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws AuthenticationException {
        try {
            LoginRequestModel requestModel=new ObjectMapper()
                    .readValue(servletRequest.getInputStream(),LoginRequestModel.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestModel.getEmail(),
                            requestModel.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest servletRequest,
                                            HttpServletResponse servletResponse,
                                            FilterChain chain,
                                            Authentication authentication) throws IOException, ServletException {
        String userName=((User) authentication.getPrincipal()).getUsername();

        String token= Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.TOKEN_SECRET)
                .compact();
        UserService userService= (UserService) SpringApplicationContext.getBean("userServiceImpl");
        UserDto userDto=userService.getUser(userName);

        servletResponse.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+token);
        servletResponse.addHeader("UserID",userDto.getUserId());

    }
}
