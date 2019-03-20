package app.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;/*
import org.springframework.app.security.app.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.app.security.app.config.annotation.web.builders.HttpSecurity;
import org.springframework.app.security.app.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.app.security.app.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.app.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.app.security.crypto.password.PasswordEncoder;*/
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
public class SecurityConfigurator /*extends WebSecurityConfigurerAdapter*/ {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
/*

    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;




    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("email").password(encoder().encode("adminPass")).roles("ADMIN")
                .and()
                .withUser("user").password(encoder().encode("userPass")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
//                .antMatchers("/user/**").authenticated()
                .antMatchers("/api/admin/**").hasRole("ADMIN");
    }*/


}
