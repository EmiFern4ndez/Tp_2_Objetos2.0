package punto_2.test;

import punto_2.interfaces.RecopiladorDeGastos;

public class FakeRecopilador implements RecopiladorDeGastos{
    private double gastoRegistrado;
    private boolean seGuardo;

    @Override
    public void registrarGasto(double monto) {
        this.gastoRegistrado = monto;
        this.seGuardo = true;
    }

    public double getGastoRegistrado() {
        return gastoRegistrado;
    }
    public boolean getGuardo() {
        return seGuardo;
    }
}
