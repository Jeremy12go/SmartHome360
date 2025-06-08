package backend.app.models.Dipositivos.Adaptadores;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Dipositivos.externos.LuzExterna;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity @Table(name = "luces_externas")
public class Adaptador_LuzE extends DispositivoBase {

    @JsonIgnore
    @Transient
    private LuzExterna luzExterna = new LuzExterna();


    @Override
    public void encender() {
        luzExterna.on();
    }

    @Override
    public void apagar() {
        luzExterna.off();
    }

    @Override
    public void ajustar() {
        luzExterna.dim();
    }

    @Override
    public void programar() {
        luzExterna.schedule();
    }

}

