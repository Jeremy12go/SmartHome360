package backend.app.services;

import backend.app.models.Dipositivos.internos.Termostato;
import backend.app.repositories.TermostatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TermostatoService {

    private final TermostatoRepository termostatoRepository;

    public Termostato registrar(Termostato termostato) {
        return termostatoRepository.save(termostato);
    }

    public Optional<Termostato> obtenerPorId(String id) {
        return termostatoRepository.findById(id);
    }

    public List<Termostato> listar() {
        return termostatoRepository.findAll();
    }
}
