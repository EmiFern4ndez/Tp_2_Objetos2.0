package punto_2.main;

import punto_2.interfaces.Tarjeta;
import punto_2.interfaces.Vendible;

import java.util.List;

public class MasterCard implements Tarjeta {
    private String numeroTarjeta;
    private String titular;
    private String fechaExpiracion;

    @Override
    public double calcularDescuento(List<Vendible> items) {
        double total = 0;
        for (Vendible item : items) {
            total += item.devolverPrecioPlato();
        }
        return total * 0.02;
    }
}
