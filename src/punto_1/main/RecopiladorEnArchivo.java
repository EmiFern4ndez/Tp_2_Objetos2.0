package punto_1.main;

import punto_1.interfaces.Saver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecopiladorEnArchivo implements Saver {
    private String nombreArchivo;

    public RecopiladorEnArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void guardar(int id_Participante, int id_Concurso) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String linea = String.format("%s, %d, %d\n", fecha, id_Participante, id_Concurso);

        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo", e);
        }
    }
}
