package com.example.groupproject1.filters;
import com.alibaba.fastjson.JSON;
import com.example.groupproject1.security.JwtUtil.JwtUtil;
import org.springframework.security.authentication.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager)
    {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getParameter("username"),request.getParameter("password")));
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request,HttpServletResponse response,FilterChain chain,Authentication authResult) throws IOException {
        User user= (User) authResult.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        String token = JwtUtil.createToken(user.getUsername(), authorities.toString());
        response.setHeader("token", JwtUtil.TOKEN_PREFIX + token);
        response.getWriter().write(JSON.
                toJSONString("Logged In!"));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        String returnData="";
        if (failed instanceof AccountExpiredException) {
            returnData="account expired";
        }
        else if (failed instanceof BadCredentialsException) {
            returnData="wrong password";
        }
        else if (failed instanceof CredentialsExpiredException) {
            returnData="password expired";
        }
        else if (failed instanceof DisabledException) {
            returnData="invalid account";
        }
        else if (failed instanceof LockedException) {
            returnData="account locked";
        }
        else if (failed instanceof InternalAuthenticationServiceException) {
            returnData="account does not exist";
        }
        else{
            returnData="unknown error";
        }
        response.getWriter().write(JSON.toJSONString(returnData));
    }

}
