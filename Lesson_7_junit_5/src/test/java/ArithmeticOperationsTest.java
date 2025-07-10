import org.example.ArithmeticOperations;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class ArithmeticOperationsTest {

    @BeforeEach
    void setUp() {
        System.out.println("Запуск теста арифметических операций");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Завершение теста арифметических операций");
    }

    @Test
    @DisplayName("Проверка сложения")
    void testAddition() {
        Assertions.assertEquals(5, ArithmeticOperations.add(2, 3));
    }

    @Test
    @DisplayName("Проверка вычитания")
    void testSubtraction() {
        Assertions.assertEquals(1, ArithmeticOperations.subtract(3, 2));
    }

    @Test
    @DisplayName("Проверка умножения")
    void testMultiplication() {
        Assertions.assertEquals(6, ArithmeticOperations.multiply(2, 3));
    }

    @Test
    @DisplayName("Проверка деления")
    void testDivision() {
        Assertions.assertEquals(2.0, ArithmeticOperations.divide(4, 2));
    }

    @Test
    @DisplayName("Деление на ноль вызывает исключение")
    void testDivisionByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(4, 0));
    }

    @ParameterizedTest(name = "Сложение {0} + {1}")
    @CsvSource({"1, 2, 3", "0, 0, 0", "-1, -1, -2"})
    void testAdditionWithParameters(int a, int b, int expected) {
        Assertions.assertEquals(expected, ArithmeticOperations.add(a, b));
    }
}
