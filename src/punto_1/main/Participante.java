package punto_1.main;

public class Participante {
    private static int nextId = 1;
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private int puntos;

    public Participante(String nombre, String apellido, int edad) {
        this.id = nextId++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.puntos = 0;
    }

    public Participante(String nombre, String apellido) {
        this.id = nextId++;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void sumarleDiezPuntos() {
        this.puntos += 10;
    }

    public int getId() {
        return id;
    }
}
