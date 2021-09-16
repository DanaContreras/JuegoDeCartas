package trabajopractico1;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Map;
import java.util.HashMap;

public class ControladorJuego {
    
    private int cartasPorJugador;        

    //Arreglos que guardarán las cartas de cada jugador
    private final List<Carta> manoJugadorUno = new ArrayList<>(), manoJugadorDos = new ArrayList<>(); 

    //Variables para guardar el puntaje de cada jugador
    private int puntajeJugadorUno = 0, puntajeJugadorDos = 0;

    //Constantes para mostrar los puntos que se ganan por ganar la pelea de elementos de cartas
    // y los puntos que se ganan/pierden en la comparacion elemento-personaje
    private final int puntosPorElemento = 7, puntosPorPersonaje = 3;
    
    //Mapa para transformar elemento1+elemento2 en el resultado: 
    //  "G" = gana elemento1
    //  "E" = Empate
    //  "P" = pierde elemento1
    private Map<String, Character> mapaElementos = new HashMap<String, Character>();
   
    //Constructor     
    public ControladorJuego(){
        
        //Setea el mapeo de los elementos
        mapaElementos.put("FuegoFuego", 'E');
        mapaElementos.put("FuegoNieve", 'G');
        mapaElementos.put("FuegoAgua", 'P');
        mapaElementos.put("NieveFuego", 'P');
        mapaElementos.put("NieveNieve", 'E');
        mapaElementos.put("NieveAgua", 'G');
        mapaElementos.put("AguaFuego", 'G');
        mapaElementos.put("AguaNieve", 'P');
        mapaElementos.put("AguaAgua", 'E');
    }
    
    //Metodo para retornar los resultados de cada jugador.
    public int getPuntajeJugadorUno(){
        return this.puntajeJugadorUno;
    }
    
    public int getPuntajeJugadorDos(){
        return this.puntajeJugadorDos;
    }
    
    //Metodo para crearCartas, el parametro determina la cantidad de cartas por jugador
    public void crearCartas(int cantCartasPorJugador){

        //Executor para usar InvokeAll
        ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(4);
        
        //Variable para ajustar la cantidad de cartas por jugador facilmente
        cartasPorJugador = cantCartasPorJugador;
       
        //utilizado mas adelante
        HiloCallable hilo;
        
        //Lista de los HiloCallable que usará el invokeAll
        List<HiloCallable> lista = new ArrayList<>();
              
        System.out.println("Creando los hilos  \n-");
        
        //Crea una por cada carta, dandole color NEGRO al jugador 1 y color
        // BLANCO al 2
        for(int i = 0; i < cartasPorJugador*2; i++){
            if(i < cartasPorJugador){
                hilo = new HiloCallable(i, "NEGRO");
            } else {
                hilo = new HiloCallable(i, "BLANCO");
            }
            lista.add(hilo);
        }
        
        //Lista de future's que recuperará los resultados de los callable
        List<Future<Carta>> cartasResultado = null;
              
        System.out.println("\n Creando las cartas! (" + cartasPorJugador + " por jugador)  \n");
        
        //InvokeAll que pone en marcha todos los hilos y los asigna a la lista 
        // de future's
        try{
            cartasResultado = executor.invokeAll(lista);
        } catch (InterruptedException e){
            System.out.println("Error invokeAll");
        }
        
        //Cierro el executor
        executor.shutdown();
        
        System.out.println("\n Esperando recuperar cartas...  \n");
        
        //for para recuperar todas las cartas del jugador 1 y pasarlas a manoJugadorUno
        for(int i = 0; i < cartasPorJugador; i++){
            try{
                //Consigue el future de la lista y luego la carta del future.
                //manoJugadorUno[i] = cartasResultado.get(i).get();
                manoJugadorUno.add(cartasResultado.get(i).get());
                
                //Si es la primera carta recuperada:
                if(i == 0)System.out.println("\n Cartas jugador 1:  \n");
                
                System.out.println("Carta num " + (i + 1) + ": \n-" + manoJugadorUno.get(i).getDescripcion());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error recuperando cartas jugador 1.");
            }
        }
        
        //for para recuperar todas las cartas del jugador 2 y pasarlas a manoJugadorDos
        for(int i = cartasPorJugador; i < cartasPorJugador * 2; i++){
            try{
                //Consigue el future de la lista y luego la carta del future.
                manoJugadorDos.add(cartasResultado.get(i).get());
                
                //Si es la primera carta del jugador 2 recuperada:
                if(i == cartasPorJugador)System.out.println("\n Cartas jugador 2: \n");
                
                System.out.println("Carta num " + (i + 1 - cartasPorJugador )+ ": \n" 
                        + manoJugadorDos.get(i - cartasPorJugador).getDescripcion());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error recuperando cartas jugador 2.");
            }
        }
        
        System.out.println("\n Cartas recuperadas con exito!!");      
    }
    

