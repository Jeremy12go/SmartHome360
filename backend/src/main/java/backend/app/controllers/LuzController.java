package backend.app.controllers;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_LuzE;
import backend.app.models.Dipositivos.internos.Luz;
import backend.app.models.Usuario.Usuario;
import backend.app.repositories.LuzExternaRepository;
import backend.app.repositories.LuzRepository;
import backend.app.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/usuarios/{userId}/luces")
public class LuzController {

    private final UsuarioService usuarioService;
    private final LuzRepository luzRepository;
    private final LuzExternaRepository luzExternaRepository;

    @PostMapping
    public ResponseEntity<?> registrarLuz(@PathVariable String userId, @RequestBody Luz luz) {

        Usuario user = usuarioService.buscarPorId(userId);
        luz.setUsuario(user);
        luzRepository.save(luz);
        return ResponseEntity.ok("Luz registrada correctamente al usuario " + user.getNombre());
    }

    @GetMapping
    public ResponseEntity<List<Luz>> obtenerLuces(@PathVariable String userId) {
        Usuario user = usuarioService.buscarPorId(userId);
        List<Luz> luces = luzRepository.findByUsuario(user);
        return ResponseEntity.ok(luces);
    }

    @PostMapping("/externa")
    public ResponseEntity<?> registrarLuzE(@PathVariable String userId, @RequestBody Adaptador_LuzE luzE) {

        Usuario user = usuarioService.buscarPorId(userId);
        luzE.setUsuario(user);
        luzExternaRepository.save(luzE);
        return ResponseEntity.ok("Luz externa registrada correctamente al usuario " + user.getNombre());
    }

    @GetMapping("/externa")
    public ResponseEntity<List<Adaptador_LuzE>> obtenerLucesE(@PathVariable String userId) {
        Usuario user = usuarioService.buscarPorId(userId);
        List<Adaptador_LuzE> luces = luzExternaRepository.findByUsuario(user);
        return ResponseEntity.ok(luces);
    }

}
