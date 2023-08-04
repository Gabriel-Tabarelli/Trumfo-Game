package net.weg.projeto.security.repository;

import net.weg.projeto.security.model.JogadorSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorSecurityRepository extends JpaRepository<JogadorSecurity, Long> {

    JogadorSecurity findByJogador_Nome(String nome);

}
