package net.weg.projeto.webSocket;

import net.weg.projeto.model.entity.Jogador;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class RequisicaoBatalhaController {

    @MessageMapping("/jogador/{id}/requisicao")
    @SendTo("/topic/jogador/{id}")
    public String requisicaoBatalha(Jogador jogador, @DestinationVariable String id) {
        return new RequisicaoBatalha(jogador).requesicao();
    }
}
