package net.weg.projeto.ataqueEspecial;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.weg.projeto.controller.AtaqueEspecialController;
import net.weg.projeto.model.dto.AtaqueEspecialDTO;
import net.weg.projeto.model.entity.AtaqueEspecial;
import net.weg.projeto.model.enuns.AtaqueEspecialEnum;
import net.weg.projeto.service.AtaqueEspecialService;
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

@WebMvcTest(AtaqueEspecialController.class)
public class AtaqueEspecialCreateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtaqueEspecialService service;

    @Test
    public void create_retornaAtaqueEspecialOuString() throws Exception {
        AtaqueEspecialDTO AtaqueEspecialDTO = new AtaqueEspecialDTO(AtaqueEspecialEnum.CRESCIMENTOSUPREMO);
        AtaqueEspecial AtaqueEspecial = new AtaqueEspecial(AtaqueEspecialEnum.CRESCIMENTOSUPREMO);

        when(service.create(any())).thenReturn(AtaqueEspecial);

        mockMvc.perform(post("/ataque-especial")
                .contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(AtaqueEspecialDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(AtaqueEspecial));
    }

}
