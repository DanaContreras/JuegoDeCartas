
package trabajopractico1;

public class Controlador {
    
    // Clase que forma parte del patrón Modelo Vista Controlador para independizar los componentes del sistema.
    
    private Juego juegoPrincipal;
    private InterfazGrafica interfaz;
    
    public static void main(String[] args) {
        // Permite instanciar todas las clases con las que trabaja el sistema.
        
        Controlador controlador = new Controlador();
        controlador.iniciarControl();
        
    }
    
    private void iniciarControl(){
        
        // Se instancian las clases.
        this.juegoPrincipal = new Juego();
        this.interfaz = new InterfazGrafica();
        
        // Se establecen relaciones entre con el controlador.
        this.interfaz.setControlador(this);
        this.juegoPrincipal.setControladorMVC(this);
        this.juegoPrincipal.setCartasPorJugador(3); // El juego esta planteado para que la cantidad varie. Por la interfaz, la variable se matiene en 3.
        
        this.juegoPrincipal.comenzarJuego(); // Comienza la logica del juego.
        interfaz.setVisible(true); // Se incorpora la interfaz grafica.
    }
    
    // Metodos utilizados por la clase InterfazGrafica y Juego para la conexion entre las mismas.
    
    public void eleccionCarta(int posicion){
        // Metodo que se encarga de retornar la eleccion del usuario.
        juegoPrincipal.compararEleccion(posicion);
    }
    
    public void mostrarPuntos(int puntosJugador, int puntosMaquina){
        // Metodo que envia los resultados finales a la interfaz para que los muestre por pantalla.
        interfaz.mostrarResultado(puntosJugador, puntosMaquina);
    }

}