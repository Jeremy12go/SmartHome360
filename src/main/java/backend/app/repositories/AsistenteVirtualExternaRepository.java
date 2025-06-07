package backend.app.repositories;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_AsistenciaVE;
import backend.app.models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AsistenteVirtualExternaRepository extends JpaRepository<Adaptador_AsistenciaVE, String> {
    List<Adaptador_AsistenciaVE> findByUsuario(Usuario user);
    Optional<Adaptador_AsistenciaVE> findByIdAndUsuario(String id, Usuario user);
}
