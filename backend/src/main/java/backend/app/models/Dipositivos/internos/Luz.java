package backend.app.models.Dipositivos.internos;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Usuario.Usuario;
import jakarta.persistence.*;

@Entity @Table(name = "luces")
public class Luz extends DispositivoBase {


    public Luz(String id, String nombre, Usuario usuario) {
        super(id, nombre, usuario);
    }

    public Luz() {}


    @Override
    public void encender() {
        System.out.println("Luz encendida");
    }

    @Override
    public void apagar() {
        System.out.println("Luz apagada");
    }

    @Override
    public void ajustar() {
        System.out.println("Luz ajustada");
    }

    @Override
    public void programar() {
        System.out.println("Luz programada");
    }
}
