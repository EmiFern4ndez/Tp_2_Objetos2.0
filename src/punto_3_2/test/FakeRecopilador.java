package punto_3_2.test;

import punto_3_2.interfaces.RecopiladorDeGastos;

import java.time.LocalDate;

public class FakeRecopilador implements RecopiladorDeGastos {
    private double gastoRegistrado;
    private boolean seGuardo;
    private int vecesGuardado = 0;

    @Override
    public void registrarGasto(double monto, LocalDate fecha) {
        this.gastoRegistrado = monto;
        this.seGuardo = true;
        this.vecesGuardado++;
    }

    public boolean seGuardo() {
        return seGuardo;
    }

    public int vecesGuardado() {
        return vecesGuardado;
    }
}
