package backend.app.models.Dipositivos.internos;

import backend.app.models.Dipositivos.DispositivoBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity @Table(name = "camaras")
public class Camara extends DispositivoBase {

    @Override
    public void encender() {
        System.out.println("Camara encendido");
    }

    @Override
    public void apagar() {
        System.out.println("Camara apagado");
    }

    @Override
    public void ajustar() {
        System.out.println("Camara ajustado");
    }

    @Override
    public void programar() {
        System.out.println("Camara programado");
    }
}
