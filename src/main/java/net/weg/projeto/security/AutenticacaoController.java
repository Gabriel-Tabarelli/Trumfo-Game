package net.weg.projeto.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
@CrossOrigin
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody Login login,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {
        SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
        UsernamePasswordAuthenticationToken token =
            new UsernamePasswordAuthenticationToken(login.nome, login.senha);
        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()) {
            System.out.println(authentication.getPrincipal());
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authentication);
            securityContextRepository.saveContext(securityContext, request, response);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(401).build();
    }

    public record Login(String nome, String senha) {
    }

}
