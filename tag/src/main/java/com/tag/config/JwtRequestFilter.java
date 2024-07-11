package com.tag.config;

import com.tag.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUtil jwtUtil;
    
    // TODO : Redis 추가

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final Cookie[] cookies = request.getCookies();
        String accessToken = null;
        String refreshToken = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    accessToken = cookie.getValue();
                } else if ("refreshToken".equals(cookie.getName())) {
                    refreshToken = cookie.getValue();
                }
            }
        }
//        TODO : Redis 추가 후 주석 풀기
//        if (accessToken != null && jwtUtil.validateToken(accessToken)) {
//            String username = jwtUtil.extractUsername(accessToken);
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                // AccessToken이 유효하고 사용자가 인증되지 않은 경우
//                JwtAuthenticationToken authentication = new JwtAuthenticationToken(username, null, null);
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        } else if (refreshToken != null && jwtUtil.validateToken(refreshToken)) {
//            // AccessToken이 없거나 유효하지 않은 경우 RefreshToken을 사용하여 새로운 AccessToken 발급
//            String username = jwtUtil.extractUsername(refreshToken);
//            String savedRefreshToken = redisService.getToken(username);
//            if (refreshToken.equals(savedRefreshToken)) {
//                String newAccessToken = jwtUtil.generateAccessToken(username);
//                addJwtTokenToCookie(response, "accessToken", newAccessToken, 5 * 60); // 5 minutes
//            } else {
//                redisService.deleteToken(username);
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                return;
//            }
//        }
//
//        chain.doFilter(request, response);
    }

    private void addJwtTokenToCookie(HttpServletResponse response, String name, String token, int maxAge) {
        Cookie cookie = new Cookie(name, token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // TODO : HTTPS를 사용할 경우 true로 설정
        cookie.setPath("/");
        cookie.setMaxAge(maxAge); // in seconds

        response.addCookie(cookie);
    }
}
