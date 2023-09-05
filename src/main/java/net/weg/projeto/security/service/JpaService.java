package net.weg.projeto.security.service;

import net.weg.projeto.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaService implements UserDetailsService {

    private final JogadorRepository repository;

    @Autowired
    public JpaService(JogadorRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        return repository.findJogadorByNome(nome);
    }

}
