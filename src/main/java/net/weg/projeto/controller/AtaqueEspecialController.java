package net.weg.projeto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.projeto.model.dto.AtaqueEspecialDTO;
import net.weg.projeto.model.entity.AtaqueEspecial;
import net.weg.projeto.service.AtaqueEspecialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/ataque-especial")
@CrossOrigin(origins = "*")
public class AtaqueEspecialController {

    private AtaqueEspecialService ataqueEspecialService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AtaqueEspecialDTO ataqueEspecialDTO) {
        if (ataqueEspecialDTO.getNome() != null) {
            AtaqueEspecial ataqueEspecial = new AtaqueEspecial(ataqueEspecialDTO.getNome());
            return ResponseEntity.ok(ataqueEspecialService.create(ataqueEspecial));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ataque especial não informado");
    }

    @GetMapping
    public ResponseEntity<List<AtaqueEspecial>> readAll() {
        return ResponseEntity.ok(ataqueEspecialService.readAll());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<AtaqueEspecial> readOne(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(ataqueEspecialService.readOne(nome));
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<String> delete(@PathVariable String nome) {
        return ResponseEntity.ok(ataqueEspecialService.delete(nome));
    }

}
