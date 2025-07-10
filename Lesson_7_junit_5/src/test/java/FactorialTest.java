import org.example.Factorial;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FactorialTest {

    @BeforeEach
    void setUp() {
        System.out.println("Запуск теста факториала");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Завершение теста факториала");
    }

    @Test
    @DisplayName("Проверка факториала для 5")
    void testFactorialPositive(){
        Assertions.assertEquals(120, Factorial.factorial(5));
    }

    @Test
    @DisplayName("Проверка факториала для 0")
    void testFactorialZero() {
        Assertions.assertEquals(1, Factorial.factorial(0));
    }

    @Test
    @DisplayName("Проверка отрицательного числа вызывает исключение")
    void testFactorialNegative(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }

    @DisplayName("Проверка факториалов для параметров")
    @ParameterizedTest(name = "Факториал для {0}")
    @MethodSource("factorialDataProvider")
    void testFactorialWithParameters(int number, long expected) {
        if (number < 0) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(number));
        } else {
            Assertions.assertEquals(expected, Factorial.factorial(number));
        }
    }

    static Stream<Arguments> factorialDataProvider() {
        return Stream.of(
                arguments(1, 1),
                arguments(2, 2),
                arguments(4, 24),
                arguments(-1, 0) // ожидается исключение
        );
    }
}
