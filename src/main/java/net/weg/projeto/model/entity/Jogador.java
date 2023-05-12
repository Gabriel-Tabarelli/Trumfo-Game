package net.weg.projeto.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jogador {
    @Id
    private String nome;
    private String senha;
    private int pontos;
    @ManyToMany
    private List<Carta> cartas;
}
