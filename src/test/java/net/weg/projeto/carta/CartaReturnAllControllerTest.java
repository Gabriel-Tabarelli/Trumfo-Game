package net.weg.projeto.carta;

import net.weg.projeto.controller.CartaController;
import net.weg.projeto.model.entity.Carta;
import net.weg.projeto.model.enuns.CartaPadraoEnum;
import net.weg.projeto.service.CartaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartaController.class)
public class CartaReturnAllControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartaService cartaService;

    @Test
    public void readAll_retornaListaJogador() throws Exception {

        List<Carta> cartas = new ArrayList<>();
        Carta carta = new Carta(CartaPadraoEnum.GAMBA);
        Carta carta2 = new Carta(CartaPadraoEnum.PORCOESPINHO);

        cartas.add(carta);
        cartas.add(carta2);

        when(cartaService.readAll()).thenReturn(cartas);

        mockMvc.perform(get("/carta")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0]").value(carta))
                .andExpect(jsonPath("$.[1]").value(carta2));
    }
}
