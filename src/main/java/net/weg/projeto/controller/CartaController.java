package net.weg.projeto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.projeto.model.dto.CartaEspecialDTO;
import net.weg.projeto.model.entity.Carta;
import net.weg.projeto.model.dto.CartaDTO;
import net.weg.projeto.service.CartaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Caminho: Web -> Controller -> Service -> Repository -> Service -> Controller - Web

@Controller
@AllArgsConstructor
@RequestMapping("/carta")
@CrossOrigin(origins = "*")
public class CartaController {

    private CartaService cartaService;

    @PostMapping("/especial")
    public ResponseEntity<Carta> create(@RequestBody @Valid CartaEspecialDTO cartaEspecialDTO) {
        Carta carta = new Carta();
        BeanUtils.copyProperties(cartaEspecialDTO, carta);
        return ResponseEntity.ok(cartaService.create(carta));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CartaDTO cartaDTO) {
        if (cartaDTO.getCartaPadraoEnum() != null) {
            Carta carta = new Carta(cartaDTO.getCartaPadraoEnum());
            return ResponseEntity.ok(cartaService.create(carta));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Carta padrão não informada");
    }

    @GetMapping
    public ResponseEntity<List<Carta>> readAll() {
        return ResponseEntity.ok(cartaService.readAll());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Carta> readOne(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK /*ou 200*/).body(cartaService.readOne(nome));
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<String> delete(@PathVariable String nome) {
        return ResponseEntity.ok(cartaService.delete(nome));
    }

    @PutMapping("/{nome}")
    public ResponseEntity<Carta> edit(@RequestBody @Valid CartaEspecialDTO cartaEspecialDTO, @PathVariable String nome) {
        Carta carta = cartaService.readOne(nome);
        BeanUtils.copyProperties(cartaEspecialDTO, carta);
        return ResponseEntity.ok(cartaService.edit(carta));
    }
}
