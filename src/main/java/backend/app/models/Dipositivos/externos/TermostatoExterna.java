package backend.app.models.Dipositivos.externos;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TermostatoExterna {

    public void on() { System.out.println("Termostato externo ON"); }
    public void off() { System.out.println("Termostato externo OFF"); }
    public void dim() { System.out.println("Termostato externo DIM"); }
    public void schedule() { System.out.println("Termostato externo SCHEDULED"); }

}
