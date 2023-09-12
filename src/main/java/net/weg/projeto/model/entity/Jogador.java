package net.weg.projeto.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.projeto.model.dto.JogadorDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jogador {

    // Atributos para o jogo
    @Id
    private String nome;
    private int pontos;
    @ManyToMany
    private List<Carta> cartas;

    public Jogador(JogadorDTO jogadorDTO) {
        this.nome = jogadorDTO.getNome();
        this.pontos = jogadorDTO.getPontos();
        this.cartas = jogadorDTO.getCartas();
    }

}
