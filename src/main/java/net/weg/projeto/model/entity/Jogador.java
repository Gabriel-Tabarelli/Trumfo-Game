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
public class Jogador implements UserDetails {

    // Atributos para o jogo
    @Id
    private String nome;
    private int pontos;
    @ManyToMany
    private List<Carta> cartas;

    // Atributos para o Spring Security
    private String senha;
    private List<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public Jogador(JogadorDTO jogadorDTO) {
        this.nome = jogadorDTO.getNome();
        this.pontos = jogadorDTO.getPontos();
        this.cartas = jogadorDTO.getCartas();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.senha = new BCryptPasswordEncoder().encode(jogadorDTO.getSenha());
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nome;
    }
}
