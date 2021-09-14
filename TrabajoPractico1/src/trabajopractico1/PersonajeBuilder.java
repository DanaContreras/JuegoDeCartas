
package trabajopractico1;

public abstract class PersonajeBuilder {
    
    // Constructor declara los pasos de construccion del personaje.
    
    protected Personaje personaje = new Personaje();
    
    public void reset(){
        personaje = new Personaje();
    }
    
    public abstract void buildTipo();
    
    public abstract void buildNivel(int nivel);
    
    public abstract void buildColor(int eleccionColor);
    
    public abstract void buildArma();
    
    public abstract void buildHabilidadSecundaria(int tipo);
    
    public abstract void buildEdad(int edad);
    
    public abstract void buildTamanio(char tamanio);
    
    public abstract void buildPersonalidad();
    
    public abstract void buildAspecto();
    
    public Personaje getResultado(){
        return this.personaje;
    }
    
}
