package trabajopractico1;
import java.util.Random;

public class PersonajeFuego extends PersonajeBuilder{

    // Clase constructora concreta.
    
    @Override
    public void buildPoseeArma() {
        this.personaje.setPoseeArma(false);
    }

    @Override
    public void buildPoseePoderes() {
        this.personaje.setPoseePoderes(true);
    }

    @Override
    public void buildNivel() {
        // Modifica el nivel del personaje. Toma valores del 1 al 5.
        this.personaje.setNivel(new Random().nextInt(5)+ 1);
    }

    @Override
    public void buildTipo() {
        this.personaje.setTipoPersonaje("Fuego");
    }
    
    @Override
    public void buildDescripcion() {
        this.personaje.setDescripcion(
                "Personaje de FUEGO: \n- No posee Armas.\n- Posee poderes.\n- Nivel: " + this.personaje.getNivel() +
                "\n- Son temperamentales y muy habiles.");
    }
    
}
