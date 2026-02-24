package com.taskmanager.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.lang.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final com.taskmanager.services.CustomUserDetailsServices userDetailService;

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request, 
        @NonNull HttpServletResponse response, 
        @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        
                String header = request.getHeader("Authorization");
                
                if (header != null && header.startsWith("Bearer ")) {

                    String token = header.substring(7);

                    try {
                        String username = jwtUtil.extractUsername(token);

                        if (username != null
                            && SecurityContextHolder.getContext().getAuthentication() == null) {

                                UserDetails userDetails =
                                    userDetailService.loadUserByUsername(username);

                                    UsernamePasswordAuthenticationToken auth =
                                        new UsernamePasswordAuthenticationToken(
                                            userDetails, null, userDetails.getAuthorities()
                                        );

                                        auth.setDetails(
                                            new org.springframework.security.web.authentication.WebAuthenticationDetailsSource()
                                                .buildDetails(request)
                                        );

                                    SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                } catch (Exception e) {
                    // Handle token parsing or validation exceptions if necessary
                }   
    }

    filterChain.doFilter(request, response);
    }
}