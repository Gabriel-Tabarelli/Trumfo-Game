package net.weg.projeto.jogador;

import net.weg.projeto.controller.JogadorController;
import net.weg.projeto.model.entity.Carta;
import net.weg.projeto.model.entity.Jogador;
import net.weg.projeto.model.enuns.CartaPadraoEnum;
import net.weg.projeto.service.CartaService;
import net.weg.projeto.service.JogadorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JogadorController.class)
public class JogadorAddCartaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JogadorService jogadorservice;

    @MockBean
    private CartaService cartaService;

    @Test
    public void addCarta_retornaString() throws Exception {
        Carta carta = new Carta(CartaPadraoEnum.GAMBA);
        Jogador jogador = new Jogador("nome", "senha", 0, null);
        String retorno = "Adicionou";

        when(jogadorservice.addCarta(any(), any())).thenReturn(retorno);
        when(jogadorservice.readOne(any())).thenReturn(jogador);
        when(cartaService.readOne(any())).thenReturn(carta);

        mockMvc.perform(put("/jogador/{nomeJogador}/addCarta/{nomeCarta}", jogador.getNome(), carta.getNome())
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(retorno));
    }

}
