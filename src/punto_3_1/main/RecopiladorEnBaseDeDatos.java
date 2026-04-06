package punto_3_1.main;

import punto_3_1.interfaces.Saver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class RecopiladorEnBaseDeDatos implements Saver {
    private String url;
    private String user;
    private String password;

    public RecopiladorEnBaseDeDatos(String url, String user, String password) {
         if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("La URL de la base de datos no puede ser nula o vacía");
         }
         if (user == null || user.isEmpty()) {
             throw new IllegalArgumentException("El usuario de la base de datos no puede ser nulo o vacío");
         }
         if (password == null || password.isEmpty()) {
             throw new IllegalArgumentException("La contraseña de la base de datos no puede ser nula o vacía");
         }
         this.url = url;
         this.user = user;
         this.password = password;
    }

    @Override
    public void guardar(int idParticipante, int idConcurso) {
        String sql = "INSERT INTO inscripciones (id_participante, id_concurso, fecha) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idParticipante);
            pstmt.setInt(2, idConcurso);
            pstmt.setObject(3, LocalDate.now());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }
}
