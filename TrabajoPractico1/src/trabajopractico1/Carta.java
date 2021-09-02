package trabajopractico1;

public class Carta {
    
    //Clase para instanciar las cartas
    
    private int valor;
    private Personaje personaje;
    private String color;
    private String descripcion;
    private String tipo;
    
    //Metodos set y get
    
    public void setValor(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
    
    public void setPersonaje(Personaje personaje){
        this.personaje = personaje;
    }
    
    public Personaje getPersonaje(){
        return personaje;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}
