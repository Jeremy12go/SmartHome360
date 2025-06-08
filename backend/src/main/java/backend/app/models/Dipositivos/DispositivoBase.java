package backend.app.models.Dipositivos;

import backend.app.models.Modos.ModoOperacion;
import backend.app.models.Usuario.Observador;
import backend.app.models.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity @Inheritance(strategy = InheritanceType.JOINED)
public abstract class DispositivoBase implements Dispositivo {

    @Id
    private String id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @Transient
    protected ModoOperacion estado;

    @Transient
    protected Observador suscriptor;


    protected DispositivoBase(String id, String nombre, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    protected DispositivoBase() {}

    // Métodos default para Observer y modo.
    @Override
    public void cambiarModo(ModoOperacion modo) {
        this.estado = modo;
    }

    @Override
    public void activarModo(String dato) {
        if(estado!=null){
            estado.aplicar(dato);
        }
    }

    @Override
    public void registrar(Observador suscriptor) {
        this.suscriptor = suscriptor;
    }

    @Override
    public void notificar() {
        suscriptor.actualizar("Evento de asistente virtual detectado");
    }
}
