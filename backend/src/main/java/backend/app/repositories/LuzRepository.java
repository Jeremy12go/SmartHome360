package backend.app.repositories;

import backend.app.models.Dipositivos.internos.Luz;
import backend.app.models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LuzRepository extends JpaRepository<Luz, String> {
    List<Luz> findByUsuario(Usuario user);
    Optional<Luz> findByIdAndUsuario(String id, Usuario user);
}

