package backend.app.models.Dipositivos.Adaptadores;

import backend.app.models.Dipositivos.DispositivoBase;
import backend.app.models.Dipositivos.externos.TermostatoExterna;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity @Table(name = "termostatos_externos")
public class Adaptador_TermostatoE extends DispositivoBase {

    @JsonIgnore
    @Transient
    private TermostatoExterna termostatoExterna;


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
