import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class CalculatorTest {

    static Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testStringAddition() {
        String input = "3:5"; // Simulate user input
        Assertions.assertThat(calculator.add(input)).isEqualTo(8);
    }

    @Test
    void testRunAddition() {
        String input = "3 + 5\n"; // Simulate user input
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = calculator.run();

        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    void testRunSubtraction() {
        String input = "10 - 4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = calculator.run();

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void testRunMultiplication() {
        String input = "7 * 3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = calculator.run();

        Assertions.assertThat(result).isEqualTo(21);
    }

    @Test
    void testRunDivision() {
        String input = "12 / 4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = calculator.run();

        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void testRunMultipleOperations() {
        String input = "10 + 5 - 3 * 2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = calculator.run();

        Assertions.assertThat(result).isEqualTo(24);
    }

    @Test
    void testRunInvalidInput() {
        String input = "3 + x\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = calculator.run();

        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void testRunEmptyInput() {
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = calculator.run();

        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void testRunDivisionByZero() {
        String input = "5 / 0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = calculator.run();

        Assertions.assertThat(result).isEqualTo(0);
    }
}
