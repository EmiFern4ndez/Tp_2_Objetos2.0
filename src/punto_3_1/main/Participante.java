package punto_3_1.main;

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

    public void sumarPuntos(int cantPuntos) {
        this.puntos += cantPuntos;
    }

    public int puntosObtenidos() {
        return this.puntos;
    }

    public int Id() {
        return id;
    }

    @Override
    public String toString() {
        return "Participante:" +
                "Nombre:'" + nombre + '\'' +
                ", Apellido:'" + apellido + '\'';
    }
}
