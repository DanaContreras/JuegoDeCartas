package trabajopractico1;
import java.util.Random;

public interface CartaBuilder {
    
    //Interfaz para los constructuores de cartas
    
    //Random utilizado para los metodos por todas las implementaciones
    
    Random random = new Random();
    
    //metodos de construccion generales
    
    public void buildValor();
    
    public void buildColor();
    
    public void buildPersonaje();
    
    public void buildDescripcion();
}
