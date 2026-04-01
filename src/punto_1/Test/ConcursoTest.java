package punto_1.Test;

import punto_1.main.Concurso;
import punto_1.main.Participante;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ConcursoTest {
    @Test
    public void testInscripcionExitosa() {
        FakeRecopiladorEnArchivo fake = new FakeRecopiladorEnArchivo();
        var concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7), fake);
        var participante = new Participante("Juan", "Perez", 25);
        String resultado = concurso.inscribirA(participante);
        assertEquals("Participante inscrito exitosamente.", resultado);
        assertEquals(1, concurso.cantidadDeParticipantes());
    }

    @Test
    public void testInscripcionExistosaConPuntos() {
        FakeRecopiladorEnArchivo fake = new FakeRecopiladorEnArchivo();
        var concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7), fake);
        var participante = new Participante("Juan", "Perez", 25);
        String resultado = concurso.inscribirA(participante);
        assertEquals("Participante inscrito exitosamente.", resultado);
        assertEquals(1, concurso.cantidadDeParticipantes());
        assertEquals(10, participante.getPuntos());
    }

    @Test
    public void testInscripcionFueraDePeriodo() {
        FakeRecopiladorEnArchivo fake = new FakeRecopiladorEnArchivo();
        var concurso = new Concurso(LocalDate.now().plusDays(2), LocalDate.now().plusDays(7), fake);
        var participante = new Participante("Juan", "Perez", 25);
        String resultado = concurso.inscribirA(participante);
        assertEquals("No se pueden inscribir participantes fuera del período de inscripción.", resultado);
        assertEquals(0, concurso.cantidadDeParticipantes());
    }

    @Test
    public void testInscripcionGuardaDatosEnSaver() {
        // 1. Arrange (Preparar)
        FakeRecopiladorEnArchivo fake = new FakeRecopiladorEnArchivo();
        Concurso concurso = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7), fake);
        Participante participante = new Participante("Emiliano", "Fernandez", 21);
        concurso.inscribirA(participante);
        assertTrue(fake.getSeGuardo());
        assertEquals(participante.getId(), fake.getId_Participante());
    }

    @Test
    public void testNoSeGuardaSiEstaFueraDeFecha() {
        FakeRecopiladorEnArchivo fake = new FakeRecopiladorEnArchivo();
        // Concurso que ya terminó ayer
        Concurso concurso = new Concurso(LocalDate.now().minusDays(10), LocalDate.now().minusDays(1), fake);
        Participante participante = new Participante("Juan", "Perez", 30);
        concurso.inscribirA(participante);
        assertFalse(fake.getSeGuardo());
    }
}
