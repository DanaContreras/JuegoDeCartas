package trabajopractico1;
import java.util.Random;

public class CartaAgua implements CartaBuilder {
    
    //Carta para almacenar el producto
    private final Carta resultado = new Carta();
    
    //Arreglos para elegir al azar entres las opciones de valores o colores posibles
    // para las cartas de Agua
    private final int[] posiblesValores = new int[]{3, 5, 7};
    private final String[] posiblesColores = new String[]{"Celeste", "Azul"};
    
    //Clase Random para generar los random
    private final Random random = new Random();
    
    
    @Override
    public void buildValor(){
        //Le asigna un valor al azar entre los posibles para las cartas de Agua
        this.resultado.setValor(posiblesValores[random.nextInt(posiblesValores.length)]);
    }
        
    @Override
    public void buildColor(){
        //Le asigna un color al azar entre los posibles para las cartas de Agua
        this.resultado.setColor(posiblesColores[random.nextInt(posiblesColores.length)]);
    }
    
    @Override
    public void buildPersonaje(){
        
        PersonajeBuilder creadorPersonaje;
        //Switch para elegir al azar el tipo de personaje
        switch(random.nextInt(3)){
            case 0:
                creadorPersonaje = new PersonajeAgua();
                break;
            case 1:
                creadorPersonaje = new PersonajeFuego();
                break;
            //En caso que no sea 0 o 1, sería 2 y elegimos Nieve, usamos default
            //para asegurar que siempre este instanciado creadorPersonaje.
            default:
                creadorPersonaje = new PersonajeNieve();
                break;
        }
        //Metodos fuera del switch ya que todas las construcciones son iguales
        creadorPersonaje.buildPoseeArma();
        creadorPersonaje.buildPoseePoderes();
        creadorPersonaje.buildNivel();
        creadorPersonaje.buildDescripcion();
        //Asigna el resultado del creador de personajes a la carta
        this.resultado.setPersonaje(creadorPersonaje.build());
    }
    
    @Override
    public void buildDescripcion(){
        //Descripcion de todo la carta, incluida la del personaje
        this.resultado.setDescripcion("Carta de AGUA: \n- Su valor es: " + 
        this.resultado.getValor() + "\n- Es de Color " + this.resultado.getColor() 
        + "\n- Su personaje es: " + this.resultado.getDescripcion());
    }
    
    //Devuelve el resultado del constructor
    public Carta getResultado(){
        this.resultado.setTipo("Agua");
        return resultado;
    }
}
