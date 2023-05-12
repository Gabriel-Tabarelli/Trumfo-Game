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

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JogadorController.class)
public class JogadorReturnOneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JogadorService jogadorService;

    @MockBean
    private CartaService cartaService;

    @Test
    public void returnOne_retornaJogador() throws Exception{
        Jogador jogador = new Jogador("nome", "senha", 0, null);

        when(jogadorService.readOne("nome")).thenReturn(jogador);

        mockMvc.perform(get("/jogador/{id}", jogador.getNome())
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(jogador))
                .andExpect(jsonPath("$.cartas").isEmpty());
    }

}
