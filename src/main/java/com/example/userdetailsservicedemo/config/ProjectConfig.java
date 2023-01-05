package com.example.userdetailsservicedemo.config;

import com.example.userdetailsservicedemo.ds.DummyUser;
import com.example.userdetailsservicedemo.service.InMemoryCustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
//        String userByNameQuery = """
//                select username, password, enabled
//                from users where username = ?
//                """;
//        String authByUserQuery = """
//                select username, authority
//                from authorities where username = ?
//                """;
//        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        userDetailsManager.setUsersByUsernameQuery(userByNameQuery);
//        userDetailsManager.setAuthoritiesByUsernameQuery(authByUserQuery);
//
//        return userDetailsManager;
        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails u1 = new DummyUser("john","12345","read");
//        UserDetails u2 = new DummyUser("mary","12345","read");
//        List<UserDetails> users = List.of(u1,u2);
//        return new InMemoryCustomUserDetailsService(users);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
