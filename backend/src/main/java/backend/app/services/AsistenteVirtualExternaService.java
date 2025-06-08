package backend.app.services;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_AsistenciaVE;
import backend.app.repositories.AsistenteVirtualExternaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class AsistenteVirtualExternaService {

    private final AsistenteVirtualExternaRepository asistenteVirtualExternaRepository;

    public Adaptador_AsistenciaVE registrar(Adaptador_AsistenciaVE asistenteVirtualExterna) {
        return asistenteVirtualExternaRepository.save(asistenteVirtualExterna);
    }

    public Optional<Adaptador_AsistenciaVE> obtenerPorId(String id) {
        return asistenteVirtualExternaRepository.findById(id);
    }

    public List<Adaptador_AsistenciaVE> listar() {
        return asistenteVirtualExternaRepository.findAll();
    }
}
