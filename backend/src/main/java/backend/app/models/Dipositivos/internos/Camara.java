package backend.app.models.Dipositivos.internos;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Usuario.Usuario;
import jakarta.persistence.*;

@Entity @Table(name = "camaras")
public class Camara extends DispositivoBase {


    public Camara(String id, String nombre, Usuario usuario) {
        super(id, nombre, usuario);
    }

    public Camara() {}


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
