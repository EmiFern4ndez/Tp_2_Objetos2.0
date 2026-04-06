package punto_4_1.test;

import punto_4_1.interfaces.Mensajero;

public class FakeMensajero implements Mensajero {
    private int vecesEnviado = 0;
    private String ultimoTo;
    private String ultimoSubject;
    private String ultimoText;

    @Override
    public void enviarMensaje(String to, String subject, String text) {
        this.ultimoTo = to;
        this.ultimoSubject = subject;
        this.ultimoText = text;
        this.vecesEnviado++;
    }

    public int vecesEnviado() {
        return vecesEnviado;
    }
}
