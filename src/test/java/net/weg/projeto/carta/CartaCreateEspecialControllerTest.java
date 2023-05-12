package net.weg.projeto.carta;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.weg.projeto.controller.CartaController;
import net.weg.projeto.model.dto.CartaEspecialDTO;
import net.weg.projeto.model.entity.AtaqueEspecial;
import net.weg.projeto.model.entity.Carta;
import net.weg.projeto.model.enuns.AtaqueEspecialEnum;
import net.weg.projeto.service.CartaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartaController.class)
public class CartaCreateEspecialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartaService cartaService;

    @Test
    public void create_retornaCarta() throws Exception {

        CartaEspecialDTO cartaDTO = new CartaEspecialDTO("nome", "descricao", 1, 1, true, new AtaqueEspecial(AtaqueEspecialEnum.CRESCIMENTOSUPREMO));
        Carta carta = new Carta("nome", "descricao", 1, 1, true, new AtaqueEspecial(AtaqueEspecialEnum.CRESCIMENTOSUPREMO));

        when(cartaService.create(any())).thenReturn(carta);

        mockMvc.perform(post("/carta/especial")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cartaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(carta));
    }

}
