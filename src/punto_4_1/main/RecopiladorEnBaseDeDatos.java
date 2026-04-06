package punto_4_1.main;

import punto_4_1.interfaces.Saver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecopiladorEnBaseDeDatos implements Saver {
    private String url;
    private String user;
    private String password;

    public RecopiladorEnBaseDeDatos(String url, String user, String password) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("La URL de la base de datos no puede ser nula o vacía");
        }
        if (user == null) {
            throw new IllegalArgumentException("El usuario de la base de datos no puede ser nulo");
        }
        if (password == null) {
            throw new IllegalArgumentException("La contraseña de la base de datos no puede ser nula");
        }
        this.url = url;
        this.user = user;
        this.password = password;
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC de H2 no encontrado. Asegúrate de tener el JAR h2 en el classpath.", e);
        }
    }

    @Override
    public void guardar(int idParticipante, int idConcurso) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS inscripciones (idParticipante INT NOT NULL, idConcurso INT NOT NULL, fecha DATE NOT NULL)";
        String insertSQL = "INSERT INTO inscripciones (idParticipante, idConcurso, fecha) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement createStmt = conn.prepareStatement(createTableSQL);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
            createStmt.executeUpdate();
            insertStmt.setInt(1, idParticipante);
            insertStmt.setInt(2, idConcurso);
            insertStmt.setObject(3, java.time.LocalDate.now());
            insertStmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage(), e);
        }
    }
}
