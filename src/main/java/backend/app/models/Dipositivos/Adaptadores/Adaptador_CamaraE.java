package backend.app.models.Dipositivos.Adaptadores;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Dipositivos.externos.CamaraExterna;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity @Table(name = "camaras_externas")
public class Adaptador_CamaraE extends DispositivoBase {

    @JsonIgnore
    @Transient
    private CamaraExterna camaraExterna;

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
