package punto_3_2.main;

import punto_3_2.interfaces.Vendible;

public class Plato implements Vendible {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("Precio no puede ser negativo");
        }
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
