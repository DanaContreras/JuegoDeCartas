
package trabajopractico1;
import java.util.Random;

public class PersonajeAgua extends PersonajeBuilder{
   
    // Clase constructora concreta.
    
    @Override
    public void buildPoseeArma() {
        this.personaje.setPoseeArma(true);
    }

    @Override
    public void buildPoseePoderes() {
        this.personaje.setPoseePoderes(false);
    }

    @Override
    public void buildNivel() {
        // Modifica el nivel del personaje. Toma valores del 1 al 5.
        this.personaje.setNivel(new Random().nextInt(5)+ 1);
    }

    @Override
    public void buildDescripcion() {
        this.personaje.setDescripcion(
                "Personaje de AGUA: \n- Posee Armas.\n- No posee poderes.\n- Nivel: " + this.personaje.getNivel() +
                "\n- Son pacientes y grandes extrategas.");
    }

}
