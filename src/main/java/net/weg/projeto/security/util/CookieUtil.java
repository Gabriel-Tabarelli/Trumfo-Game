package net.weg.projeto.security.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import net.weg.projeto.model.entity.Jogador;
import org.springframework.web.util.WebUtils;

import static java.util.Objects.nonNull;

public class CookieUtil {

    public static Cookie gerarCookie(Jogador jogador) {
        String token = JWTUtil.gerarToken(jogador);
        Cookie cookie = new Cookie("JWT", token); // Cria um cookie com o nome "JWT" e o valor do token
        cookie.setPath("/"); // O cookie será enviado para todas as requisições
        cookie.setMaxAge(1800); // O cookie expirará em 30 minutos
        return cookie;
    }

    public static String getToken(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "JWT");
        if (nonNull(cookie)) return cookie.getValue();
        throw new RuntimeException("Cookie JWT não encontrado");
    }

}
