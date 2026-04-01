package punto_2.services;

import punto_2.interfaces.Calculadora;
import punto_2.interfaces.Tarjeta;
import punto_2.interfaces.RecopiladorDeGastos;
import punto_2.main.Mesa;

public class CalculadoraViedma implements Calculadora {
    private RecopiladorDeGastos recopilador;

    public CalculadoraViedma(RecopiladorDeGastos recopilador) {
        this.recopilador = recopilador;
    }

    @Override
    public double calcularFinal(Mesa mesa, Tarjeta tarjeta, int porcentajePropina) {
        double bruto = mesa.calcularCostoBaseDelPedido();
        double descuento = mesa.aplicarDescuentoDeTarjeta(tarjeta);
        double netoConDescuento = bruto - descuento;
        double propina = netoConDescuento * (porcentajePropina / 100.0);
        double total = netoConDescuento + propina;
        // Registrar el gasto en el archivo
        if (total > 0){
            recopilador.registrarGasto(total);
        }
        return total;
    }
}
