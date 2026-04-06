package punto_3_2.main;

import punto_3_2.interfaces.Tarjeta;
import punto_3_2.interfaces.Vendible;

import java.util.List;

public class Visa implements Tarjeta {
    private String numeroTarjeta;
    private String titular;
    private String fechaExpiracion;

    @Override
    public double calcularDescuento(List<Vendible> items) {
        double totalBebidas = 0;
        for (Vendible item : items) {
            totalBebidas += item.devolverPrecioBebida();
        }
        return totalBebidas * 0.03;
    }
}
