package br.com.indracompany.gestaoalunos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder
            .inMemoryAuthentication()
            .withUser("ivan")
            .password("{noop}123")
            .roles("USER");
    }

}
