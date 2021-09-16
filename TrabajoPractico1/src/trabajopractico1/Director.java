
package trabajopractico1;

public class Director {
    
    public Personaje construirPersonajeNivel1(PersonajeBuilder builder){
        /* Se encarga de construir un personaje de nivel 1 paso a paso solo invocando los metodos necesarios para el mismo.
           Se necesita establecer las caracteristicas tipo, nivel, color, personalidad y aspecto.
        */
        
        builder.reset(); // Se crea el personaje.
        builder.buildNivel(1);
        builder.buildColor(1);
        builder.buildPersonalidad();
        builder.buildAspecto();
        
        return builder.getResultado();
    }
    
    public Personaje construirPersonajeNivel2(PersonajeBuilder builder){
        /*Se encarga de construir un personaje de nivel 2 paso a paso solo invocando los metodos necesarios para el mismo.
          Se necesita construir las caracteristicas Tipo, nivel, color, habilidad secundaria, edad 10, personalidad y aspecto.
        */
        
        builder.reset();
        builder.buildNivel(2);
        builder.buildColor(2);
        builder.buildHabilidadSecundaria(2);
        builder.buildEdad(10);
        builder.buildPersonalidad();
        builder.buildAspecto();
        
        return builder.getResultado();
    }
    
    public Personaje construirPersonajeNivel3(PersonajeBuilder builder){
        /* Se encarga de construir un personaje de nivel 3 paso a paso solo invocando los metodos necesarios para el mismo.
           Se necesita establecer las caracteristicas tipo, nivel, color, arma, habilidad secundaria, edad, tamanio, personalidad y aspecto.
        */
        
        builder.reset();
        builder.buildNivel(3);
        builder.buildColor(2);
        builder.buildArma();
        builder.buildHabilidadSecundaria(3);
        builder.buildEdad(20);
        builder.buildTamanio('M');
        builder.buildPersonalidad();
        builder.buildAspecto();
        
        return builder.getResultado();
    }
}
