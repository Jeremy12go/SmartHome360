package backend.app.repositories;

import backend.app.models.Dipositivos.internos.Termostato;
import backend.app.models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TermostatoRepository extends JpaRepository<Termostato, String> {
    List<Termostato> findByUsuario(Usuario user);
    Optional<Termostato> findByIdAndUsuario(String id, Usuario user);
}
