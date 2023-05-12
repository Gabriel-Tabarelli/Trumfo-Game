package net.weg.projeto.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.projeto.model.entity.AtaqueEspecial;

@AllArgsConstructor
@Data
public class CartaEspecialDTO {
    @NotNull
    private String nome;
    @NotNull
    private String descricao;
    @NotNull
    private int ataque;
    @NotNull
    @Positive
    private int vida;
    @NotNull
    private boolean cartaEspecial;
    @NotNull
    private AtaqueEspecial ataqueEspecial;
}
