package backend.app.repositories;

import backend.app.models.Dipositivos.internos.Camara;
import backend.app.models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CamaraRepository extends JpaRepository<Camara, String> {
    List<Camara> findByUsuario(Usuario user);
    Optional<Camara> findByIdAndUsuario(String id, Usuario user);
}
