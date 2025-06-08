package backend.app.models.Dipositivos.internos;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Usuario.Usuario;
import jakarta.persistence.*;

@Entity @Table(name = "asistentesvirtuales")
public class AsistenteVirtual extends DispositivoBase {


    public AsistenteVirtual(String id, String nombre, Usuario usuario) {
        super(id, nombre, usuario);
    }

    public AsistenteVirtual() {}


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
