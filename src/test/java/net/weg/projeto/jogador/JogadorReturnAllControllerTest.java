package net.weg.projeto.jogador;

import net.weg.projeto.controller.JogadorController;
import net.weg.projeto.model.entity.Jogador;
import net.weg.projeto.service.CartaService;
import net.weg.projeto.service.JogadorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JogadorController.class)
public class JogadorReturnAllControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JogadorService jogadorService;

    @MockBean
    private CartaService cartaService;

    @Test
    public void readAll_retornaListaJogador() throws Exception {
        List<Jogador> jogadores = new ArrayList<>();
        Jogador jogador = new Jogador("nome", "senha", 0, null);
        Jogador jogador2 = new Jogador("nome2", "senha2", 0, null);

        jogadores.add(jogador);
        jogadores.add(jogador2);

        when(jogadorService.readAll()).thenReturn(jogadores);

        mockMvc.perform(get("/jogador")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0]").value(jogador))
                .andExpect(jsonPath("$.[1]").value(jogador2));
    }
}
