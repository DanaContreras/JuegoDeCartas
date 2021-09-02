
package trabajopractico1;

public abstract class PersonajeBuilder {
    
    // Constructor.
    
    protected Personaje personaje = new Personaje();
    
    public abstract void buildPoseeArma();
    
    public abstract void buildPoseePoderes();
    
    public abstract void buildNivel();
    
    public abstract void buildTipo();
    
    public abstract void buildDescripcion();
    
    public Personaje build(){
        return this.personaje;
    }
}
