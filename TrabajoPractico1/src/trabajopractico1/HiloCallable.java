package trabajopractico1;
import java.util.concurrent.Callable;
import java.util.Random;

public class HiloCallable implements Callable<Carta>{
    
    //Carta result que guarda el resultado que se pasará al Future
    private final Carta result = new Carta();
    private final Random random = new Random();
    
    //Variable para llevar el control
    private final String nombre;
    private final String color;
    TextoAColor textoConColor = new TextoAColor();
    
    public HiloCallable(int numero, String color){
        this.nombre = "Hilo callable " + numero;
        this.color = color;
        System.out.println(textoConColor.cambiarColor(color, nombre + ": Hilo creado"));
    }
    
    @Override
    public Carta call(){
        
        System.out.println(textoConColor.cambiarColor(color, nombre + ": Comienzo creación de carta"));
        
        //Objetos utilizados mas adelante
        Personaje personaje;
        PersonajeBuilder constructorPersonaje;
        Director director = new Director();
        
        //Decide al azar que tipo de personaje tendrá la carta
        switch(random.nextInt(3)){
            case 0:
                constructorPersonaje = new PersonajeFuego();
                break;
            case 1:
                constructorPersonaje = new PersonajeNieve();
                break;
            default:
                constructorPersonaje = new PersonajeAgua();
        }
        
        //Decide al azar que nivel de personaje tendrá la carta, utilizando el
        // director, pasandole el constructor seleccionado anteriormente
        switch(random.nextInt(3)){
            case 0:
                personaje = director.construirPersonajeNivel1(constructorPersonaje);
                break;
            case 1:
                personaje = director.construirPersonajeNivel2(constructorPersonaje);
                break;
            default:
                personaje = director.construirPersonajeNivel3(constructorPersonaje);
        }
        
        //Una vez que tiene el personaje, crea una carta de un tipo al azar con 
        // el personaje
        switch(random.nextInt(3)){
            case 0:
                construirCartaFuego(personaje);
                break;
            case 1:
                construirCartaNieve(personaje);
                break;
            default:
                construirCartaAgua(personaje);
        }
                
        System.out.println(textoConColor.cambiarColor(color, nombre + ": Finalizo creación de carta"));
        
        return result;
    }
    
    //Metodos hechos aparte para aislar la construccion de la carta
    
    //Metodo para construir una carta de fuego
    private void construirCartaFuego(Personaje personaje){
        
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
        
        //Descripcion, la parte de la carta tiene color segun su tipo y la de 
        // personaje mantiene su color original
        this.result.setDescripcion(
            textoConColor.cambiarColor("Rojo", "Carta de Fuego: " +
                "\n- Su valor es: " + this.result.getValor() + 
                "\n- Es de Color " + this.result.getColor() + 
                "\n- ")
            + personaje.toString());
    }
    
    
    //Metodo para construir una carta de nieve
    private void construirCartaNieve(Personaje personaje){
        
        //Arreglos para elegir al azar entres las opciones de valores posibles para
        // las cartas de Nieve, no necesita para los colores ya que siempre son transparentes
        final int[] posiblesValores = new int[]{1, 6, 8};
        
        //Lista de seteos/creacion de la carta
        this.result.setTipo("Nieve");
        
        //Utiliza el random para definir que opcion se elige
        this.result.setValor(posiblesValores[random.nextInt(posiblesValores.length)]);
        
        this.result.setColor("Transparente");
        this.result.setPersonaje(personaje);
        
        //Descripcion, la parte de la carta tiene color segun su tipo y la de 
        // personaje mantiene su color original
        this.result.setDescripcion(
            textoConColor.cambiarColor("Blanco", "Carta de Nieve: " +
                "\n- Su valor es: " + this.result.getValor() + 
                "\n- Es Transparente " +
                "\n- ")
            + personaje.toString());
    }
    
    
    //Metodo para construir una carta de Agua
    private void construirCartaAgua(Personaje personaje){
        
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
        
        //Descripcion, la parte de la carta tiene color segun su tipo y la de 
        // personaje mantiene su color original
        this.result.setDescripcion(
            textoConColor.cambiarColor("Azul", "Carta de AGUA: " +
                "\n- Su valor es: " + this.result.getValor() + 
                "\n- Es de Color " + this.result.getColor() + 
                "\n- ")
             + personaje.toString());
    }
}
