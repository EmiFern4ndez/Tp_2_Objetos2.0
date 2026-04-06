package punto_4_1.main;

import punto_4_1.interfaces.FechaProvider;
import punto_4_1.interfaces.Mensajero;
import punto_4_1.interfaces.Saver;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private static int puntosAsumar = 10;
    private static int nextId = 1;
    private int id;
    private ArrayList<Participante> participantes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Saver recopilador;
    private FechaProvider fechaProvider;
    private Mensajero mensajero;

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin, Saver recopilador, FechaProvider fechaProvider, Mensajero mensajero) {
        this.id = nextId++;
        this.participantes = new ArrayList<>();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.recopilador = recopilador;
        this.fechaProvider = fechaProvider;
        this.mensajero = mensajero;
    }

    public void inscribirA(Participante participante) {
        LocalDate hoy = fechaProvider.hoy();
        if (estaFueraDeRango(hoy)) {
            throw new RuntimeException("Fuera de rango");
        }
        if (esPrimerDia(hoy)) {
            participante.sumarPuntos(puntosAsumar);
        }
        this.participantes.add(participante);
        this.recopilador.guardar(participante.Id(), this.id);
        this.mensajero.enviarMensaje(participante.email(), "Inscripción exitosa", "Te has inscripto al concurso con ID: " + this.id);
    }

    private boolean estaFueraDeRango(LocalDate fecha) {
        return fecha.isBefore(fechaInicio) || fecha.isAfter(fechaFin);
    }

    private boolean esPrimerDia(LocalDate fecha) {
        return fecha.isEqual(fechaInicio);
    }

    public int cantidadDeParticipantes() {
        return this.participantes.size();
    }
}
