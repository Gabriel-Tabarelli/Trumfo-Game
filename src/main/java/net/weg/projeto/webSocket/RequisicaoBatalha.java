package net.weg.projeto.webSocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.projeto.model.entity.Jogador;

@AllArgsConstructor
@Data
public class RequisicaoBatalha {

    private Jogador jogador;

}