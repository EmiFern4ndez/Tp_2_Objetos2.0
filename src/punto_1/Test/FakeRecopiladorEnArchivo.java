package punto_1.Test;

import punto_1.interfaces.Saver;

public class FakeRecopiladorEnArchivo implements Saver {
    private int id_Participante;
    private int id_Concurso;
    private boolean seGuardo;

    @Override
    public void guardar(int id_Participante, int id_Concurso) {
        this.id_Participante = id_Participante;
        this.id_Concurso = id_Concurso;
        this.seGuardo = true;
    }

    public boolean getSeGuardo() {
        return this.seGuardo;
    }

    public int getId_Participante() {
        return this.id_Participante;
    }

    public int getId_Concurso() {
        return this.id_Concurso;
    }
}
