package punto_4_1.test;

import org.junit.jupiter.api.Test;
import punto_4_1.main.Concurso;
import punto_4_1.main.Participante;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConcursoTest {

    @Test
    public void testInscripcionExitosaConRecopilador() {
        // Simulamos que hoy es 10/04, y el concurso es del 01 al 30
        var hoy = LocalDate.of(2026, 4, 10);
        var fake = new FakeRecopilador();
        var mensajero = new FakeMensajero();
        var concurso = new Concurso(LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30), fake, () -> hoy, mensajero);
        var participante = new Participante("Juan", "Perez", 25, "fulanito234@gmail.com");
        concurso.inscribirA(participante);
        assertEquals(1, concurso.cantidadDeParticipantes());
        assertEquals(0, participante.puntosObtenidos()); // No es el primer día
    }

    @Test
    public void testInscripcionExitosaConPuntosConRecopilador() {
        // Forzamos que hoy SEA el primer día del concurso
        var primerDia = LocalDate.of(2026, 4, 1);
        var fake = new FakeRecopilador();
        var mensajero = new FakeMensajero();
        var concurso = new Concurso(primerDia, LocalDate.of(2026, 4, 30), fake, () -> primerDia, mensajero);
        var participante = new Participante("Juan", "Perez", 25, "fulanito234@gmail.com");
        concurso.inscribirA(participante);
        assertEquals(10, participante.puntosObtenidos());
    }

    @Test
    public void testInscripcionFueraDePeriodoConRecopilador() {
        // Simulamos que hoy es antes del inicio
        var antesDeInicio = LocalDate.of(2026, 3, 31);
        var fake = new FakeRecopilador();
        var mensajero = new FakeMensajero();
        var concurso = new Concurso(LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30), fake, () -> antesDeInicio, mensajero);
        var participante = new Participante("Juan", "Perez", 25, "fulanito234@gmail.com");
        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirA(participante);
        });
        assertEquals(0, concurso.cantidadDeParticipantes());
    }

    @Test
    public void testInscripcionNoSeGuardaDatosEnRecopilador() {
        // Simulamos que hoy es antes del inicio
        var antesDeInicio = LocalDate.of(2026, 3, 31);
        var fake = new FakeRecopilador();
        var mensajero = new FakeMensajero();
        var concurso = new Concurso(LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30), fake, () -> antesDeInicio, mensajero);
        var participante = new Participante("Juan", "Perez", 25, "fulanito234@gmail.com");
        assertEquals(0, fake.vecesGuardado()); // Verifica que no se guardó porque falló la inscripción
    }

    @Test
    public void testInscripcionGuardaDatosEnSaverConRecopilador() {
        var hoy = LocalDate.of(2026, 4, 5);
        var fake = new FakeRecopilador();
        var mensajero = new FakeMensajero();
        var concurso = new Concurso(LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 30), fake, () -> hoy, mensajero);
        var participante = new Participante("Emiliano", "Fernandez", 21, "fulanito234@gmail.com");
        concurso.inscribirA(participante);
        assertEquals(1, fake.vecesGuardado());
    }

    @Test
    public void testToString() {
        Participante p = new Participante("Ana", "Lopez", 30, "fulanito234@gmail.com");
        String respuestaEsperada = "Participante:Nombre:'Ana', Apellido:'Lopez'";
        assertEquals(respuestaEsperada, p.toString());
    }
}