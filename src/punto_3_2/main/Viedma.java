package punto_3_2.main;

import punto_3_2.interfaces.Tarjeta;
import punto_3_2.interfaces.Vendible;

import java.util.List;

public class Viedma implements Tarjeta {
    private String numeroTarjeta;
    private String titular;
    private String fechaExpiracion;

    @Override
    public double calcularDescuento(List<Vendible> items) {
        //No tiene ningún descuento
        return 0;
    }
}
