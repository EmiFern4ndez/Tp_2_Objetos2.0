package punto_1.main;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    RecopiladorEnArchivo recopilador = new RecopiladorEnArchivo("efnsufse.txt");
    ProveedorDeFechas fechas = new ProveedorDeFechas();

    var concurso = new Concurso(LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 31), recopilador, fechas);
    var Juan = new Participante("Juan", "Fernandez", 20);
    try {
      concurso.inscribirA(Juan);
      System.out.println("Inscripción exitosa para: " + Juan.toString());
    } catch (RuntimeException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
