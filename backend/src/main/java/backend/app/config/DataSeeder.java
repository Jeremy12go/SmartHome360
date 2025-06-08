package backend.app.config;

import backend.app.models.Usuario.Usuario;
import backend.app.models.Dipositivos.internos.*;
import backend.app.models.Dipositivos.Adaptadores.*;
import backend.app.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataSeeder {
    
    private final UsuarioRepository usuarioRepository;
    private final LuzRepository luzRepository;
    private final LuzExternaRepository luzExternaRepository;
    private final CamaraRepository camaraRepository;
    private final CamaraExternaRepository camaraExternaRepository;
    private final TermostatoRepository termostatoRepository;
    private final TermostatoExternaRepository termostatoExternaRepository;
    private final AsistenteVirtualRepository asistenteVirtualRepository;
    private final AsistenteVirtualExternaRepository asistenteVirtualExternaRepository;

    @Bean
    public CommandLineRunner seedData() {
        return args -> {
            Usuario user1 = usuarioRepository.findById("u001").orElse(null);
            Usuario user2 = usuarioRepository.findById("u002").orElse(null);
            Usuario user3 = usuarioRepository.findById("u003").orElse(null);

            if (user1 != null && user2 != null && user3 != null) {
                luzRepository.save(new Luz("luz001", "Luz Cocina", user1));
                luzRepository.save(new Luz("luz002", "Luz Dormitorio", user1));
                luzRepository.save(new Luz("luz003", "Luz Garage", user3));

                luzExternaRepository.save(new Adaptador_LuzE("luze001", "Luz Cocina", user2));
                luzExternaRepository.save(new Adaptador_LuzE("luze002", "Luz Dormitorio", user2));
                luzExternaRepository.save(new Adaptador_LuzE("luze003", "Luz Garage", user3));
                
                camaraRepository.save(new Camara("cam001", "Camara Entrada", user1));
                camaraRepository.save(new Camara("cam002", "Camara Patio", user2));
               
                camaraExternaRepository.save(new Adaptador_CamaraE("came001", "Camara Entrada", user2));
                camaraExternaRepository.save(new Adaptador_CamaraE("came002", "Camara Patio", user3));
                
                termostatoRepository.save(new Termostato("ter001", "Termostato Cocina", user1));
                termostatoRepository.save(new Termostato("ter002", "Termostato Living", user1));

                termostatoExternaRepository.save(new Adaptador_TermostatoE("tere001", "Termostato Cocina", user2));
                termostatoExternaRepository.save(new Adaptador_TermostatoE("tere002", "Termostato Living", user3));
                
                asistenteVirtualRepository.save(new AsistenteVirtual("asi001", "Asistente Siri", user1));
                asistenteVirtualRepository.save(new AsistenteVirtual("asi002", "Asistente Alexa", user2));
                
                asistenteVirtualExternaRepository.save(new Adaptador_AsistenciaVE("asie001", "Asistente Siri", user2));
                asistenteVirtualExternaRepository.save(new Adaptador_AsistenciaVE("asie002", "Asistente Alexa", user3));
                
            }
        };
    }
}