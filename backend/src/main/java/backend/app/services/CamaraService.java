package backend.app.services;

import backend.app.models.Dipositivos.internos.Camara;
import backend.app.repositories.CamaraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class CamaraService {
    private final CamaraRepository camaraRepository;

    public Camara registrar(Camara camara) {
        return camaraRepository.save(camara);
    }

    public Optional<Camara> obtenerPorId(String id) {
        return camaraRepository.findById(id);
    }

    public List<Camara> listar() {
        return camaraRepository.findAll();
    }
}
