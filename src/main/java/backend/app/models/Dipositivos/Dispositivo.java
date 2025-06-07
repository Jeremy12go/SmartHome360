package backend.app.models.Dipositivos;

import backend.app.models.Modos.ModoOperacion;
import backend.app.models.Usuario.Observador;

public interface Dispositivo {

    void encender();
    void apagar();
    void ajustar();
    void programar();
    void cambiarModo(ModoOperacion modo);
    void activarModo(String dato);
    void registrar(Observador suscriptor);
    void notificar();

}
