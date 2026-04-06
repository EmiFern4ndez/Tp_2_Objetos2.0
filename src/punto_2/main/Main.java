package punto_2.main;

import punto_2.interfaces.RecopiladorDeGastos;
import punto_2.interfaces.FechaProvider;
import punto_2.interfaces.Calculadora;
import punto_2.services.CalculadoraViedma;

public class Main {
    public static void main(String[] args) {
        RecopiladorDeGastos recopilador = new RecopiladorDeGastosEnArchivo("datos_gastos.txt");
        FechaProvider fechaProvider = new ProveedorDeFechas();
        //Creo la calculadora con el proveedor de fechas
        Calculadora calculadora = new CalculadoraViedma(recopilador, fechaProvider);
        // Creo el restaurante con la calculadora
        Restaurante restaurante = new Restaurante(calculadora);
    }
}
