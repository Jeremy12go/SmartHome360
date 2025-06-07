package backend.app.models.Dipositivos.internos;

import backend.app.models.Dipositivos.DispositivoBase;
import jakarta.persistence.*;

@Entity @Table(name = "asistentesvirtuales")
public class AsistenteVirtual extends DispositivoBase {

    @Override
    public void encender() {
        System.out.println("Asistente virtual encendido");
    }

    @Override
    public void apagar() {
        System.out.println("Asistente virtual apagado");
    }

    @Override
    public void ajustar() {
        System.out.println("Asistente virtual ajustado");
    }

    @Override
    public void programar() {
        System.out.println("Asistente virtual programado");
    }

}
