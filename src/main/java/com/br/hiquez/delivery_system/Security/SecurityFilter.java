package com.br.hiquez.delivery_system.Security;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.br.hiquez.delivery_system.Exception.ErroFilterException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
                String token = recuperarToken(request);

                if(token == null){
                    filterChain.doFilter(request, response);
                    return;
                }

                try{
                    Algorithm algorithm = Algorithm.HMAC256(secret);
                    DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token);

                    String usuario = decodedJWT.getSubject();
                    String tipo = decodedJWT.getClaim("tipo").asString();

                    UserDetails userDetails = User.builder()
                    .username(usuario)
                    .password("")
                    .roles(tipo)
                    .build();

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    filterChain.doFilter(request, response);
                }catch(ErroFilterException e){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
            }

    private String recuperarToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if(header != null && header.startsWith("Bearer ")){
            return header.substring(7, header.length());
        }
        return null;
    }
}
