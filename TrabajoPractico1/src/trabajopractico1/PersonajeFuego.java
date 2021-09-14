package trabajopractico1;

public class PersonajeFuego extends PersonajeBuilder{
    
    /*
        Clase constructora concreta de la clase abstracta PersonajeBuilder.
        Se encarga de la representacion del Personaje de Fuego.
    */
    
    @Override
    public void buildTipo() {
        this.personaje.setTipo("Fuego");
    }
    
    @Override
    public void buildNivel(int nivel) {
        // Modifica el nivel del personaje. Toma valores del 1 al 3.
        
        if(nivel < 4)
            this.personaje.setNivel(nivel);
    }
    
    @Override
    public void buildColor(int eleccionColor) {
        // Define el color del personaje. Toma unicamente los valores "Rojo" y "Amarillo"
        
        if (eleccionColor == 1)
            this.personaje.setColor("Amarillo");
        else
            this.personaje.setColor("Rojo");
        
    }

    @Override
    public void buildArma() {
        // El personaje obtiene un arma de nombre "Hacha", categoria B y daño 9.
        
        this.personaje.setArma(new Arma("Hacha",'B', 9));
    }

    @Override
    public void buildHabilidadSecundaria(int tipo) {
        // Le asigna una habilidad secundaria al personaje segun el valor pasado por parametro.
        
        String habilidad;
        
        habilidad = switch (tipo) {
            case 1 -> "Descarga Ígnea";
            case 2 -> "Concentración endotermica";
            case 3 -> "Bombas de Fuego";
            default -> "Ignición";
        }; 
        
        this.personaje.setHabilidadSecundaria(habilidad);
        
    }

    @Override
    public void buildEdad(int edad) {
        // Modifica la edad del personaje. Admite valores inferiores a 101.
        
        if (edad > 0 && edad < 101)
            this.personaje.setEdad(edad);
    }

    @Override
    public void buildTamanio(char tamanio) {
        // Modifica el tamanio del personaje de fuego. Admite solo valores S: small y M: medium
        
        if (tamanio == 'S' || tamanio == 'M')
            this.personaje.setTamanio(tamanio); 
    }

    @Override
    public void buildPersonalidad() {
        // Define la personalidad del personaje.
        this.personaje.setPersonalidad("Temperamentales pero muy habiles.");
    }

    @Override
    public void buildAspecto() {
        // Define el aspecto del personaje.
        this.personaje.setAspecto("Forma no humana, de hecho no existe una representación que lo caracterice.");
    }
    
}
