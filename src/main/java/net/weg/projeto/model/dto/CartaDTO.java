package net.weg.projeto.model.dto;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.projeto.model.enuns.CartaPadraoEnum;

//DTO (Data Transfer Operation): uma classe com os mesmos atributos de outra, mas sem algum atributo que é provavelmente Auto_Increment

@Data //Getter and Setters, toString, etc.
@AllArgsConstructor //Construtor com todos os atributos
@NoArgsConstructor
public class CartaDTO {
    @NotNull
    @Enumerated(EnumType.STRING)
    private CartaPadraoEnum cartaPadraoEnum;
}

