package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class StringValidatorTest {
    StringValidator stringValidator;

    @BeforeEach
    void setUp() {
        stringValidator = new StringValidator();
    }

    @AfterEach
    void tearDown() {
        // If StringValidator later implements AutoCloseable or holds resources,
        // close them safely to avoid resource leaks.
        if (stringValidator instanceof AutoCloseable) {
            try {
                ((AutoCloseable) stringValidator).close();
            } catch (Exception e) {
                throw new RuntimeException("Failed to close stringValidator", e);
            }
        }
        stringValidator = null;
    }

    private static class TestData {
        final String text;
        final boolean expectedResult;

        public TestData(String text, boolean expectedResult) {
            this.text = text;
            this.expectedResult = expectedResult;
        }

    }

    @TestFactory
    Collection<DynamicTest> dynamicPalindrome() {
        List<TestData> testDataList = Arrays.asList(
                new TestData("radar", true),
                new TestData("level", true),
                new TestData("hello", false),
                new TestData("", true),
                new TestData(null, false));
        return testDataList.stream()
                .map(data -> DynamicTest.dynamicTest(
                        "Verificando Palíndromo: " + data.text,
                        () -> {
                            boolean result = stringValidator.isPalindrome(data.text);
                            if (data.expectedResult) {
                                assertTrue(result);
                            } else {
                                assertFalse(result);
                            }
                        })).collect(Collectors.toList());
    }

}
