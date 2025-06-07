package backend.app.services;

import backend.app.models.Dipositivos.internos.Luz;
import backend.app.models.Usuario.Usuario;
import backend.app.repositories.LuzRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LuzService {

    private final LuzRepository luzRepository;


    public Luz registrar(Luz luz) {
        return luzRepository.save(luz);
    }

    public Optional<Luz> obtenerPorId(String id) {
        return luzRepository.findById(id);
    }

    public List<Luz> listar() {
        return luzRepository.findAll();
    }

}
