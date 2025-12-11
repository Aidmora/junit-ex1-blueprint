package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private Calculator calculator;

    // Esto no es un arrange, es una inicialización común para todas las pruebas
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    // Metodo_caso_resultadoEsperado
    @Test
    void add_TwoPositiveNumbers_ReturnsCorrectSum() {
        // Arrange - preparación para la prueba
        int a = 3;
        int b = 4;
        // Act - ejecución de la prueba
        int result = calculator.add(a, b);
        // Assert - verificación del resultado
        assertEquals(7, result, "la suma de 3 + 4 debe ser 7");
    }

    @Test
    void substract_TwoPositiveNumbers_ReturnsCorrectSubstract() {
        // Arrange - preparación para la prueba
        int a = 5;
        int b = 2;
        // Act - ejecución de la prueba
        int result = calculator.subtract(a, b);
        // Assert - verificación del resultado
        assertEquals(3, result, "la resta de 5 - 2 debe ser 3");
    }

    @Test
    void multiply_zeroByAnyNumber_ReturnsZero() {
        // Arrange - preparación para la prueba
        int a = 5;
        int b = 0;
        // Act - ejecución de la prueba
        int result = calculator.multiply(a, b);
        // Assert - verificación del resultado
        assertEquals(0, result, "la multiplicación de 5 * 0 debe ser 0");
    }

    @Test
    void divide_TwoPositiveNumbers_ReturnsCorrectDivide() {
        // Arrange - preparación para la prueba
        int a = 10;
        int b = 4;
        // Act - ejecución de la prueba
        double result = calculator.divide(a, b);
        // Assert - verificación del resultado
        assertEquals(2.5, result, 0.0001, "la división de 10 / 2 debe ser 5");

        assertAll(
                () -> assertTrue(result > 0),
                () -> assertEquals(2.5, result, 0.0001, "la división de 10 / 2 debe ser 5"));
        // Delta sirve para una tolerancia de decimales
    }

    @Test
    void isEven_OnePositiveNumber_ReturnsCorrectIsEven() {
        assertTrue(calculator.isEven(20), "10 es un número par");
    }

    // Pamatrized Tests - Lab 2 - Tests Parametrizados
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "5,2,7",
            "1,-2,-1"
    })
    void add_MultipleValues_ReturnCorrectValues(int a, int b, int expectedSum) {
        assertEquals(expectedSum, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,-1",
            "5,2,3",
            "-1,-2,1"
    })
    void substract_MultipleValues_ReturnCorrectValues(int a, int b, int expectedSubstract) {
        assertEquals(expectedSubstract, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,2",
            "5,2,10",
            "-1,2,-2"
    })
    void mutiply_MultipleValues_ReturnCorrectValues(int a, int b, int expectedMultiply) {
        assertEquals(expectedMultiply, calculator.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10,2,5",
            "5,2,2.5",
            "1,2,0.5"
    })
    void divide_MultipleValues_ReturnCorrectValues(int a, int b, double expectedDivide) {
        assertEquals(expectedDivide, calculator.divide(a, b), 0.0001);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 30, -6, 0 })
    void isEven_MultipleNumbers_ShouldReturnTrue(int number) {
        assertTrue(calculator.isEven(number), number + " es un número par");
    }

    // Test Fallidos
    @Test
    void divide_ByZero_ThrowsExeption() {
        // Arrange - preparación para la prueba
        int a = 10;
        int b = 0;
        // Act - ejecución de la prueba
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(a, b),
                "División por cero debe lanzar una excepción");
    }

    @Test
    void divide_ByZero_AssertsThrowsExeption() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(3, 0),
                "División por cero debe lanzar una excepción");
        assertEquals("The divisor cannot be zero.", illegalArgumentException.getMessage());
    }
}
