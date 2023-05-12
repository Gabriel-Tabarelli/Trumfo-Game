package net.weg.projeto.carta;

import net.weg.projeto.controller.CartaController;
import net.weg.projeto.service.CartaService;
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

@WebMvcTest(CartaController.class)
public class CartaDeleteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartaService service;

    @Test
    public void delete_retornaString() throws Exception{
        String idCarta = "id";
        String retorno = "Deletou!";

        when(service.delete(any())).thenReturn(retorno);

        mockMvc.perform(delete("/carta/{id}", idCarta)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(retorno));
    }
}
