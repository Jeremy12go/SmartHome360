package backend.app.controllers;

import backend.app.models.Usuario.Usuario;
import backend.app.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
@RestController @RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.registrar(usuario);
        return ResponseEntity.ok("Usuario creado correctamente");
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable String id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping("/{id}/comando")
    public ResponseEntity<String> ejecutarComando(
            @PathVariable String id,
            @RequestParam String tipoComando,
            @RequestParam String tipoDispositivo,
            @RequestParam String dispositivoId) {

        return usuarioService.ejecutarComando(id, tipoComando, tipoDispositivo, dispositivoId)
                ? ResponseEntity.ok("Comando ejecutado")
                : ResponseEntity.badRequest().body("Error al ejecutar comando");
    }

    @PostMapping("/{id}/modo")
    public ResponseEntity<String> cambiarModo(
            @PathVariable String id,
            @RequestParam String tipoDispositivo,
            @RequestParam String dispositivoId,
            @RequestParam String modo) {

        return usuarioService.cambiarModo(id, tipoDispositivo, dispositivoId, modo)
                ? ResponseEntity.ok("Modo aplicado")
                : ResponseEntity.badRequest().body("Modo inválido o dispositivo no encontrado");
    }

    @PostMapping("/{id}/suscribirse")
    public ResponseEntity<String> suscribirse(
            @PathVariable String id,
            @RequestParam String tipoDispositivo,
            @RequestParam String dispositivoId) {

        return usuarioService.suscribirseAEvento(id, tipoDispositivo, dispositivoId)
                ? ResponseEntity.ok("Usuario suscrito a notificaciones")
                : ResponseEntity.badRequest().body("No se pudo suscribir");
    }
}