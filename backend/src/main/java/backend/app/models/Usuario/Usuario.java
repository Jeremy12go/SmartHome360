package backend.app.models.Usuario;

import backend.app.models.Comandos.Comando;
import backend.app.models.Dipositivos.Dispositivo;
import backend.app.models.Dipositivos.DispositivoBase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.ArrayList;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Observador{

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private int edad;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<DispositivoBase> dispositivos = new ArrayList<>();

    @Transient
    private Comando comando;


    public void definirComando(Comando comando){
        this.comando = comando;
    }

    public void activarComando(){
        if(comando != null){
            comando.activar();
        }
    }

    @Override
    public void actualizar(String estado){
        System.out.println("notificación " +estado+" recibida");
    }

    public void registrarDispositivo(Dispositivo dispositivo){
        dispositivo.registrar(this);
    }

}
