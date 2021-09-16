package trabajopractico1;

public class Personaje {
    
    // Clase correspondiente a las caracteristicas de un Personaje.
    
    private String tipo = "Basico";
    private int nivel = 0;
    private String color = "Blanco";
    private Arma arma = null;
    private String habilidadSecundaria = "No tiene";
    private int edad = 1;
    private char tamanio = 'S'; //Admite valores S: small, M: medium, B: big.
    private String personalidad = "Basico";
    private String aspecto = "Basico";
    
    // Metodos get/set.
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public String getHabilidadSecundaria() {
        return habilidadSecundaria;
    }

    public void setHabilidadSecundaria(String habilidadSecundaria) {
        this.habilidadSecundaria = habilidadSecundaria;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getTamanio() {
        return tamanio;
    }

    public void setTamanio(char tamanio) {
        this.tamanio = tamanio;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getAspecto() {
        return aspecto;
    }

    public void setAspecto(String aspecto) {
        this.aspecto = aspecto;
    }

    @Override
    public String toString() {
        
        TextoAColor textoConColor = new TextoAColor();
        
        return textoConColor.cambiarColor(color, ("Datos del Personaje:\nTipo: " + tipo +
                "\nNivel: "+nivel+
                "\nColor: "+color+
                "\nArma: "+arma+
                "\nHabilidad Secundaria: "+habilidadSecundaria+
                "\nEdad: "+edad+
                "\nTamanio: "+tamanio+
                "\nPersonalidad: "+personalidad+
                "\nAspecto: " +aspecto+ "\n"));
    }
    
}
