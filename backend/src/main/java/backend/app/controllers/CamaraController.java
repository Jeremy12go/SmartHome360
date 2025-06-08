package backend.app.controllers;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_CamaraE;
import backend.app.models.Dipositivos.Adaptadores.Adaptador_LuzE;
import backend.app.models.Dipositivos.internos.Camara;
import backend.app.models.Dipositivos.internos.Luz;
import backend.app.models.Usuario.Usuario;
import backend.app.repositories.CamaraExternaRepository;
import backend.app.repositories.CamaraRepository;
import backend.app.services.CamaraExternaService;
import backend.app.services.CamaraService;
import backend.app.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/usuarios/{userId}/camaras")
public class CamaraController {

    private final UsuarioService usuarioService;
    private final CamaraRepository camaraRepository;
    private final CamaraExternaRepository camaraExternaRepository;

    @PostMapping
    public ResponseEntity<?> registrarCamara(@PathVariable String userId, @RequestBody Camara camara) {

        Usuario user = usuarioService.buscarPorId(userId);
        camara.setUsuario(user);
        camaraRepository.save(camara);
        return ResponseEntity.ok("Camara registrada correctamente al usuario " + user.getNombre());
    }

    @GetMapping
    public ResponseEntity<List<Camara>> obtenerCamaras(@PathVariable String userId) {
        Usuario user = usuarioService.buscarPorId(userId);
        List<Camara> camaras = camaraRepository.findByUsuario(user);
        return ResponseEntity.ok(camaras);
    }

    @PostMapping("/externa")
    public ResponseEntity<?> registrarCamaraE(@PathVariable String userId, @RequestBody Adaptador_CamaraE camaraE) {

        Usuario user = usuarioService.buscarPorId(userId);
        camaraE.setUsuario(user);
        camaraExternaRepository.save(camaraE);
        return ResponseEntity.ok("Camara externa registrada correctamente al usuario " + user.getNombre());
    }

    @GetMapping("/externa")
    public ResponseEntity<List<Adaptador_CamaraE>> obtenerCamarasE(@PathVariable String userId) {
        Usuario user = usuarioService.buscarPorId(userId);
        List<Adaptador_CamaraE> camaras = camaraExternaRepository.findByUsuario(user);
        return ResponseEntity.ok(camaras);
    }

}
