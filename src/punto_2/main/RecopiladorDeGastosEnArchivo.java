package punto_2.main;

import punto_2.interfaces.RecopiladorDeGastos;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecopiladorDeGastosEnArchivo implements RecopiladorDeGastos {
    private String nombreArchivo;

    public RecopiladorDeGastosEnArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void registrarGasto(double monto, LocalDate fecha) {
        String fechaStr = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String linea = String.format("%s || %.1f%n", fechaStr, monto);
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error técnico de persistencia", e);
        }
    }
}

