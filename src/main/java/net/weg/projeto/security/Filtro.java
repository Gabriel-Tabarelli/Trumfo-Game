package net.weg.projeto.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.weg.projeto.model.entity.Jogador;
import net.weg.projeto.security.util.CookieUtil;
import net.weg.projeto.security.util.JWTUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class Filtro extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal( // Método para filtrar as requisições
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        if (rotaPrivada(request.getRequestURI())) {
            try {
                String token = CookieUtil.getToken(request); // Obter o token do cookie
                Jogador jogador = JWTUtil.getJogador(token); // Obter o usuário a partir do token
                response.addCookie(CookieUtil.gerarCookie(jogador)); // Regenerar o cookie com a data de expiração atualizada}
                Authentication authentication = new UsernamePasswordAuthenticationToken(jogador.getUsername(),
                        null, jogador.getAuthorities()); // Criar um objeto de autenticação
                SecurityContextHolder.getContext().setAuthentication(authentication); // Atualizar o contexto de segurança
            } catch (Exception e) { // Fazer o tratamento de exceções
                response.setStatus(401);
                response.getWriter().write("Erro");
                return;
            }
        }
        filterChain.doFilter(request, response); // Continuar o fluxo da requisição
    }

    private boolean rotaPrivada(String url) {
        return !List.of(
                "/login",
                "/jogador"
        ).contains(url);
    }

}
