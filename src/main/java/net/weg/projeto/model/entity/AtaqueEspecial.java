package net.weg.projeto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.projeto.model.enuns.AtaqueEspecialEnum;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtaqueEspecial {
    @Id
    private String nome;
    @Column(length = 1000)
    private String descricao;

    public AtaqueEspecial(AtaqueEspecialEnum ataqueEspecialEnum) {
        this(ataqueEspecialEnum.nome, ataqueEspecialEnum.descricao);
    }
}
