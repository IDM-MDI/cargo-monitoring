package by.ishangulyyev.backend.security;

import by.ishangulyyev.backend.entity.Authentication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static by.ishangulyyev.backend.validator.JwtValidator.isHeaderBearerExist;
import static by.ishangulyyev.backend.validator.JwtValidator.isUsernameExist;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (!isHeaderBearerExist(authHeader)) {
            log.info("Bearer doesnt exist");
            filterChain.doFilter(request, response);
            return;
        }
        String jwt = authHeader.substring(7);
        String username = jwtService.extractUsername(jwt);
        log.info("Username: " + username);
        if (isUsernameExist(username)) {
            Authentication user = (Authentication) userDetailsService.loadUserByUsername(username);
            if (jwtService.isTokenValid(jwt, user)) {
                log.info(user.getAuthorities().toString());
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
