package backend.app.models.Dipositivos.Adaptadores;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Dipositivos.externos.AsistenteVirtualExterna;
import backend.app.models.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity @Table(name = "asistentes_externos")
public class Adaptador_AsistenciaVE extends DispositivoBase {

    @JsonIgnore
    @Transient
    private AsistenteVirtualExterna asistenteVirtualExterna;


    public Adaptador_AsistenciaVE(String id, String nombre, Usuario usuario) {
        super(id, nombre, usuario);
    }

    public Adaptador_AsistenciaVE() {}


    @Override
    public void encender() {
        asistenteVirtualExterna.on();
    }

    @Override
    public void apagar() {
        asistenteVirtualExterna.off();
    }

    @Override
    public void ajustar() {
        asistenteVirtualExterna.dim();
    }

    @Override
    public void programar() {
        asistenteVirtualExterna.schedule();
    }

}
