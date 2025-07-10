import org.example.CompareNumbers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CompareNumbersTest {

    @BeforeEach
    void setUp() {
        System.out.println("Запуск теста сравнения чисел");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Завершение теста сравнения чисел");
    }

    @DisplayName("Сравнивнение {0} и {1}")
    @ParameterizedTest
    @MethodSource("compareNumbersDataProvider")
    public void testCompareWithParameters(int a, int b, String expected){
        Assertions.assertEquals(expected, CompareNumbers.compare(a, b));
    }

    static Stream<Arguments> compareNumbersDataProvider(){
        return Stream.of(
                arguments(5, 2, "a больше чем b"),
                arguments(1, 3, "a меньше чем b"),
                arguments(4, 4, "a равно b"),
                arguments(0, 0, "a равно b"),
                arguments(-1, 0, "a меньше чем b"),
                arguments(0, -1, "a больше чем b")
        );
    }
}
