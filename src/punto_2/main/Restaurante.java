package punto_2.main;


import punto_2.interfaces.Calculadora;
import punto_2.interfaces.Tarjeta;

import java.util.ArrayList;
import java.util.List;


public class Restaurante {
    public static final int mesasMaximas = 10;
    private static int capacidadDeLasMesas = 4;
    private List<Mesa> mesas;
    private Calculadora calculadora; // El restaurante conoce cómo cobrar

    public Restaurante(Calculadora calculadora) {
        this.calculadora = calculadora;
        this.mesas = new ArrayList<>();
        for (int i = 1; i <= mesasMaximas; i++) {
            mesas.add(new Mesa(i, capacidadDeLasMesas));
        }
    }

    public double cobrarMesa(int numeroMesa, Tarjeta tarjeta, int propina) {
        Mesa mesa = buscarMesa(numeroMesa);
        return calculadora.calcularFinal(mesa, tarjeta, propina);
    }

    private Mesa buscarMesa(int num) {
        for (Mesa mesa : mesas) {
            if (esLaMesa(num, mesa)) {
                return mesa;
            }
        }
        throw new IllegalArgumentException("Mesa no encontrada: " + num);
    }

    private static boolean esLaMesa(int num, Mesa mesa) {
        return mesa.numeroDeMesa() == num;
    }
}
