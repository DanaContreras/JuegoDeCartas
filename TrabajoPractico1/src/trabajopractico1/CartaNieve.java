package trabajopractico1;

public class CartaNieve implements CartaBuilder {
    
    //Carta para almacenar el producto
    private final Carta resultado = new Carta();
    
    //Arreglos para elegir al azar entres las opciones de valores posibles para las 
    // cartas de Nieve, no necesita para los colores ya que siempre son transparentes
    private final int[] posiblesValores = new int[]{1, 6, 8};   
    
    @Override
    public void buildValor(){
        //Le asigna un valor al azar entre los posibles para las cartas de Nieve
        this.resultado.setValor(posiblesValores[random.nextInt(posiblesValores.length)]);
    }
        
    @Override
    public void buildColor(){
        //Le asigna Transparente, la único opción para las cartas de Nieve
        this.resultado.setColor("Transparente");
    }
    
    /*
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
    */
    
    @Override
    public void buildDescripcion(){
        //Descripcion de todo la carta, incluida la del personaje
        this.resultado.setDescripcion("Carta de Nieve: \n- Su valor es: " + 
        this.resultado.getValor() + "\n- Es Transparente \n- Su personaje es: " 
        + this.resultado.getDescripcion());
    }
    
    //Devuelve el resultado del constructor
    public Carta getResultado(){
        this.resultado.setTipo("Nieve");
        return resultado;
    }
}
