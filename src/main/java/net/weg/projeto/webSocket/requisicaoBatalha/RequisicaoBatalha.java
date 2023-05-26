package net.weg.projeto.webSocket.requisicaoBatalha;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.projeto.model.entity.Jogador;

@AllArgsConstructor
@Data
public class RequisicaoBatalha {

    private Jogador jogador;

    public String requesicao() {
        return "O jogador " + jogador.getNome() + " quer batalhar com você!";
    }

}
