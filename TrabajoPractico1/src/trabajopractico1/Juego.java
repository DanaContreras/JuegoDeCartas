package trabajopractico1;
import java.util.Random;

public class Juego {
    
    private Controlador controladorMVC; // Controlador que hace la conexion con la interfaz.
    private ControladorJuego controladorJuego = new ControladorJuego(); // Creacion de cartas.
    private int cartasPorJugador; 
    private boolean flagEligioCarta = false; // Bandera para saber si el jugador eligio por primera vez.
    
    public void setControladorMVC(Controlador c){
        // Se establece la conexion con interfaz.
        this.controladorMVC = c;
    }
    
    public void setCartasPorJugador(int cartasPorJugador){
        // Se define la cantidad de cartas por jugador.
        this.cartasPorJugador = cartasPorJugador;
    }
    
    public void comenzarJuego(){
       // Metodo que realiza toda la logica del juego (creación de cartas y puntaje) 
        
        controladorJuego.crearCartas(cartasPorJugador);
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("Empieza el juego");
        System.out.println("--------------------------------------------------------------");
        
        //Muestra las opciones al jugador 1
        System.out.println("Es turno del jugador , elija una carta. Cartas disponibles: \n");
        controladorJuego.mostrarCartasJugadorUno();
        flagEligioCarta = true;
        
    }
    
    public void compararEleccion(int cartaElegida){
       //Se realiza el combate y suma de puntos con las cartas elegidas por el jugador y la maquina.
        
        if (flagEligioCarta) 
            controladorJuego.mostrarCartasJugadorUno();
        
            // Se notifica que se ha elegido una carta.
            System.out.println("Jugador 1 ha elegido la carta numero " + (cartaElegida+1));

            System.out.println("Es turno del jugador 2. Cartas disponibles: \n");
            controladorJuego.mostrarCartasJugadorDos();

            // Elige la maquina. Por simpleza, elige el mismo numero de carta que el jugador.
            System.out.println("Jugador 2 ha elegido la carta numero " + (cartaElegida+1) + "\n A COMBATIR!!");

            //Una vez elegidas las cartas, realiza el combate entre ellas
            controladorJuego.combateCartas(cartaElegida, cartaElegida);
            controladorMVC.mostrarPuntos(controladorJuego.getPuntajeJugadorUno(), controladorJuego.getPuntajeJugadorDos());
            
            System.out.println("--------------------------------------------------------------");
    }
        
    /*
    
    public static void main(String[] args) {
        
        Random random = new Random();
        
        Personaje personajeBasico = new Personaje();
        System.out.println(personajeBasico.toString());
        
        Director director = new Director();
        PersonajeBuilder fuego = new PersonajeFuego();
        PersonajeBuilder agua = new PersonajeAgua();
        PersonajeBuilder nieve = new PersonajeNieve();
        
        System.out.println(director.construirPersonajeNivel1(fuego).toString());
        System.out.println(director.construirPersonajeNivel1(agua).toString());
        System.out.println(director.construirPersonajeNivel1(nieve).toString());
        
        System.out.println(director.construirPersonajeNivel2(fuego).toString());
        System.out.println(director.construirPersonajeNivel2(agua).toString());
        System.out.println(director.construirPersonajeNivel2(nieve).toString());
        
        System.out.println(director.construirPersonajeNivel3(fuego).toString());
        System.out.println(director.construirPersonajeNivel3(agua).toString());
        System.out.println(director.construirPersonajeNivel3(nieve).toString());
        
        ControladorJuego controladorJuego = new ControladorJuego();
        //Creación de cartas
        
        System.out.print("Inserte la cantidad de cartas por jugador: ");
        //Aca haría cartasPorJugador = read();
        int cartasPorJugador = 3;
        
        controladorJuego.crearCartas(cartasPorJugador);
        
        //Aquí empezaría el juego
        
        System.out.println("Empieza el juego");
        
        //variables que guarden que carta eligió cada jugador 
        //  (Van de 1 en adelante, restar 1 para la posición real en la lista)
        int cartaElegidaUno, cartaElegidaDos;
        
        for(int numTurno = 0; numTurno < cartasPorJugador; numTurno++){

            //Muestra las opciones al jugador 1
            System.out.println("Es turno del jugador 1, elija una carta. Cartas disponibles: \n");
            controladorJuego.mostrarCartasJugadorUno();

            //El jugador 1 elige
            //cartaElegidaUno = read(); AQUI ELEGIRIA EL JUGADOR 1
            cartaElegidaUno = random.nextInt(cartasPorJugador - numTurno) + 1;
            System.out.println("Jugador 1 ha elegido la carta numero " + cartaElegidaUno);
 
            //Muestra las opciones al jugador 2           
            System.out.println("Es turno del jugador 1, elija una carta. Cartas disponibles: \n");
            controladorJuego.mostrarCartasJugadorDos();

            //El jugador 2 elige
            //cartaElegidaDos = read(); AQUI ELEGIRIA EL JUGADOR 2
            cartaElegidaDos = random.nextInt(cartasPorJugador - numTurno) + 1;            
            System.out.println("Jugador 2 ha elegido la carta numero " + cartaElegidaDos + "\n A COMBATIR!!");
        
            //Una vez elegidas las cartas, realiza el combate entre ellas
            controladorJuego.combateCartas(cartaElegidaUno, cartaElegidaDos);
        }
    } 
    
    */
    
    
}
