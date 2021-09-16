
package trabajopractico1;

public class PersonajeAgua extends PersonajeBuilder{
   
    /*
        Clase constructora concreta de la clase abstracta PersonajeBuilder.
        Se encarga de la representacion del Personaje de Agua.
    */

    @Override
    public void reset() {
        // Crea instancia y define el tipo del personaje.
        this.personaje = new Personaje();
        this.personaje.setTipo("Agua");
    }

    @Override
    public void buildNivel(int nivel) {
        // Modifica el nivel del personaje. Toma valores del 1 al 5.
        
        if(nivel < 6)
            this.personaje.setNivel(nivel);
    }

    @Override
    public void buildColor(int eleccionColor) {
        if (eleccionColor == 1)
            this.personaje.setColor("Azul");
        else
            this.personaje.setColor("Violeta");
    }

    @Override
    public void buildArma() {
        // El personaje obtiene un arma de nombre "Lanza", categoria A y danio 9.
        this.personaje.setArma(new Arma("Lanza", 'A', 9));
    }

    @Override
    public void buildHabilidadSecundaria(int tipo) {
       // Se le asigna una habilidad secundaria al personaje segun el valor pasado por parametro.
        
       String habilidad;
       
        habilidad = switch (tipo) {
            case 1 -> "Burbuja";
            case 2 -> "Corriente marina";
            case 3 -> "Compresion";
            default -> "Tsunami";
       };
       
       this.personaje.setHabilidadSecundaria(habilidad);
    }

    @Override
    public void buildEdad(int edad) {
        // Modifica la edad del personaje.
        
        if (edad > 0 && edad <51)
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
        this.personaje.setPersonalidad("Pacientes y estrategas.");
    }

    @Override
    public void buildAspecto() {
        // Define el aspecto del personaje.
        this.personaje.setAspecto("Se presenta con rasgos humanos, rodeado de circulos de agua.");
    }

}
