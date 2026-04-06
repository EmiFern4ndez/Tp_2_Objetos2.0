package punto_4_1.main;

import punto_4_1.interfaces.Mensajero;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /*SECCION RECOPILADOR (Archivo o Base de Datos)*/
        DatabaseConnector dbConnector = new DatabaseConnector("jdbc:h2:./punto_3_1_o2", "root", "");
        RecopiladorEnBaseDeDatos recopilador = dbConnector.createRecopilador();

        /* SECCION MAIL*/
        Mensajero mensajero = new EmailSender("emi.fern4ndez@gmail.com", "fc999713e071b8", "64c00e6e22a41f", "sandbox.smtp.mailtrap.io");

        /*SECCION PROVEEDORES DE FECHAS*/
        ProveedorDeFechas fechas = new ProveedorDeFechas();

        /*CONTENIDO DEL MAIN NORMAL*/
        var concurso = new Concurso(LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30), recopilador, fechas, mensajero);
        var Juan = new Participante("Juan", "Fernandez", 20, "fulanito234@gmail.com");
        try {
            concurso.inscribirA(Juan);
            System.out.println("Inscripción exitosa para: " + Juan.toString());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
