package trabajopractico1;
import java.util.Random;

public class MainDePrueba {
    
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
}
