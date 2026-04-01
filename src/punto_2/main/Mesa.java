package punto_2.main;

import punto_2.interfaces.Tarjeta;
import punto_2.interfaces.Vendible;

public class Mesa {
    private int numero;
    private int capacidadTotal;
    private int capacidadActual;
    private boolean ocupada;
    private Pedido pedidoActual;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidadTotal = capacidad;
        this.capacidadActual = 0;
        this.ocupada = false;
        this.pedidoActual = new Pedido();
    }

    public void agregarComensal() {
        if (capacidadActual < capacidadTotal) {
            capacidadActual++;
            if (capacidadActual == capacidadTotal) {
                ocupar();
            }
            //Esto lo podria reemplazar por una exception
        } else {
            System.out.println("La mesa " + numero + " está llena.");
        }
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public void desocupar() {
        this.capacidadActual = 0;
        this.ocupada = false;
    }

    public boolean isOcupada() {
        return this.ocupada;
    }

    public void realizarPedido(Vendible item, int cantidad) {
        if (this.ocupada) {
            pedidoActual.agregarItem(item, cantidad);
        }
    }

    public void confirmarPedido() {
        pedidoActual.confirmar();
    }

    // En lugar de getPedido(), exponemos métodos de negocio
    public double calcularCostoBaseDelPedido() {
        return this.pedidoActual.calcularCostoBase();
    }

    public double aplicarDescuentoDeTarjeta(Tarjeta tarjeta) {
        // Le pasamos la responsabilidad al pedido, que es quien tiene los items
        return tarjeta.calcularDescuento(this.pedidoActual.obtenerItems());
    }
}
