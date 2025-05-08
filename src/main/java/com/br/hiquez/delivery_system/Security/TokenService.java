package com.br.hiquez.delivery_system.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.br.hiquez.delivery_system.Entity.LoginGeral;
import com.br.hiquez.delivery_system.Exception.ErroTokenException;

@Service
public class TokenService {
    
    @Value("${jwt.secret}")
    private String secret;

    public String gerarToken(LoginGeral login){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                 .withIssuer("auth-api")
                 .withSubject(login.getEmail())
                 .withClaim("email", login.getEmail())
                 .withClaim("tipo", login.getTipo().name())
                 .withExpiresAt(new java.util.Date(System.currentTimeMillis() + 600000))
                 .sign(algorithm);
        }catch(ErroTokenException e){
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    public void validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWT.require(algorithm)
                .withIssuer("auth-api")
                .build()
                .verify(token);
        }catch(ErroTokenException e){
            throw new RuntimeException("Token inválido", e);
        }
    }
}
