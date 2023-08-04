package net.weg.projeto.security.service;

import lombok.AllArgsConstructor;
import net.weg.projeto.security.repository.JogadorSecurityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaService implements UserDetailsService {

    private final JogadorSecurityRepository jogadorSecurityRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) {
        return jogadorSecurityRepository.findByJogador_Nome(nome);
    }

}
