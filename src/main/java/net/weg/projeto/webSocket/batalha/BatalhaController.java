package net.weg.projeto.webSocket.batalha;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class BatalhaController {

    @MessageMapping("/batalha/{id}")
    @SendTo("/topic/batalha/{id}")
    public String requisicaoBatalha(@Payload String mensagem) {
        return mensagem;
    }

}
