package backend.app.models.Dipositivos.externos;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CamaraExterna {

    public void on() { System.out.println("Camara externa ON"); }
    public void off() { System.out.println("Camara externa OFF"); }
    public void dim() { System.out.println("Camara externa DIM"); }
    public void schedule() { System.out.println("Camara externa SCHEDULED"); }

}
