package punto_2.interfaces;

import java.time.LocalDate;

public interface RecopiladorDeGastos {
    void registrarGasto(double monto, LocalDate fecha);
}

