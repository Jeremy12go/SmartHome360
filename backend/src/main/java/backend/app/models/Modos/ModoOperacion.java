package backend.app.models.Modos;

public interface ModoOperacion {

    void aplicar (String dato);

    // métodos de transiciones de estado.
    void mNoche();
    void mAhorroEnergia();
    void mVacaciones();
    void mAusente();
}
