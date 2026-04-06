package punto_3_2.main;

import punto_3_2.interfaces.RecopiladorDeGastos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class RecopiladorDeGastosEnBaseDeDatos implements RecopiladorDeGastos {
    private String url;
    private String user;
    private String password;

    public RecopiladorDeGastosEnBaseDeDatos(String url, String user, String password) {
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
    public void registrarGasto(double monto, LocalDate fecha) {
        String sql = "INSERT INTO ventas (fecha, monto) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, fecha);
            pstmt.setDouble(2, monto);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar la venta en la base de datos", e);
        }
    }
}
