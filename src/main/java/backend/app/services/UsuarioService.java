package backend.app.services;

import backend.app.models.Comandos.*;
import backend.app.models.Dipositivos.Dispositivo;
import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Modos.*;
import backend.app.models.Usuario.Usuario;
import backend.app.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final LuzRepository luzRepository;
    private final CamaraRepository camaraRepository;
    private final TermostatoRepository termostatoRepository;
    private final AsistenteVirtualRepository asistenteVirtualRepository;
    private final LuzExternaRepository luzExternaRepository;
    private final CamaraExternaRepository camaraExternaRepository;
    private final TermostatoExternaRepository termostatoExternaRepository;
    private final AsistenteVirtualExternaRepository asistenteVirtualExternaRepository;

    public void registrar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
    public Usuario buscarPorId(String  userId) {
        return usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public boolean ejecutarComando(String usuarioId, String tipoComando, String tipoDispositivo, String dispositivoId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isEmpty()) return false;

        Dispositivo dispositivo = obtenerDispositivoDelUsuario(usuarioOpt.get(), tipoDispositivo, dispositivoId);
        if (dispositivo == null) return false;

        Comando comando = switch (tipoComando.toLowerCase()) {
            case "encender" -> new ComandoEncender(dispositivo);
            case "apagar" -> new ComandoApagar(dispositivo);
            case "ajustar" -> new ComandoAjustar(dispositivo);
            case "programar" -> new ComandoProgramar(dispositivo);
            default -> null;
        };

        if (comando == null) return false;

        Usuario usuario = usuarioOpt.get();
        usuario.definirComando(comando);
        usuario.activarComando();
        return true;
    }

    public boolean cambiarModo(String usuarioId, String tipoDispositivo, String dispositivoId, String modo) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isEmpty()) return false;

        Dispositivo dispositivo = obtenerDispositivoDelUsuario(usuarioOpt.get(), tipoDispositivo, dispositivoId);
        if (dispositivo == null) return false;

        ModoOperacion nuevoModo = switch (modo.toLowerCase()) {
            case "noche" -> new ModoNoche();
            case "ahorro" -> new ModoAhorroEnergia();
            case "vacaciones" -> new ModoVacaciones();
            case "ausente" -> new ModoAusente();
            default -> null;
        };

        if (nuevoModo == null) return false;

        dispositivo.cambiarModo(nuevoModo);
        dispositivo.activarModo(tipoDispositivo);
        return true;
    }

    public boolean suscribirseAEvento(String usuarioId, String tipoDispositivo, String dispositivoId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isEmpty()) return false;

        Dispositivo dispositivo = obtenerDispositivoDelUsuario(usuarioOpt.get(), tipoDispositivo, dispositivoId);
        if (dispositivo == null) return false;

        dispositivo.registrar(usuarioOpt.get());
        return true;
    }

    private Dispositivo obtenerDispositivoDelUsuario(Usuario usuario, String tipo, String id) {
        return switch (tipo.toLowerCase()) {
            case "luz" -> luzRepository.findByIdAndUsuario(id, usuario).orElse(null);
            case "camara" -> camaraRepository.findByIdAndUsuario(id, usuario).orElse(null);
            case "termostato" -> termostatoRepository.findByIdAndUsuario(id, usuario).orElse(null);
            case "asistente virtual" -> asistenteVirtualRepository.findByIdAndUsuario(id, usuario).orElse(null);
            case "luz externa" -> luzExternaRepository.findByIdAndUsuario(id, usuario).orElse(null);
            case "camara externa" -> camaraExternaRepository.findByIdAndUsuario(id, usuario).orElse(null);
            case "termostato externa" -> termostatoExternaRepository.findByIdAndUsuario(id, usuario).orElse(null);
            case "asistente virtual externa" -> asistenteVirtualExternaRepository.findByIdAndUsuario(id, usuario).orElse(null);
            default -> null;
        };
    }
}

