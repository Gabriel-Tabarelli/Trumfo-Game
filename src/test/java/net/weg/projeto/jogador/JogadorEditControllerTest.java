package net.weg.projeto.jogador;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.weg.projeto.controller.JogadorController;
import net.weg.projeto.model.entity.Jogador;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JogadorController.class)
public class JogadorEditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JogadorService jogadorService;

    @MockBean
    private CartaService cartaService;

    @Test
    public void edit_retornaJogador() throws Exception {
        Jogador jogador = new Jogador("nome", "senha", 0, null);
        
        when(jogadorService.edit(any())).thenReturn(jogador);
        when(jogadorService.readOne(any())).thenReturn(jogador);
        
        mockMvc.perform(put("/jogador/{id}", jogador.getNome())
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(jogador)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(jogador));
        
    }
    
}
