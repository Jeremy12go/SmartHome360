package backend.app.repositories;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_CamaraE;
import backend.app.models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CamaraExternaRepository extends JpaRepository<Adaptador_CamaraE, String> {
    List<Adaptador_CamaraE> findByUsuario(Usuario user);
    Optional<Adaptador_CamaraE> findByIdAndUsuario(String id, Usuario user);
}
