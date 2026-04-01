package punto_2.main;

import punto_2.interfaces.Vendible;

public class Plato implements Vendible {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double devolverPrecioBebida() {
        return 0;
    }

    @Override
    public double devolverPrecioPlato() {
        return this.precio;
    }
}
