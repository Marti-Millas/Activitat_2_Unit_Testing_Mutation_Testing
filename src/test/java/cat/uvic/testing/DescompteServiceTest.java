package cat.uvic.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DescompteServiceTest {

    private DescompteService service;

    @BeforeEach
    void setUp() {
        service = new DescompteService();
    }

    @ParameterizedTest(name = "Importe {0} y Premium {1} debe devolver {2}")
    @CsvSource({
            "50.0, false, 50.0",     // Compra normal
            "99.99, false, 99.99",   // Justo por debajo del límite
            "100.0, false, 90.0",    // Límite para descuento normal
            "100.0, true, 80.0",     // Premium con descuento[cite: 1]
            "99.99, true, 99.99"     // Combinación extra: Premium sin llegar al límite[cite: 1]
    })
    void calcular_variosCasos_retornaImporteCorrecto(double importCompra, boolean clientPremium, double resultatEsperat) {
        assertEquals(resultatEsperat, service.calcular(importCompra, clientPremium), 0.001);
    }

    @Test
    void calcular_importNegatiu_llancaExcepcio() {
        assertThrows(IllegalArgumentException.class, () -> service.calcular(-1.0, true),
                "Un importe negativo debe lanzar excepción"); // Caso de error[cite: 1]
    }
}