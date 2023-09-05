package net.weg.projeto.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import net.weg.projeto.model.entity.Jogador;
import net.weg.projeto.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static String senhaForte = "c127a7b6adb013a5ff879ae71afa62afa4b4ceb72afaa54711dbcde67b6dc325";
    private static JogadorRepository repository;

    @Autowired
    public JWTUtil(JogadorRepository repository) {
        JWTUtil.repository = repository;
    }

    public static String gerarToken(Jogador jogador) {
        return JWT.create()
                .withIssuer("WEG") // Emissor do token
                .withSubject(jogador.getUsername()) // "Nome" do token
                .withIssuedAt(new Date()) // Data da emissão
                .withExpiresAt(new Date(new Date().getTime() + 1800000)) // Data da expiração
                .sign(Algorithm.HMAC256(senhaForte)); // Criptografia
    }

    public static Jogador getJogador(String token) {
        String username = JWT.decode(token).getSubject();
        return repository.findJogadorByNome(username);
    }

}
