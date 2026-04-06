package punto_3_2.main;

import punto_3_2.interfaces.*;
import punto_3_2.services.CalculadoraViedma;

public class Main {
    public static void main(String[] args) {
        //RecopiladorDeGastos recopilador = new RecopiladorDeGastosEnArchivo("datos_gastos.txt");
        String url = "jdbc:mysql://localhost:3307/punto_3_2_o2";
        String user = "root";
        String pass = "";
        RecopiladorDeGastosEnBaseDeDatos recopilador = new RecopiladorDeGastosEnBaseDeDatos(url, user, pass);
        FechaProvider fechaProvider = new ProveedorDeFechas();
        //Creo la calculadora con el proveedor de fechas
        Calculadora calculadora = new CalculadoraViedma(recopilador, fechaProvider);
        // Creo el restaurante con la calculadora
        Restaurante restaurante = new Restaurante(calculadora);
    }
}
