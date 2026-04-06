package punto_3_1.main;

import punto_3_1.interfaces.FechaProvider;

import java.time.LocalDate;

public class ProveedorDeFechas implements FechaProvider {

    @Override
    public LocalDate hoy() {
        return  LocalDate.now();
    }
}
