package punto_2.main;

import punto_2.interfaces.RecopiladorDeGastos;
import punto_2.services.CalculadoraViedma;

public class Main {
    public static void main(String[] args) {
        // Crear el recopilador de gastos
        RecopiladorDeGastos recopilador = new RecopiladorDeGastosEnArchivo("datos_gastos.txt");

        // Crear el restaurante con el recopilador
        var restaurante = new Restaurante("El Buen Sabor", recopilador);

        // Crear la calculadora con el recopilador
        var calculadora = new CalculadoraViedma(recopilador);
    }
}
