package net.weg.projeto.ataqueEspecial;

import net.weg.projeto.controller.AtaqueEspecialController;
import net.weg.projeto.service.AtaqueEspecialService;
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

@WebMvcTest(AtaqueEspecialController.class)
public class AtaqueEspecialDeleteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtaqueEspecialService service;

    @Test
    public void delete_retornaString() throws Exception{
        String idAtaqueEspecial = "id";
        String retorno = "Deletou!";

        when(service.delete(any())).thenReturn(retorno);

        mockMvc.perform(delete("/ataque-especial/{id}", idAtaqueEspecial)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(retorno));
    }
}
