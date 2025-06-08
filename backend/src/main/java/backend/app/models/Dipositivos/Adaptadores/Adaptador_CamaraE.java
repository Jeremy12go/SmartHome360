package backend.app.models.Dipositivos.Adaptadores;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Dipositivos.externos.CamaraExterna;
import backend.app.models.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity @Table(name = "camaras_externas")
public class Adaptador_CamaraE extends DispositivoBase {

    @JsonIgnore
    @Transient
    private CamaraExterna camaraExterna;


    public Adaptador_CamaraE(String id, String nombre, Usuario usuario) {
        super(id, nombre, usuario);
    }

    public Adaptador_CamaraE() {}


    @Override
    public void encender() {
        camaraExterna.on();
    }

    @Override
    public void apagar() {
        camaraExterna.off();
    }

    @Override
    public void ajustar() {
        camaraExterna.dim();
    }

    @Override
    public void programar() {
        camaraExterna.schedule();
    }

}
