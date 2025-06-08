package backend.app.repositories;

import backend.app.models.Dipositivos.internos.AsistenteVirtual;
import backend.app.models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AsistenteVirtualRepository extends JpaRepository<AsistenteVirtual, String> {
    List<AsistenteVirtual> findByUsuario(Usuario user);
    Optional<AsistenteVirtual> findByIdAndUsuario(String id, Usuario user);
}
