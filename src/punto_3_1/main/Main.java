package punto_3_1.main;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    //RecopiladorEnArchivo recopilador = new RecopiladorEnArchivo("datos_concurso.txt");

    String url = "jdbc:mysql://localhost:3307/punto_3_1_o2";
    String user = "root";
    String pass = "";
    RecopiladorEnBaseDeDatos recopilador = new RecopiladorEnBaseDeDatos(url, user, pass);
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
