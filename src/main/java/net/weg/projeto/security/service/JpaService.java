package net.weg.projeto.security.service;

import net.weg.projeto.security.repository.JogadorSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaService implements UserDetailsService {

    private final JogadorSecurityRepository repository;

    @Autowired
    public JpaService(JogadorSecurityRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        return repository.findByJogador_Nome(nome);
    }

}
