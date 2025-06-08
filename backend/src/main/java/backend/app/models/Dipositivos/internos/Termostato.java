package backend.app.models.Dipositivos.internos;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Usuario.Usuario;
import jakarta.persistence.*;

@Entity @Table(name = "termostatos")
public class Termostato extends DispositivoBase {


    public Termostato(String id, String nombre, Usuario usuario) {
        super(id, nombre, usuario);
    }

    public Termostato() {}


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
