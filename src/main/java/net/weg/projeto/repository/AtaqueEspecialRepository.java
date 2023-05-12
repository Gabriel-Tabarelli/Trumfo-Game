package net.weg.projeto.repository;

import net.weg.projeto.model.entity.AtaqueEspecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtaqueEspecialRepository extends JpaRepository<AtaqueEspecial, String> {
}
