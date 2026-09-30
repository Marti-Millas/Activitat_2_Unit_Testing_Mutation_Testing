package cat.uvic.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); 
    }

    // --- 1. Tests normals bàsics ---
    @Test
    void suma_valorsPositius_retornaSumaCorrecta() {
        assertEquals(5, calculator.suma(2, 3));
    }

    @Test
    void resta_unNombrePositiuIUnNegatiu_retornaRestaCorrecta() {
        assertEquals(5, calculator.resta(2, -3)); 
    }

    @Test
    void multiplica_ambZero_retornaZero() {
        assertEquals(0, calculator.multiplica(5, 0)); 
    }

    @Test
    void divideix_valorsNormals_retornaDivisioCorrecta() {
        assertEquals(2.5, calculator.divideix(5.0, 2.0));
    }

    // --- 2. Tests d'excepció ---
    @Test
    void divideix_perZero_llancaExcepcio() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divideix(5.0, 0.0), 
            "Dividir per zero ha de llançar IllegalArgumentException");
    }

    @Test
    void potencia_exponentNegatiu_llancaExcepcio() {
        assertThrows(IllegalArgumentException.class, () -> calculator.potencia(2, -1), 
            "Un exponent negatiu ha de llançar IllegalArgumentException"); 
    }

    // --- 3. Test Parametritzat (Diversos casos en un sol test) ---
    @ParameterizedTest(name = "Base {0} elevat a {1} ha de donar {2}")
    @CsvSource({
            "2, 3, 8",   // Cas normal: 2^3 = 8
            "5, 0, 1",   // Exponent zero: 5^0 = 1
            "0, 0, 1"    // Cas especial 0^0 = 1
    })
    void potencia_casosVaris_retornaResultatEsperat(int base, int exponent, int resultatEsperat) {
        assertEquals(resultatEsperat, calculator.potencia(base, exponent));
    }
}