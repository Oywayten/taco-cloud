package vitaliy.grab.doners.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import vitaliy.grab.doners.model.User;
import vitaliy.grab.doners.repository.UserRepository;

/**
 * Oywayten 05.01.2024.
 */

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    public static final String DESIGN = "/design";
    public static final String LOGIN = "/login";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder builder = new MvcRequestMatcher.Builder(introspector);
        http.authorizeHttpRequests(request -> request
                        .requestMatchers(builder.pattern("/design/**"), builder.pattern("/orders/**")).authenticated()
                        .requestMatchers(builder.pattern("/**")).permitAll()
                ).formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                        .loginPage(LOGIN).defaultSuccessUrl(DESIGN))
                .oauth2Login(o -> o
                        .loginPage(LOGIN).defaultSuccessUrl(DESIGN))
                .logout(l -> l
                        .logoutSuccessUrl("/login"))
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer
                        .ignoringRequestMatchers(builder.pattern("login.do"), builder.pattern("query.do"))
                        .ignoringRequestMatchers("/data-api/**"))
                .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }
}
