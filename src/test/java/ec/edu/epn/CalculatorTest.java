package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    // Formato para metrodos de prueba
    // Metodo_caso_resultadoEsperado
    @Test
    void add_TwoPositiveNumbers_ReturnsCorrectSum() {
        // Arrange - preparación para la prueba
        int a = 3;
        int b = 4;
        // Act - ejecución de la prueba
        int result = calculator.add(a, b);
        // Assert - verificación del resultado
        assertEquals(7, result);
    }

    @Test
    void substract_TwoPositiveNumbers_ReturnsCorrectSubstract() {
        // Arrange - preparación para la prueba
        int a = 5;
        int b = 2;
        // Act - ejecución de la prueba
        int result = calculator.subtract(a, b);
        // Assert - verificación del resultado
        assertEquals(3, result);
    }

    @Test
    void multiply_TwoPositiveNumbers_ReturnsCorrectMultiply() {
        // Arrange - preparación para la prueba
        int a = 5;
        int b = 4;
        // Act - ejecución de la prueba
        int result = calculator.multiply(a, b);
        // Assert - verificación del resultado
        assertEquals(20, result);
    }

    @Test
    void divide_TwoPositiveNumbers_ReturnsCorrectDivide() {
        // Arrange - preparación para la prueba
        int a = 10;
        int b = 2;
        // Act - ejecución de la prueba
        double result = calculator.divide(a, b);
        // Assert - verificación del resultado
        assertEquals(5, result);
    }

    @Test
    void isEven_OnePositiveNumber_ReturnsCorrectIsEven() {
        // Arrange - preparación para la prueba
        int a = 10;
        // Act - ejecución de la prueba
        boolean isEven = calculator.isEven(a);
        // Assert - verificación del resultado
        assertTrue(isEven);
    }

}
