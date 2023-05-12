package net.weg.projeto.jogador;

import net.weg.projeto.controller.JogadorController;
import net.weg.projeto.model.dto.JogadorDTO;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JogadorController.class)
public class JogadorCreateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JogadorService service;

    @MockBean
    private CartaService cartaService;

    @Test
    public void create_retornaJogador() throws Exception{

        String nome = "nome";
        String senha = "senha";
        int pontos = 0;
        List<Carta> cartas = new ArrayList<>();
        cartas.add(new Carta(CartaPadraoEnum.GAMBA));
        cartas.add(new Carta(CartaPadraoEnum.PORCOESPINHO));

        JogadorDTO jogadorDTO = new JogadorDTO(nome, senha, pontos, cartas);
        Jogador jogador = new Jogador(nome, senha, pontos, cartas);

        when(service.create(any())).thenReturn(jogador);

        mockMvc.perform(post("/jogador")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(jogadorDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(jogador));
    }

}
