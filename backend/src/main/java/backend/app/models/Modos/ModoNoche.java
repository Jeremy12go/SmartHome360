package backend.app.models.Modos;

public class ModoNoche implements ModoOperacion{

    @Override
    public void aplicar(String dato) {
        System.out.println("Modo noche aplicado a " + dato);
    }

    @Override
    public void mNoche() {
        System.out.println("Se encuentra en modo noche");
    }

    @Override
    public void mAhorroEnergia() {
        System.out.println("Cambiando a modo ahorro de energia");
    }

    @Override
    public void mVacaciones() {
        System.out.println("Cambiando a modo vacaciones");
    }

    @Override
    public void mAusente() {
        System.out.println("Cambiando a modo ausente");
    }
}
