package punto_1.test;

import org.junit.jupiter.api.Test;
import punto_1.main.Concurso;
import punto_1.main.Participante;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    public void testInscripcionExitosa() {
        // Simulamos que hoy es 10/04, y el concurso es del 01 al 30
        var hoy = LocalDate.of(2026, 4, 10);
        var fake = new FakeRecopiladorEnArchivo();
        var concurso = new Concurso(LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30), fake, () -> hoy);
        var participante = new Participante("Juan", "Perez", 25);

        concurso.inscribirA(participante);

        assertEquals(1, concurso.cantidadDeParticipantes());
        assertEquals(0, participante.puntosObtenidos()); // No es el primer día
    }

    @Test
    public void testInscripcionExitosaConPuntos() {
        // Forzamos que hoy SEA el primer día del concurso
        var primerDia = LocalDate.of(2026, 4, 1);
        var fake = new FakeRecopiladorEnArchivo();
        var concurso = new Concurso(primerDia, LocalDate.of(2026, 4, 30), fake, () -> primerDia);
        var participante = new Participante("Juan", "Perez", 25);

        concurso.inscribirA(participante);

        assertEquals(10, participante.puntosObtenidos());
    }

    @Test
    public void testInscripcionFueraDePeriodo() {
        // Simulamos que hoy es antes del inicio
        var antesDeInicio = LocalDate.of(2026, 3, 31);
        var fake = new FakeRecopiladorEnArchivo();
        var concurso = new Concurso(LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30), fake, () -> antesDeInicio);
        var participante = new Participante("Juan", "Perez", 25);

        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirA(participante);
        });
        assertEquals(0, concurso.cantidadDeParticipantes());
    }

    @Test
    public void testInscripcionGuardaDatosEnSaver() {
        var hoy = LocalDate.of(2026, 4, 5);
        var fake = new FakeRecopiladorEnArchivo();
        var concurso = new Concurso(LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30), fake, () -> hoy);
        var participante = new Participante("Emiliano", "Fernandez", 21);

        concurso.inscribirA(participante);

        assertTrue(fake.SeGuardo());
        assertEquals(participante.Id(), fake.IdParticipante());
    }
}