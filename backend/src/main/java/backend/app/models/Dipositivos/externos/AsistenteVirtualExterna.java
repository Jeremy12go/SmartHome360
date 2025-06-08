package backend.app.models.Dipositivos.externos;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AsistenteVirtualExterna {

    public void on() { System.out.println("Asistente Virtual externo ON"); }
    public void off() { System.out.println("Asistente Virtual externo OFF"); }
    public void dim() { System.out.println("Asistente Virtual externo DIM"); }
    public void schedule() { System.out.println("Asistente Virtual externo SCHEDULED"); }

}
