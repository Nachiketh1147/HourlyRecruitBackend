package com.hourlyrecruit.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
	@Autowired
    private JWTService jwtService;
	@Autowired
    private UserDetailsService userDetailsService;


	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain filterChain)
	        throws ServletException, IOException {

	    String path = request.getServletPath();

	    // SKIP JWT CHECK FOR AUTH APIs
	    if (path.startsWith("/auth")) {
	        filterChain.doFilter(request, response);
	        return;
	    }

	    final String authHeader = request.getHeader("Authorization");

	    // NO TOKEN
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        filterChain.doFilter(request, response);
	        return;
	    }

	    final String jwt = authHeader.substring(7);

	    try {

	        final String userEmail = jwtService.extractUsername(jwt);

	        // CHECK SECURITY CONTEXT
	        if (userEmail != null &&
	                SecurityContextHolder.getContext().getAuthentication() == null) {

	            UserDetails userDetails =
	                    userDetailsService.loadUserByUsername(userEmail);

	            // VALIDATE TOKEN
	            if (jwtService.isTokenValid(jwt, userDetails)) {

	                UsernamePasswordAuthenticationToken authToken =
	                        new UsernamePasswordAuthenticationToken(
	                                userDetails,
	                                null,
	                                userDetails.getAuthorities()
	                        );

	                authToken.setDetails(
	                        new WebAuthenticationDetailsSource()
	                                .buildDetails(request)
	                );

	                SecurityContextHolder.getContext()
	                        .setAuthentication(authToken);
	            }
	        }

	    } catch (Exception e) {

	        System.out.println("JWT Error: " + e.getMessage());

	        // OPTIONAL:
	        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT");
	        // return;
	    }

	    filterChain.doFilter(request, response);
	}
}