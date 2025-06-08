package backend.app.models.Modos;

public class ModoVacaciones implements ModoOperacion{

    @Override
    public void aplicar(String dato) {
        System.out.println("Modo vacaciones aplicado a " + dato);
    }

    @Override
    public void mNoche() {
        System.out.println("Cambiando a modo noche");
    }

    @Override
    public void mAhorroEnergia() {
        System.out.println("Cambiando a modo ahorro de energia");
    }

    @Override
    public void mVacaciones() {
        System.out.println("Se encuentra en modo vacaciones");
    }

    @Override
    public void mAusente() {
        System.out.println("Cambiando a modo ausente");
    }
}
