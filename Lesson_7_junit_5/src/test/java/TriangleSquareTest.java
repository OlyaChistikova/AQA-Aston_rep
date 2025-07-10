import org.example.TriangleSquare;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TriangleSquareTest {

    @BeforeEach
    void setUp() {
        System.out.println("Запуск теста площади треугольника");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Завершение теста площади треугольника");
    }

    @Test
    @DisplayName("Площадь треугольника со сторонами 3, 4, 5")
    void testValidTriangle() {
        Assertions.assertEquals(6.0, TriangleSquare.square(3, 4, 5), 0.0001);
    }

    @DisplayName("Получаем площадь треугольника для параметров")
    @ParameterizedTest(name = "Площадь для сторон {0}, {1}, {2}")
    @MethodSource("TriangleSquareDataProvider")
    public void testTriangleSquareWithParameters(double param1, double param2, double param3, double expected) {
        if (param1 <= 0 || param2 <= 0 || param3 <= 0 ) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> TriangleSquare.square(param1, param2, param3));
        } else {
            Assertions.assertEquals(expected, TriangleSquare.square(param1, param2, param3), 0.0001);
        }
    }

    static Stream<Arguments> TriangleSquareDataProvider() {
        return Stream.of(
                arguments(3, 4, 5, 6.0),
                arguments(5, 12, 13, 30.0),
                arguments(1, 1, 2, 0.0) // не существует, sqrt(0) = 0
        );
    }
}
