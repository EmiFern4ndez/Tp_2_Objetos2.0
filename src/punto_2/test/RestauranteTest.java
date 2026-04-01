package punto_2.test;

import org.junit.jupiter.api.Test;
import punto_2.main.*;
import punto_2.services.CalculadoraViedma;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RestauranteTest {

    @Test
    void testCalculoCostoVisa() {
        // Inicializamos la infraestructura
        FakeRecopilador fake =  new FakeRecopilador();
        var calculadora = new CalculadoraViedma(fake);
        var mesa = new Mesa(1, 4);
        mesa.ocupar(); // La mesa debe estar ocupada para aceptar pedidos
        // Productos de prueba
        var lasaña = new Plato("Lasaña", 1000.0);
        var cocacola = new Bebida("Coca Cola", 500.0);
        // Armamos un pedido base de $1500
        mesa.realizarPedido(lasaña, 1);
        mesa.realizarPedido(cocacola, 2);
        mesa.confirmarPedido();
        // Visa: 3% desc sobre bebidas (1000 * 0.03 = 30).
        // Subtotal: 2000 - 30 = 1970.
        // Propina 2% de 1970 = 39,4.
        // Total esperado: 1970 + 39,4 =
        double total = calculadora.calcularFinal(mesa, new Visa(), 2);
        assertEquals(2009.4, total, 0.01, "El cálculo con Visa es incorrecto");
    }

    @Test
    void testCalculoCostoMastercard() {
        // Inicializamos la infraestructura
        FakeRecopilador fake =  new FakeRecopilador();
        var calculadora = new CalculadoraViedma(fake);
        var mesa = new Mesa(1, 4);
        mesa.ocupar(); // La mesa debe estar ocupada para aceptar pedidos
        // Productos de prueba
        var lasaña = new Plato("Lasaña", 1000.0);
        var cocacola = new Bebida("Coca Cola", 500.0);
        // Armamos un pedido base de $1500
        mesa.realizarPedido(lasaña, 1);
        mesa.realizarPedido(cocacola, 1);
        mesa.confirmarPedido();
        // Mastercard: 2% desc sobre platos (1000 * 0.02 = 20).
        // Subtotal: 1500 - 20 = 1480.
        // Propina 3% de 1480 = 44.4.
        // Total esperado: 1480 + 44.4 = 1524.4
        double total = calculadora.calcularFinal(mesa, new MasterCard(), 3);
        assertEquals(1524.4, total, 0.01, "El cálculo con Mastercard es incorrecto");
    }

    @Test
    void testCalculoCostoComarcaPlus() {
        // Inicializamos la infraestructura
        FakeRecopilador fake =  new FakeRecopilador();
        var calculadora = new CalculadoraViedma(fake);
        var mesa = new Mesa(1, 4);
        mesa.ocupar(); // La mesa debe estar ocupada para aceptar pedidos
        // Productos de prueba
        var lasaña = new Plato("Lasaña", 1000.0);
        var cocacola = new Bebida("Coca Cola", 500.0);
        // Armamos un pedido base de $1500
        mesa.realizarPedido(lasaña, 1);
        mesa.realizarPedido(cocacola, 1);
        mesa.confirmarPedido();
        // Comarca Plus: 2% desc sobre total (1500 * 0.02 = 30).
        // Subtotal: 1500 - 30 = 1470.
        // Propina 5% de 1470 = 73.5.
        // Total esperado: 1470 + 73.5 = 1543.5
        double total = calculadora.calcularFinal(mesa, new ComarcaPlus(), 5);
        assertEquals(1543.5, total, 0.01, "El cálculo con Comarca Plus es incorrecto");
    }

    @Test
    void testCalculoCostoViedma() {
        // Inicializamos la infraestructura
        FakeRecopilador fake =  new FakeRecopilador();
        var calculadora = new CalculadoraViedma(fake);
        var mesa = new Mesa(1, 4);
        mesa.ocupar(); // La mesa debe estar ocupada para aceptar pedidos
        // Productos de prueba
        var lasaña = new Plato("Lasaña", 1000.0);
        var cocacola = new Bebida("Coca Cola", 500.0);
        // Armamos un pedido base de $1500
        mesa.realizarPedido(lasaña, 1);
        mesa.realizarPedido(cocacola, 1);
        mesa.confirmarPedido();
        // Viedma: Sin descuento.
        // Subtotal: 1500.
        // Propina 5% de 1500 = 75.
        // Total esperado: 1500 + 75 = 1575
        double total = calculadora.calcularFinal(mesa, new Viedma(), 5);
        assertEquals(1575.0, total, 0.01, "El cálculo con Viedma es incorrecto");
    }

    @Test
    void testNoSePuedeRealizarPedidoSiMesaNoEstaOcupada() {
        var mesaNueva = new Mesa(5, 4);
        var lasaña = new Plato("Lasaña", 1000.0);
        mesaNueva.realizarPedido(lasaña, 1);
        //Nos fijamos si que el costo del pedido sea 0, porque nos indica que no se procesó el pedido, ya que la mesa no estaba ocupada
        assertEquals(0.0, mesaNueva.calcularCostoBaseDelPedido(), "El pedido no debería procesarse si la mesa no está ocupada");
    }

    @Test
    void testCalcularTotalSeGuardaDatosEnElRecopilador() {
        FakeRecopilador fake =  new FakeRecopilador();
        var calculadora = new CalculadoraViedma(fake);
        var mesa = new Mesa(1, 4);
        mesa.ocupar(); // La mesa debe estar ocupada para aceptar pedidos
        // Productos de prueba
        var lasaña = new Plato("Lasaña", 1000.0);
        var cocacola = new Bebida("Coca Cola", 500.0);
        // Armamos un pedido base de $1500
        mesa.realizarPedido(lasaña, 1);
        mesa.realizarPedido(cocacola, 2);
        mesa.confirmarPedido();
        // Visa: 3% desc sobre bebidas (1000 * 0.03 = 30).
        // Subtotal: 2000 - 30 = 1970.
        // Propina 2% de 1970 = 39,4.
        // Total esperado: 1970 + 39,4 =
        double total = calculadora.calcularFinal(mesa, new Visa(), 2);
        assertTrue(fake.getGuardo());
    }

    @Test
    void testCalcularTotalNoSeGuardaDatosEnElRecopilador() {
        FakeRecopilador fake =  new FakeRecopilador();
        var calculadora = new CalculadoraViedma(fake);
        var mesa = new Mesa(5, 4);
        var lasaña = new Plato("Lasaña", 1000.0);
        mesa.realizarPedido(lasaña, 1);
        //No se confirma el pedido
        double total = calculadora.calcularFinal(mesa, new Visa(), 2);
        assertFalse(fake.getGuardo());
    }
}
