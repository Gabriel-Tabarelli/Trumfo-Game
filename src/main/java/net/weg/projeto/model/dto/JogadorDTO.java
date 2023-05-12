package net.weg.projeto.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.projeto.model.entity.Carta;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorDTO {
    @NotNull
    private String nome;
    @NotNull
    private String senha;
    private int pontos;
    private List<Carta> cartas;
}
