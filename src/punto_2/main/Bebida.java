package punto_2.main;

import punto_2.interfaces.Vendible;

public class Bebida implements Vendible {
    private String nombre;
    private double precio;

    public Bebida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double devolverPrecioBebida() {
        return this.precio;
    }

    @Override
    public double devolverPrecioPlato() {
        return 0;
    }
}
