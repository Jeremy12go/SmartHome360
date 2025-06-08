package backend.app.services;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_CamaraE;
import backend.app.repositories.CamaraExternaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class CamaraExternaService {

    private final CamaraExternaRepository camaraExternaRepository;

    public Adaptador_CamaraE registrar(Adaptador_CamaraE camaraExterna) {
        return camaraExternaRepository.save(camaraExterna);
    }

    public Optional<Adaptador_CamaraE> obtenerPorId(String id) {
        return camaraExternaRepository.findById(id);
    }

    public List<Adaptador_CamaraE> listar() {
        return camaraExternaRepository.findAll();
    }
}
