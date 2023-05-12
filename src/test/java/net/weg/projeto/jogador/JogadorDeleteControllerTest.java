package net.weg.projeto.jogador;

import net.weg.projeto.controller.JogadorController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JogadorController.class)
public class JogadorDeleteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JogadorService service;

    @MockBean
    private CartaService cartaService;

    @Test
    public void delete_retornaString() throws Exception{

        String idJogador = "id";
        String retorno = "Deletou!";
        when(service.delete(any())).thenReturn(retorno);

        mockMvc.perform(delete("/jogador/{id}", idJogador)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(retorno));
    }
}
