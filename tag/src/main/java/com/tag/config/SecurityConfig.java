package com.tag.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig{

    private final JwtRequestFilter jwtRequestFilter;

    /**
     * Security 기본 설정
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()      // http basic 인증 방법 비활성화
                .formLogin().disable()      // form 기반 로그인 비활성화
                .csrf().disable()           // csrf 관련 설정 비활성화
                .cors().disable()           // cors 관련 설정 비활성화
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()  // 현재는 모든 request 요청 혀용 TODO: 추후 권한 별 허용 예정
                .and()
                .addFilterBefore(jwtRequestFilter, BasicAuthenticationFilter.class);
        return http.build();
    }

    /**
     * 패스워드 인코더 설정
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
