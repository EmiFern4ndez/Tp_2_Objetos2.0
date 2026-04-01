package punto_2.main;

import punto_2.interfaces.RecopiladorDeGastos;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecopiladorDeGastosEnArchivo implements RecopiladorDeGastos {
    private String nombreArchivo;

    public RecopiladorDeGastosEnArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void registrarGasto(double monto) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String linea = String.format("%s || %.1f\n", fecha, monto);

        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo", e);
        }
    }
}

