package net.weg.projeto.carta;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.weg.projeto.controller.CartaController;
import net.weg.projeto.model.dto.CartaDTO;
import net.weg.projeto.model.entity.Carta;
import net.weg.projeto.model.enuns.CartaPadraoEnum;
import net.weg.projeto.service.CartaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartaController.class)
public class CartaCreateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartaService cartaService;

    @Test
    public void create_retornaCartaOuString() throws Exception {

        CartaDTO cartaDTO = new CartaDTO(CartaPadraoEnum.GAMBA);
        Carta carta = new Carta(CartaPadraoEnum.GAMBA);

        when(cartaService.create(any())).thenReturn(carta);

        mockMvc.perform(post("/carta")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cartaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(carta));
    }
}
