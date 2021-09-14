
package trabajopractico1;
import java.util.Random;

public class PersonajeNieve extends PersonajeBuilder{
    
    /*
        Clase constructora concreta de la clase abstracta PersonajeBuilder.
        Se encarga de la representacion del Personaje de Nieve.
    */
    
    @Override
    public void buildTipo() {
        this.personaje.setTipo("Nieve");
    }
    
    @Override
    public void buildNivel(int nivel) {
        // Modifica el nivel del personaje. Toma valores del 1 al 8.
        
        if (nivel < 9)
            this.personaje.setNivel(nivel);

    }

    @Override
    public void buildColor(int eleccionColor) {
         // Define el color del personaje. Toma unicamente los valores "Cyan" y "Verde"
        
        if (eleccionColor == 1)
            this.personaje.setColor("Cyan");
        else
            this.personaje.setColor("Verde");
    }

    @Override
    public void buildArma() {
        // El personaje obtiene un arma llamada "Katana", categoria C y danio 10.
        this.personaje.setArma(new Arma("Katana", 'C', 10));
    }

    @Override
    public void buildHabilidadSecundaria(int tipo) {
        // Le asigna una habilidad secundario al personaje segun el valor pasado por parametro.
        
        String habilidad;
        
        habilidad = switch (tipo) {
            case 1 -> "Ejercito niveo";
            case 2 -> "Piso de hielo";
            case 3 -> "Estalactitas";
            default -> "Estalagmitas";
        }; 
        
        this.personaje.setHabilidadSecundaria(habilidad);
    }

    @Override
    public void buildEdad(int edad) {
        // Modifica la edad del personaje. Admite valores inferiores a 81.
        
        if (edad > 0 && edad < 81)
            this.personaje.setEdad(edad);
        
    }

    @Override
    public void buildTamanio(char tamanio) {
        // Modifica el tamaño del personaje de agua. Admite S:small, M: medium, B:big
        
        if (tamanio == 'S' || tamanio == 'M' || tamanio == 'B')
            this.personaje.setTamanio(tamanio);
    }

    @Override
    public void buildPersonalidad() {
        // Define la personalidad del personaje.
        this.personaje.setPersonalidad("Agiles y perfeccionistas.");
    }

    @Override
    public void buildAspecto() {
        // Define el aspecto del personaje.
        this.personaje.setAspecto("Suelen tomar forma humana o en raras ocaciones, una forma similar a algun animal salvaje.");
    }

}
