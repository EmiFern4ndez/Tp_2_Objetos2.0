package punto_1.main;

public class Main {
  public static void main(String[] args) {
    RecopiladorEnArchivo recopilador = new RecopiladorEnArchivo("efnsufse.txt");
    var concurso = new Concurso(java.time.LocalDate.of(2026, 3, 1), java.time.LocalDate.of(2026, 3, 31), recopilador);
    var Juan = new Participante("Juan", "Fernandez", 20);
    System.out.println(concurso.inscribirA(Juan));
  }
}
