package net.weg.projeto.webSocket;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

public class RequisicaoBatalhaController {

    @MessageMapping("/jogador/{id}") // Não funciona!
    @SendTo("/topic/jogador/{id}")
    public String requisicaoBatalha(String mensagem, @DestinationVariable String id) {
        return HtmlUtils.htmlEscape(mensagem);
    }
}
