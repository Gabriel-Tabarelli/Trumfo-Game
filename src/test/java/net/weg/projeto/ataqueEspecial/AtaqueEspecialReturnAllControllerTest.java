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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AtaqueEspecialController.class)
public class AtaqueEspecialReturnAllControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtaqueEspecialService AtaqueEspecialService;

    @Test
    public void readAll_retornaListaJogador() throws Exception {

        List<AtaqueEspecial> ataqueEspeciais = new ArrayList<>();
        AtaqueEspecial ataqueEspecial = new AtaqueEspecial(AtaqueEspecialEnum.PEIDOENFRAQUECEDOR);
        AtaqueEspecial ataqueEspecial2 = new AtaqueEspecial(AtaqueEspecialEnum.CRESCIMENTOSUPREMO);

        ataqueEspeciais.add(ataqueEspecial);
        ataqueEspeciais.add(ataqueEspecial2);

        when(AtaqueEspecialService.readAll()).thenReturn(ataqueEspeciais);

        mockMvc.perform(get("/ataque-especial")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0]").value(ataqueEspecial))
                .andExpect(jsonPath("$.[1]").value(ataqueEspecial2));
    }
}
