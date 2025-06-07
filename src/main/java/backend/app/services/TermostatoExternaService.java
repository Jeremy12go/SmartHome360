package backend.app.services;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_TermostatoE;
import backend.app.repositories.TermostatoExternaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class TermostatoExternaService {

    private final TermostatoExternaRepository termostatoExternaRepository;

    public Adaptador_TermostatoE registrar(Adaptador_TermostatoE termostatoExterna) {
        return termostatoExternaRepository.save(termostatoExterna);
    }

    public Optional<Adaptador_TermostatoE> obtenerPorId(String id) {
        return termostatoExternaRepository.findById(id);
    }

    public List<Adaptador_TermostatoE> listar() {
        return termostatoExternaRepository.findAll();
    }
}
