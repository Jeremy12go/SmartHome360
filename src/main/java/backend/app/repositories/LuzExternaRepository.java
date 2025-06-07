package backend.app.repositories;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_LuzE;
import backend.app.models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LuzExternaRepository extends JpaRepository<Adaptador_LuzE, String>{
    List<Adaptador_LuzE> findByUsuario(Usuario user);
    Optional<Adaptador_LuzE> findByIdAndUsuario(String id, Usuario user);
}
