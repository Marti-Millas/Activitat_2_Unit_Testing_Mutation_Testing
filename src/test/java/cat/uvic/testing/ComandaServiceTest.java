package cat.uvic.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ComandaServiceTest {

    @Mock
    StockRepository stock; // Creamos el objeto falso[cite: 1]

    @InjectMocks
    ComandaService service; // Inyectamos el mock en el servicio[cite: 1]

    @Test
    void potComprarQuanHiHaStock() {
        // Le decimos al mock cómo debe comportarse[cite: 1]
        when(stock.teStock("P01")).thenReturn(true); 
        
        assertTrue(service.potComprar("P01"));
    }

    @Test
    void noPotComprarQuanNoHiHaStock() {
        // Caso extra: probamos cuando NO hay stock
        when(stock.teStock("P02")).thenReturn(false);
        
        assertFalse(service.potComprar("P02"));
    }
    
    @Test
    void potComprar_ambProducteBuit_llancaExcepcio() {
        // Probamos la validación del null/blank que tiene el código de producción
        assertThrows(IllegalArgumentException.class, () -> service.potComprar(""));
    }
}