package backend.app.controllers;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_AsistenciaVE;
import backend.app.models.Dipositivos.Adaptadores.Adaptador_CamaraE;
import backend.app.models.Dipositivos.internos.AsistenteVirtual;
import backend.app.models.Dipositivos.internos.Luz;
import backend.app.models.Usuario.Usuario;
import backend.app.repositories.AsistenteVirtualExternaRepository;
import backend.app.repositories.AsistenteVirtualRepository;
import backend.app.repositories.LuzExternaRepository;
import backend.app.repositories.LuzRepository;
import backend.app.services.AsistenteVirtualExternaService;
import backend.app.services.AsistenteVirtualService;
import backend.app.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController @RequiredArgsConstructor
@RequestMapping("/api/usuarios/{userId}/asistentes")
public class AsistenteVirtualController {

    private final UsuarioService usuarioService;
    private final AsistenteVirtualRepository asistenteVirtualRepository;
    private final AsistenteVirtualExternaRepository asistenteVirtualExternaRepository;

    @PostMapping
    public ResponseEntity<?> registrarAsistenteV(@PathVariable String userId, @RequestBody AsistenteVirtual asistenteVirtual) {

        Usuario user = usuarioService.buscarPorId(userId);
        asistenteVirtual.setUsuario(user);
        asistenteVirtualRepository.save(asistenteVirtual);
        return ResponseEntity.ok("Asistente virtual registrado correctamente al usuario " + user.getNombre());
    }

    @GetMapping
    public ResponseEntity<List<AsistenteVirtual>> obtenerAsistentesV(@PathVariable String userId) {
        Usuario user = usuarioService.buscarPorId(userId);
        List<AsistenteVirtual> asistentes = asistenteVirtualRepository.findByUsuario(user);
        return ResponseEntity.ok(asistentes);
    }

    @PostMapping("/externa")
    public ResponseEntity<?> registrarAsistenteVE(@PathVariable String userId, @RequestBody Adaptador_AsistenciaVE asistenteVirtualE) {

        Usuario user = usuarioService.buscarPorId(userId);
        asistenteVirtualE.setUsuario(user);
        asistenteVirtualExternaRepository.save(asistenteVirtualE);
        return ResponseEntity.ok("Asistente virtual externo registrado correctamente al usuario " + user.getNombre());
    }

    @GetMapping("/externa")
    public ResponseEntity<List<Adaptador_AsistenciaVE>> obtenerAsistentesVE(@PathVariable String userId) {
        Usuario user = usuarioService.buscarPorId(userId);
        List<Adaptador_AsistenciaVE> asistentesE = asistenteVirtualExternaRepository.findByUsuario(user);
        return ResponseEntity.ok(asistentesE);
    }
}
