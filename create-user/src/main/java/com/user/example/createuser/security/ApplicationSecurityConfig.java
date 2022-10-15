package com.user.example.createuser.security;

import com.user.example.createuser.filter.JWTAuthenticationFilter;
import com.user.example.createuser.filter.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.user.example.createuser.constants.SecurityConstants.SIGN_UP_URL;
import static com.user.example.createuser.security.ApplicationUserRole.ADMIN;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder;
    private UserDetailsService userDetailsService;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().authorizeRequests()
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers("/api/user/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
//                .authorizeRequests()
//                .antMatchers("/", "index").permitAll()
//                .antMatchers("/api/**").hasRole(ADMIN.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//
//        return source;
//    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails cekiUser = User.builder()
//                .username("ceki")
//                .password(passwordEncoder.encode("ceki123"))
//                .roles(ADMIN.name()) // ROLE_ADMIN
//                .build();
//
//        return new InMemoryUserDetailsManager(cekiUser);
//    }
}
