package backend.app.repositories;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_TermostatoE;
import backend.app.models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TermostatoExternaRepository extends JpaRepository<Adaptador_TermostatoE, String> {
    List<Adaptador_TermostatoE> findByUsuario(Usuario user);
    Optional<Adaptador_TermostatoE> findByIdAndUsuario(String id, Usuario user);
}
