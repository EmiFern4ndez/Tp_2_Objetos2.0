package punto_3_2.main;

import punto_3_2.interfaces.Tarjeta;
import punto_3_2.interfaces.Vendible;

public class Mesa {
    private int numero;
    private int capacidadTotal;
    private int capacidadActual;
    private boolean ocupada;
    private Pedido pedidoActual;

    public Mesa(int numero, int capacidad) {
        if (numero <= 0) throw new IllegalArgumentException("Número de mesa debe ser positivo");
        if (capacidad <= 0) throw new IllegalArgumentException("Capacidad debe ser positiva");
        this.numero = numero;
        this.capacidadTotal = capacidad;
        this.capacidadActual = 0;
        this.ocupada = false;
        this.pedidoActual = new Pedido();
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public int numeroDeMesa(){
        return this.numero;
    }

    public void realizarPedido(Vendible item, int cantidad) {
        if (!ocupada) {
            throw new RuntimeException("La mesa debe estar ocupada para pedir.");
        }
        pedidoActual.agregar(item, cantidad);
    }

    public void confirmarPedido() {
        pedidoActual.confirmar();
    }

    public double calcularCostoBaseDelPedido() {
        return this.pedidoActual.calcularCostoBase();
    }

    public double aplicarDescuentoCon(Tarjeta tarjeta) {
        return tarjeta.calcularDescuento(pedidoActual.items());
    }
}
