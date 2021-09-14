
package trabajopractico1;

public class Arma {
    
    // Clase correspondiente al arma que utiliza un personaje.
    
    private String nombre = "";
    private char categoria = ' ';
    private int danio = 0;

    // Constructor y metodos get/set.
    
    public Arma(String nombre, char categoria, int danio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.danio = danio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    @Override
    public String toString() {
        return "\nCaracteristicas del Arma: "+"\nNombre: " +nombre+ "\nCategoria: " +categoria+ "\nDanio: " +danio;
    }
    
    
    
}
