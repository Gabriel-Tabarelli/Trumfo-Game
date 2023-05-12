package net.weg.projeto.repository;

import net.weg.projeto.model.entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaRepository extends JpaRepository<Carta, String> {
}
