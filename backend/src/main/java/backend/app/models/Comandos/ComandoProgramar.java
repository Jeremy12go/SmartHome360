package backend.app.models.Comandos;

import backend.app.models.Dipositivos.Dispositivo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComandoProgramar implements Comando{

    private Dispositivo dispositivo;

    @Override
    public void activar(){
        dispositivo.programar();
    }
}
