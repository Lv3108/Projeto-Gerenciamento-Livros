package desafio.cadastroLivros.Config;

import desafio.cadastroLivros.Model.Livro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/livro").hasAnyRole("USER", "MANAGER")
                        .requestMatchers(HttpMethod.POST, "/livro").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,  "/livro/*").hasRole("MANAGER")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public UserDetailsService loadUser() {
        UserDetails admin = User
                .withUsername("Lucas")
                .password("{noop}1234")
                .roles("MANAGER")
                .build();

        UserDetails user = User
                .withUsername("Maycon")
                .password("{noop}1234")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
