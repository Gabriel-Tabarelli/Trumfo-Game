package net.weg.projeto.carta;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CartaController.class)
public class CartaEditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartaService service;

    @Test
    public void edit_retornaCarta() throws Exception {
        Carta carta = new Carta(CartaPadraoEnum.GAMBA);
        
        when(service.edit(any())).thenReturn(carta);
        when(service.readOne(any())).thenReturn(carta);
        
        mockMvc.perform(put("/carta/{id}", carta.getNome())
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(carta)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(carta));
        
    }
    
}
