package com.example.groupproject1.config;

import com.example.groupproject1.MyUserDetailsService;
//import com.example.groupproject1.filters.JwtAuthenticationFilter;
//import com.example.groupproject1.filters.JwtAuthorizationFilter;
import com.example.groupproject1.filters.JwtAuthorizationFilter;
import com.example.groupproject1.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private MyUserDetailsService userDetailsServiceImpl;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/data", "/resource","/user/getAll", "/admin").hasRole("ADMIN")   //role.startsWith("ROLE_") 源码解析带ROLE_  需要写成ROLE_ADMIN
                .anyRequest().permitAll()
                .and()
                .addFilter(new JwtRequestFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
//                .and()
//                .logout().permitAll()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout", "POST")).and()
////redirect to the login page
//                .formLogin().loginPage("/users/login")
        ;


//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(logoutSuccessHandler())

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder())
        ;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
}