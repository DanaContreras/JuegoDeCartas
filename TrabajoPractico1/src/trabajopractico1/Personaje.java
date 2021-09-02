package trabajopractico1;

public class Personaje {
    
    // Clase correspondiente a las caracteristicas de un Personaje.
    
    private boolean poseeArma = false;
    private boolean poseePoderes = false;
    private int nivel = 1;
    private String descripcion = "";
    
    public boolean poseeArma() {
        return poseeArma;
    }

    public void setPoseeArma(boolean poseeArma) {
        this.poseeArma = poseeArma;
    }

    public boolean poseePoderes() {
        return poseePoderes;
    }

    public void setPoseePoderes(boolean poseePoderes) {
        this.poseePoderes = poseePoderes;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
