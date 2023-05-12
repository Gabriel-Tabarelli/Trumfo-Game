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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartaController.class)
public class CartaReturnOneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartaService cartaService;

    @Test
    public void returnOne_retornaCarta() throws Exception{
        Carta carta = new Carta(CartaPadraoEnum.GAMBA);

        when(cartaService.readOne(any())).thenReturn(carta);

        mockMvc.perform(get("/carta/{id}", carta.getNome())
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(carta));
    }

}
