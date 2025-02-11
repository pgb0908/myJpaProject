package bong.service.collector.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    // https://dnl1029.tistory.com/35

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화

/*                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().authenticated()  // 어떠한 요청이라도 인증필요
                )*/
                .authorizeHttpRequests(auth -> auth
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() // 정적 리소스 허용
                        .anyRequest().authenticated()
                )

/*                .formLogin(login -> login  // form 방식 로그인 사용
                        .defaultSuccessUrl("/index", true)
                        .permitAll()
                )*/
                .formLogin(loginForm -> loginForm  //  커스텀 form 방식 로그인 사용
                        .loginPage("/login")
                        .defaultSuccessUrl("/index", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // 로그아웃 후 리다이렉트 경로
                ); // 로그아웃은 기본설정으로 (/logout으로 인증해제)

        return http.build();
    }
}
