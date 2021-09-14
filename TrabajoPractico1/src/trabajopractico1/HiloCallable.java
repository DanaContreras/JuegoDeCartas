package trabajopractico1;
import java.util.concurrent.Callable;
import java.util.Random;

public class HiloCallable implements Callable{
    
    private final Carta result = new Carta();
    private final Random random = new Random();
    
    @Override
    public Carta call(){
        
        
        return result;
    }
    
    public void construirCartaFuego(Personaje personaje){
        
        //Arreglos para elegir al azar entres las opciones de valores o colores posibles
        // para las cartas de Fuego
        final int[] posiblesValores = new int[]{2, 4, 9};
        final String[] posiblesColores = new String[]{"Rojo", "Naranja", "Amarillo"};
        
        //Lista de seteos/creacion de la carta
        this.result.setTipo("Fuego");
        
        //Utilizan el random para definir que opcion se elige
        this.result.setValor(posiblesValores[random.nextInt(posiblesValores.length)]);
        this.result.setColor(posiblesColores[random.nextInt(posiblesColores.length)]);
        
        this.result.setPersonaje(personaje);
        this.result.setDescripcion("Carta de Fuego: " +
                "\n- Su valor es: " + this.result.getValor() + 
                "\n- Es de Color " + this.result.getColor() + 
                "\n- Su personaje es: " + personaje.getDescripcion());
    }
    
    public void construirCartaNieve(Personaje personaje){
        
        //Arreglos para elegir al azar entres las opciones de valores posibles para
        // las cartas de Nieve, no necesita para los colores ya que siempre son transparentes
        final int[] posiblesValores = new int[]{1, 6, 8};
        
        //Lista de seteos/creacion de la carta
        this.result.setTipo("Nieve");
        
        //Utiliza el random para definir que opcion se elige
        this.result.setValor(posiblesValores[random.nextInt(posiblesValores.length)]);
        
        this.result.setColor("Transparente");
        this.result.setPersonaje(personaje);
        this.result.setDescripcion("Carta de Nieve: " +
                "\n- Su valor es: " + this.result.getValor() + 
                "\n- Es Transparente " +
                "\n- Su personaje es: " + personaje.getDescripcion());
    }
    
    public void construirCartaAgua(Personaje personaje){
        
        //Arreglos para elegir al azar entres las opciones de valores o colores posibles
        // para las cartas de Agua
        final int[] posiblesValores = new int[]{3, 5, 7};
        final String[] posiblesColores = new String[]{"Celeste", "Azul"};
        
        //Lista de seteos/creacion de la carta
        this.result.setTipo("Agua");
        
        //Utilizan el random para definir que opcion se elige
        this.result.setValor(posiblesValores[random.nextInt(posiblesValores.length)]);
        this.result.setColor(posiblesColores[random.nextInt(posiblesColores.length)]);
        
        this.result.setPersonaje(personaje);
        this.result.setDescripcion("Carta de AGUA: " +
                "\n- Su valor es: " + this.result.getValor() + 
                "\n- Es de Color " + this.result.getColor() + 
                "\n- Su personaje es: " + personaje.getDescripcion());
    }
}
