package backend.app.services;

import backend.app.models.Dipositivos.internos.AsistenteVirtual;
import backend.app.repositories.AsistenteVirtualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class AsistenteVirtualService {

    private final AsistenteVirtualRepository asistenteVirtualRepository;

    public AsistenteVirtual registrar(AsistenteVirtual asistenteVirtual) {
        return asistenteVirtualRepository.save(asistenteVirtual);
    }

    public Optional<AsistenteVirtual> obtenerPorId(String id) {
        return asistenteVirtualRepository.findById(id);
    }

    public List<AsistenteVirtual> listar() {
        return asistenteVirtualRepository.findAll();
    }
}
