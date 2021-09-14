/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopractico1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
/**
 *
 * @author Dana Contreras
 */
public class MainDePrueba {
    
    public static void main(String[] args) {
        
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
        
        //Testeo de creacion de cartas
        
        //Executor para usar InvokeAll
        ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(4);
        
        //Variable para ajustar la cantidad de cartas por jugador facilmente
        int cartasPorJugador = 3;
        
        //Arreglos que guardarán las cartas de cada jugador
        Carta[] manoJugadorUno = new Carta[cartasPorJugador];
        Carta[] manoJugadorDos = new Carta[cartasPorJugador];
        
        //utilizado mas adelante
        HiloCallable hilo;
        
        //Lista de los HiloCallable que usará el invokeAll
        List<HiloCallable> lista = new ArrayList<>();
        
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
        
        //InvokeAll que pone en marcha todos los hilos y los asigna a la lista 
        // de future's
        try{
            cartasResultado = executor.invokeAll(lista);
        } catch (InterruptedException e){
            System.out.println("Error invokeAll");
        }
        
        //Cierro el executor
        executor.shutdown();
        
        System.out.println("Creando las cartas!");
        
        System.out.println("Esperando recuperar cartas...");
        
        //for para recuperar todas las cartas del jugador 1 y pasarlas a manoJugadorUno
        for(int i = 0; i < cartasPorJugador; i++){
            try{
                //Consigue el future de la lista y luego la carta del future.
                manoJugadorUno[i] = cartasResultado.get(i).get();
                
                //Si es la primera carta recuperada:
                if(i == 0)System.out.println("Cartas jugador 1:");
                
                System.out.println("Carta num " + i + ": \n-" + manoJugadorUno[i].getDescripcion());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error recuperando cartas jugador 1.");
            }
        }
        
        //for para recuperar todas las cartas del jugador 2 y pasarlas a manoJugadorDos
        System.out.print("Cartas jugador 2:");
        for(int i = cartasPorJugador; i < cartasPorJugador * 2; i++){
            try{
                //Consigue el future de la lista y luego la carta del future.
                manoJugadorDos[i] = cartasResultado.get(i).get();
                
                //Si es la primera carta del jugador 2 recuperada:
                if(i == cartasPorJugador)System.out.println("Cartas jugador 2:");
                
                System.out.println("Carta num " + i + ": \n-" + manoJugadorDos[i].getDescripcion());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error recuperando cartas jugador 1.");
            }
        }
        
        System.out.println("Cartas recuperadas con exito!");
        
        //Aquí empezaría el juego
    } 
}
