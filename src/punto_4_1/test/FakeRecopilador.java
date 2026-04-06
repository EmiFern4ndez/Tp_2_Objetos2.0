package punto_4_1.test;

import punto_4_1.interfaces.Saver;

public class FakeRecopilador implements Saver {
    private int vecesGuardado = 0;
    private int ultimoIdParticipante;
    private int ultimoIdConcurso;

    @Override
    public void guardar(int id_Participante, int id_Concurso) {
        this.ultimoIdParticipante = id_Participante;
        this.ultimoIdConcurso = id_Concurso;
        this.vecesGuardado++;
    }

    public int vecesGuardado() {
        return this.vecesGuardado;
    }

}
