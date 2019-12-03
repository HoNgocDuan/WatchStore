package watch.store.mnm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("customAuthenticationSuccessHandler")
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    @Qualifier("customAuthenticationFailureHandler")
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/cashier").hasRole("CASHIER")
                .antMatchers("/employee").hasRole("EMPLOYEE")
                .antMatchers("/accountant").hasRole("ACCOUNTANT")
                .antMatchers("api/**").permitAll()
                .and()
                .formLogin()
                .failureHandler(authenticationFailureHandler)
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login?error")
                .and().rememberMe().key("uniqueAndSecret").tokenValiditySeconds(85400)
                .and().csrf().disable()
                .exceptionHandling()
                .accessDeniedPage("/403");
    }
}