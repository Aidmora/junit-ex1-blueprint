package ec.edu.epn;

public class Calculator {
    /**
     * Adds two integers.
     * 
     * @param a The first number.
     * @param b The second number.
     * @return The sum of a and b.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     * 
     * @param a The number to subtract from.
     * @param b The number to subtract.
     * @return The difference between a and b.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     * 
     * @param a The first number.
     * @param b The second number.
     * @return The product of a and b.
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     * Note: Throws an exception if the divisor is zero.
     * 
     * @param a The numerator (dividend).
     * @param b The divisor.
     * @return The quotient of the division.
     * @throws IllegalArgumentException If the divisor (b) is zero.
     */
    public double divide(int a, int b) {
        if (b == 0) {
            // It's good practice to throw a standard exception for invalid input errors.
            throw new IllegalArgumentException("The divisor cannot be zero.");
        }
        // Cast to (double) to ensure floating-point division, even with integers.
        return (double) a / b;
    }

    /**
     * Checks if a number is even.
     * 
     * @param number The number to check.
     * @return true if the number is even, false otherwise.
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}