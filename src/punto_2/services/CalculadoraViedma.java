package punto_2.services;

import punto_2.interfaces.FechaProvider;
import punto_2.interfaces.Calculadora;
import punto_2.interfaces.Tarjeta;
import punto_2.interfaces.RecopiladorDeGastos;
import punto_2.main.Mesa;

public class CalculadoraViedma implements Calculadora {
    private RecopiladorDeGastos recopilador;
    private FechaProvider fecha;

    public CalculadoraViedma(RecopiladorDeGastos recopilador, FechaProvider fecha) {
        if (recopilador == null) {
            throw new IllegalArgumentException("El Recopilador de gastos no puede ser nulo");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("El proveedor de fechas no puede ser nulo");
        }
        this.recopilador = recopilador;
        this.fecha = fecha;
    }

    @Override
    public double calcularFinal(Mesa mesa, Tarjeta tarjeta, int porcentajePropina) {
        double neto = mesa.calcularCostoBaseDelPedido() - mesa.aplicarDescuentoCon(tarjeta);
        double propina = neto * (porcentajePropina / 100.0);
        double total = neto + propina;
        if (total > 0) {
            recopilador.registrarGasto(total, fecha.hoy());
        }
        return total;
    }
}
