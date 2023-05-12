package net.weg.projeto.ataqueEspecial;

import net.weg.projeto.controller.AtaqueEspecialController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AtaqueEspecialController.class)
public class AtaqueEspecialReturnOneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtaqueEspecialService AtaqueEspecialService;

    @Test
    public void returnOne_retornaAtaqueEspecial() throws Exception{
        AtaqueEspecial ataqueEspecial = new AtaqueEspecial(AtaqueEspecialEnum.PEIDOENFRAQUECEDOR);

        when(AtaqueEspecialService.readOne(any())).thenReturn(ataqueEspecial);

        mockMvc.perform(get("/ataque-especial/{id}", ataqueEspecial.getNome())
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(ataqueEspecial));
    }
}
