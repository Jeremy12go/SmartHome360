package backend.app.models.Dipositivos.externos;

import lombok.*;

@NoArgsConstructor
public class LuzExterna {

    public void on() { System.out.println("Luz externa ON"); }
    public void off() { System.out.println("Luz externa OFF"); }
    public void dim() { System.out.println("Luz externa DIM"); }
    public void schedule() { System.out.println("Luz externa SCHEDULED"); }

}
