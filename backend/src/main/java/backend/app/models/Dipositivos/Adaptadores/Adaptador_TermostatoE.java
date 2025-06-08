package backend.app.models.Dipositivos.Adaptadores;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Dipositivos.externos.TermostatoExterna;

import backend.app.models.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity @Table(name = "termostatos_externos")
public class Adaptador_TermostatoE extends DispositivoBase {

    @JsonIgnore
    @Transient
    private TermostatoExterna termostatoExterna;


    public Adaptador_TermostatoE(String id, String nombre, Usuario usuario) {
        super(id, nombre, usuario);
    }

    public Adaptador_TermostatoE() {}


    @Override
    public void encender() {
        termostatoExterna.on();
    }

    @Override
    public void apagar() {
        termostatoExterna.off();
    }

    @Override
    public void ajustar() {
        termostatoExterna.dim();
    }

    @Override
    public void programar() {
        termostatoExterna.schedule();
    }

}