    //Metodo para realizar el combate entre 2 cartas, recibe la posicion de la carta en la lista
    public void combateCartas(int numCartaJugadorUno, int numCartaJugadorDos){
        
        Carta cartaJugadorUno = manoJugadorUno.remove(numCartaJugadorUno % manoJugadorUno.size());
        Carta cartaJugadorDos = manoJugadorDos.remove(numCartaJugadorDos % manoJugadorDos.size());
        
        switch(elementoGanador(cartaJugadorUno.getTipo(), cartaJugadorDos.getTipo())){
            case 'G':
                puntajeJugadorUno += puntosPorElemento;
                System.out.println("Jugador 1 gana " + puntosPorElemento + 
                    " puntos por los elementos de las cartas. (" + cartaJugadorUno.getTipo()
                    + " vence " + cartaJugadorDos.getTipo() + ")");
                break;
            case 'E':
                System.out.println("Empate de elementos, ningun jugador gana puntos por elementos.");
                break;
            case 'P':
                puntajeJugadorDos += puntosPorElemento;
                System.out.println("Jugador 2 gana " + puntosPorElemento + 
                    " puntos por los elementos de las cartas. (" + cartaJugadorDos.getTipo()
                    + " vence " + cartaJugadorUno.getTipo() + ")");
                break;
            default:
                System.out.println("Error en alguno de los elementos de las cartas");
        }
        
        //Suma el valor de las cartas al puntaje de cada jugador
        puntajeJugadorUno += cartaJugadorUno.getValor();
        puntajeJugadorDos += cartaJugadorDos.getValor();
        
        System.out.println("Jugador 1 gana " + cartaJugadorUno.getValor() + "puntos y Jugador 2 gana "
            + cartaJugadorDos.getValor() + " puntos por valores de cartas.");

        //Da los puntos según elemento personaje y carta al jugador 1
        switch(elementoGanador(cartaJugadorUno.getPersonaje().getTipo(), cartaJugadorUno.getTipo())){
            case 'G':
                puntajeJugadorUno += puntosPorPersonaje;
                System.out.println("Jugador 1 gana " + puntosPorPersonaje + " puntos por su personaje.");
                break;
            case 'E':
                System.out.println("Jugador 1 no gana puntos por su personaje.");
                break;
            case 'P':
                puntajeJugadorUno -= puntosPorPersonaje;
                System.out.println("Jugador 1 pierde " + puntosPorPersonaje + " puntos por su personaje.");
                break;
            default:
        }

        //Da los puntos según elemento personaje y carta al jugador 2
        switch(elementoGanador(cartaJugadorDos.getPersonaje().getTipo(), cartaJugadorDos.getTipo())){
            case 'G':
                puntajeJugadorDos += puntosPorPersonaje;
                System.out.println("Jugador 2 gana " + puntosPorPersonaje + " puntos por su personaje.");
                break;
            case 'E':
                System.out.println("Jugador 2 no gana puntos por su personaje.");
                break;
            case 'P':
                puntajeJugadorDos -= puntosPorPersonaje;
                System.out.println("Jugador 2 pierde " + puntosPorPersonaje + " puntos por su personaje.");
                break;
            default:
        }
    }
    
    //Metodo para mostrar todas las cartas del jugador uno
    public void mostrarCartasJugadorUno(){
        for(int i = 0; i < manoJugadorUno.size(); i++){
            System.out.println("Carta numero " + (i + 1) + ": \n" + manoJugadorUno.get(i).getDescripcion() + "\n");
        }
    }

    //Metodo para mostrar todas las cartas del jugador dos
    public void mostrarCartasJugadorDos(){
        for(int i = 0; i < manoJugadorDos.size(); i++){
            System.out.println("Carta numero " + (i + 1) + ": \n" + manoJugadorDos.get(i).getDescripcion() + "\n");
        }
    }
    
    //Metodo privado para comparar dos elementos y saber el resultado
    //Devuelve 'G' si el elementoUno Gana, 'E' si empatan, 'P' si el elementoUno pierde y 'X' en caso de error.
    private char elementoGanador(String elementoUno, String elementoDos){
        char resultadoElemento = 'X';
        
        if(mapaElementos.containsKey(elementoUno + elementoDos))
            resultadoElemento = mapaElementos.get(elementoUno + elementoDos);
                
        return resultadoElemento;
    }
    
}
