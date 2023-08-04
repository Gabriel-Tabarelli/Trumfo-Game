package net.weg.projeto.service;

import lombok.AllArgsConstructor;
import net.weg.projeto.model.entity.Carta;
import net.weg.projeto.model.entity.Jogador;
import net.weg.projeto.repository.JogadorRepository;
import net.weg.projeto.security.model.JogadorSecurity;
import net.weg.projeto.security.repository.JogadorSecurityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final JogadorSecurityRepository jogadorSecurityRepository;

    public Jogador create(Jogador jogador) {
        Jogador jogadorSalvo = jogadorRepository.save(jogador);
        jogadorSecurityRepository.save(new JogadorSecurity(jogadorSalvo));
        return jogadorSalvo;
    }

    public List<Jogador> readAll() {
        return jogadorRepository.findAll();
    }

    public Jogador readOne(String nome) {
        Optional<Jogador> jogadorOptional = jogadorRepository.findById(nome);
        if (jogadorOptional.isPresent()) {
            return jogadorOptional.get();
        }
        throw new RuntimeException("Objeto não encontrado");
    }

    public Jogador edit(Jogador jogador) {
        return create(jogador);
    }

    public String delete(String nome) {
        Jogador jogador = readOne(nome);
        jogadorRepository.delete(jogador);
        return "Deletou!";
    }

    public String addCarta(Jogador jogador, Carta carta) {
        jogador.getCartas().add(carta);
        jogadorRepository.save(jogador);
        return "Adicionou!";
    }

    public String rmCarta(Jogador jogador, Carta carta) {
        jogador.getCartas().remove(carta);
        jogadorRepository.save(jogador);
        return "Removeu!";
    }
}
