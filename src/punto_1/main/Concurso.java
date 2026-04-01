package punto_1.main;

import punto_1.interfaces.Saver;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private static int nextId = 1;
    private int id;
    private ArrayList<Participante> participantes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Saver recopilador;

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin, Saver recopilador) {
        this.id = nextId++;
        this.participantes = new ArrayList<>();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.recopilador = recopilador;
    }

    public String inscribirA(Participante participante) {
        LocalDate hoy = LocalDate.now();
        if (!hoy.isBefore(fechaInicio) && !hoy.isAfter(fechaFin)) {
            if (hoy.isEqual(fechaInicio)) {
                participante.sumarleDiezPuntos();
            }
            participantes.add(participante);
            this.recopilador.guardar(participante.getId(), this.getId());
            return "Participante inscrito exitosamente.";
        } else {
            return "No se pueden inscribir participantes fuera del período de inscripción.";
        }
    }

    public int cantidadDeParticipantes() {
        return participantes.size();
    }

    public int getId() {
        return id;
    }
}