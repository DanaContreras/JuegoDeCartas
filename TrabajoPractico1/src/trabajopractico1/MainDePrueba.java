/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajopractico1;

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
    }
    
}
