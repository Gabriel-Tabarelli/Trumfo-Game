package net.weg.projeto.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.projeto.model.enuns.AtaqueEspecialEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtaqueEspecialDTO {
    @NotNull
    @Enumerated(EnumType.STRING)
    private AtaqueEspecialEnum nome;
}
