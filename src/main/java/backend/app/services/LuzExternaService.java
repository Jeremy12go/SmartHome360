package backend.app.services;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_LuzE;
import backend.app.repositories.LuzExternaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LuzExternaService {

    private final LuzExternaRepository luzExternaRepository;

    public Adaptador_LuzE registrar(Adaptador_LuzE luzExterna) {
        return luzExternaRepository.save(luzExterna);
    }

    public Optional<Adaptador_LuzE> obtenerPorId(String id) {
        return luzExternaRepository.findById(id);
    }

    public List<Adaptador_LuzE> listar() {
        return luzExternaRepository.findAll();
    }
}
