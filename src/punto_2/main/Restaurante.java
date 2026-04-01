package punto_2.main;


import punto_2.interfaces.RecopiladorDeGastos;
import java.util.ArrayList;


public class Restaurante {
    private String nombre;
    private ArrayList<Mesa> mesas;
    private RecopiladorDeGastos recopilador;

    public Restaurante(String nombre, RecopiladorDeGastos recopilador) {
        this.nombre = nombre;
        this.recopilador = recopilador;
        this.mesas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            this.mesas.add(new Mesa(i, 4));
        }
    }

    public void mostrarMesasDisponibles() {
        for (Mesa mesa : mesas) {
            /*if (!mesa.isOcupada()) {
                System.out.println("Mesa " + mesa.getNumero());
            }*/
        }
    }

    public RecopiladorDeGastos getRecopilador() {
        return recopilador;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public String getNombre() {
        return nombre;
    }
}
