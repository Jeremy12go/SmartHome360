package backend.app.models.Dipositivos.internos;

import backend.app.models.Dipositivos.DispositivoBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity @Table(name = "termostatos")
public class Termostato extends DispositivoBase {

    @Override
    public void encender() {
        System.out.println("Termostato encendido");
    }

    @Override
    public void apagar() {
        System.out.println("Termostato apagado");
    }

    @Override
    public void ajustar() {
        System.out.println("Termostato ajustado");
    }

    @Override
    public void programar() {
        System.out.println("Termostato programado");
    }
}
