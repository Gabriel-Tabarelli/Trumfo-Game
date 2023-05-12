package net.weg.projeto.service;

import lombok.AllArgsConstructor;
import net.weg.projeto.model.entity.Carta;
import net.weg.projeto.repository.CartaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartaService {

    private CartaRepository cartaRepository;

    public Carta create(Carta carta) {
        return cartaRepository.save(carta);
    }

    public List<Carta> readAll() {
        return cartaRepository.findAll();
    }

    public Carta readOne(String nome) {
        Optional<Carta> cartaOptional = cartaRepository.findById(nome);
        if (cartaOptional.isPresent()) {
            return cartaOptional.get();
        }
        throw new RuntimeException("Objeto não encontrado");
    }

    public Carta edit(Carta carta) {
        return create(carta);
    }

    public String delete(String nome) {
        Carta carta = readOne(nome);
        cartaRepository.delete(carta);
        return "Deletou!";
    }
}
