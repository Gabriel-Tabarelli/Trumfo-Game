package net.weg.projeto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.projeto.model.dto.JogadorDTO;
import net.weg.projeto.model.entity.Carta;
import net.weg.projeto.model.entity.Jogador;
import net.weg.projeto.service.CartaService;
import net.weg.projeto.service.JogadorService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@AllArgsConstructor
@RequestMapping("/jogador")
@CrossOrigin(origins = "*")
public class JogadorController {

    private JogadorService jogadorService;

    private CartaService cartaService;

    @PostMapping
    public ResponseEntity<Jogador> create(@RequestBody @Valid JogadorDTO jogadorDTO) {
        Jogador jogador = new Jogador(jogadorDTO);
        return ok(jogadorService.create(jogador, jogadorDTO.getSenha()));
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> readAll() {
        return ok(jogadorService.readAll());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Jogador> readOne(@PathVariable String nome) {
        System.out.println(nome);
        return ok(jogadorService.readOne(nome));
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<String> delete(@PathVariable String nome) {
        return ok(jogadorService.delete(nome));
    }

    @PutMapping("/{nomeJogador}")
    public ResponseEntity<Jogador> edit(@RequestBody @Valid JogadorDTO jogadorDTO, @PathVariable String nomeJogador) {
        Jogador jogador = jogadorService.readOne(nomeJogador);
        BeanUtils.copyProperties(jogadorDTO, jogador);
        return ok(jogadorService.edit(jogador));
    }

    @PutMapping("/{nomeJogador}/addCarta/{nomeCarta}")
    public ResponseEntity<String> addCarta(@PathVariable String nomeJogador, @PathVariable String nomeCarta) {
        Jogador jogador = jogadorService.readOne(nomeJogador);
        Carta carta = cartaService.readOne(nomeCarta);
        return ok(jogadorService.addCarta(jogador, carta));
    }

    @PutMapping("/{nomeJogador}/rmCarta/{nomeCarta}")
    public ResponseEntity<String> rmCarta(@PathVariable String nomeJogador, @PathVariable String nomeCarta) {
        Jogador jogador = jogadorService.readOne(nomeJogador);
        Carta carta = cartaService.readOne(nomeCarta);
        return ok(jogadorService.rmCarta(jogador, carta));
    }
}
