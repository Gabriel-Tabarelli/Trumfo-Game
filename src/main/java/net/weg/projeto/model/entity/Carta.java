package net.weg.projeto.model.entity;

import jakarta.persistence.*;
import lombok.*;
import net.weg.projeto.model.enuns.CartaPadraoEnum;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carta {
    @Id
    private String nome;
    private String descricao;
    private int ataque;
    private int vida;
    private boolean cartaEspecial;
    @ManyToOne
    private AtaqueEspecial ataqueEspecial;

    public Carta(CartaPadraoEnum cartaPadraoEnum) {
        this(cartaPadraoEnum.nome, cartaPadraoEnum.descricao, cartaPadraoEnum.ataque, cartaPadraoEnum.vida, false, cartaPadraoEnum.ataqueEspecial);
    }

}
