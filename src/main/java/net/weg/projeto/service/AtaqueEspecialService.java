package net.weg.projeto.service;

import lombok.AllArgsConstructor;
import net.weg.projeto.model.entity.AtaqueEspecial;
import net.weg.projeto.repository.AtaqueEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AtaqueEspecialService {

    private AtaqueEspecialRepository ataqueEspecialRepository;

    public AtaqueEspecial create(AtaqueEspecial ataqueEspecial) {
        return ataqueEspecialRepository.save(ataqueEspecial);
    }

    public List<AtaqueEspecial> readAll() {
        return ataqueEspecialRepository.findAll();
    }

    public AtaqueEspecial readOne(String nome) {
        Optional<AtaqueEspecial> ataqueEspecialOptional = ataqueEspecialRepository.findById(nome);
        if (ataqueEspecialOptional.isPresent()) {
            return ataqueEspecialOptional.get();
        }
        throw new RuntimeException("Objeto não encontrado");
    }

    public String delete(String nome) {
        AtaqueEspecial ataqueEspecial = readOne(nome);
        ataqueEspecialRepository.delete(ataqueEspecial);
        return "Deletou!";
    }

}
