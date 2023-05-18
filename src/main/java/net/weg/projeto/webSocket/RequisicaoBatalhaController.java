package net.weg.projeto.webSocket;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class RequisicaoBatalhaController {

    @MessageMapping("/jogador/{id}")
    @SendTo("/topic/jogador/{id}")
    public String requisicaoBatalha(@Payload String mensagem) {
        return mensagem;
    }
}
