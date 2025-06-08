package backend.app.controllers;

import backend.app.models.Dipositivos.Adaptadores.Adaptador_TermostatoE;
import backend.app.models.Dipositivos.internos.Luz;
import backend.app.models.Dipositivos.internos.Termostato;
import backend.app.models.Usuario.Usuario;
import backend.app.repositories.LuzExternaRepository;
import backend.app.repositories.LuzRepository;
import backend.app.repositories.TermostatoExternaRepository;
import backend.app.repositories.TermostatoRepository;
import backend.app.services.TermostatoExternaService;
import backend.app.services.TermostatoService;
import backend.app.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/usuarios/{userId}/termostatos")
public class TermostatoController {

    private final UsuarioService usuarioService;
    private final TermostatoRepository termostatoRepository;
    private final TermostatoExternaRepository termostatoExternaRepository;

    @PostMapping
    public ResponseEntity<?> registrarTermostato(@PathVariable String userId, @RequestBody Termostato termostato) {

        Usuario user = usuarioService.buscarPorId(userId);
        termostato.setUsuario(user);
        termostatoRepository.save(termostato);
        return ResponseEntity.ok("Termostato registrado correctamente al usuario " + user.getNombre());
    }

    @GetMapping
    public ResponseEntity<List<Termostato>> obtenerTermostatos(@PathVariable String userId) {
        Usuario user = usuarioService.buscarPorId(userId);
        List<Termostato> termostatos = termostatoRepository.findByUsuario(user);
        return ResponseEntity.ok(termostatos);
    }

    @PostMapping("/externa")
    public ResponseEntity<?> registrarTermostatoE(@PathVariable String userId, @RequestBody Adaptador_TermostatoE termostatoE) {

        Usuario user = usuarioService.buscarPorId(userId);
        termostatoE.setUsuario(user);
        termostatoExternaRepository.save(termostatoE);
        return ResponseEntity.ok("Termostato externo registrado correctamente al usuario " + user.getNombre());
    }

    @GetMapping("/externa")
    public ResponseEntity<List<Adaptador_TermostatoE>> obtenerTermostatosE(@PathVariable String userId) {
        Usuario user = usuarioService.buscarPorId(userId);
        List<Adaptador_TermostatoE> termostatosE = termostatoExternaRepository.findByUsuario(user);
        return ResponseEntity.ok(termostatosE);
    }
}
