package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Parameter;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EmailValidatorTest {
    private EmailValidator emailValidator;

    static Stream<Arguments> emailValidatorProvider() {
        Stream<Arguments> ret = Stream.of(
                Arguments.of("ariel@epn.edu.ec", true),
                Arguments.of("ariel@gmail.com", true),
                Arguments.of("ariel.mora", false),
                Arguments.of(null, false));
        return ret;
    }

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @ParameterizedTest
    @MethodSource("emailValidatorProvider")
    void isValid_MultipleEmails_ShouldReturnTrue(String email, boolean expected) {
        // Arrange -Act
        boolean result = emailValidator.isValid(email);
        // Assert
        assertEquals(expected, result);
    }
}
