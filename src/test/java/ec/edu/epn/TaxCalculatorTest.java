package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TaxCalculatorTest {
    private TaxCalculator taxCalculator;

    static Stream<Arguments> taxCalculatorProvider() {
        Stream<Arguments> ret = Stream.of(
                Arguments.of(100.0, 12.0, 112.0),
                Arguments.of(200.0, 15.0, 230.0),
                Arguments.of(50.0, 8.0, 54.0));
        return ret;
    }

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxCalculator();
    }

    @ParameterizedTest
    @MethodSource("taxCalculatorProvider")
    void isValid_MultipleTax_ShouldReturnTrue(double valor, double impuesto, double expected) {
        // Arrange - Act
        double result = taxCalculator.calculatorTax(valor, impuesto);
        // Assert
        assertEquals(expected, result, 0.001, "El cálculo del impuesto es incorrecto");
    }
}
