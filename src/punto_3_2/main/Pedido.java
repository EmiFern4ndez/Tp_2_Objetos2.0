package punto_3_2.main;

import punto_3_2.interfaces.Vendible;

import java.util.LinkedList;
import java.util.List;

public class Pedido {
    private List<Vendible> items;
    private boolean confirmado;

    public Pedido() {
        this.items = new LinkedList<>();
        this.confirmado = false;
    }

    public void agregar(Vendible item, int cantidad) {
        if (!confirmado) {
            for (int i = 0; i < cantidad; i++) {
                items.add(item);
            }
        }
    }

    public void confirmar() {
        this.confirmado = true;
    }

    public List<Vendible> items() {
        return List.copyOf(items); // Devuelve copia inmutable
    }

    public double calcularCostoBase() {
        double total = 0;
        for (Vendible item : items) {
            total += item.devolverPrecioBebida() + item.devolverPrecioPlato();
        }
        return total;
    }
}
