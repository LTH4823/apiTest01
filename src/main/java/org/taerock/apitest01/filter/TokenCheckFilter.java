package org.taerock.apitest01.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.taerock.apitest01.util.JWTUtil;

import java.io.IOException;

@Component
@Log4j2
@RequiredArgsConstructor
//OneOncePerRequestFilter spring security를 포함하는 라이브러리 입니다.
public class TokenCheckFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("---------------------------------------------------------------");
        log.info("JWTUTIL: " + jwtUtil);
        log.info("Token Check Filter");
        log.info("---------------------------------------------------------------");

        filterChain.doFilter(request, response);
    }
}
