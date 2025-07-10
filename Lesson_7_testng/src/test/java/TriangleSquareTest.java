import org.example.TriangleSquare;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;


public class TriangleSquareTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Запуск теста площади треугольника");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Завершение теста площади треугольника");
    }

    @Test(description = "Площадь треугольника со сторонами 3, 4, 5")
    public void testValidTriangle() {
        assertEquals(TriangleSquare.square(3, 4, 5), 6.0, 0.0001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Некорректные стороны")
    public void testInvalidSides() {
        TriangleSquare.square(-3, 4, 5);
        TriangleSquare.square(3, 0, 5);
        TriangleSquare.square(3, 4, -5);
    }

    @Test(dataProvider = "TriangleSquareDataProvider", description = "Параметризованный тест сторон треугольника")
    public void testTriangleSquareWithDataProvider( double param1, double param2, double param3, double expected) {
        if (param1 <= 0 || param2 <= 0 || param3 <= 0) {
            assertThrows(IllegalArgumentException.class, () -> TriangleSquare.square(param1, param2, param3));
        } else {
            assertEquals(TriangleSquare.square(param1, param2, param3), expected, 0.0001);
        }
    }

    @DataProvider
    public static Object[][] TriangleSquareDataProvider() {
        return new Object[][] {
                {3, 4, 5, 6.0},
                {5, 12, 13, 30.0},
                {1, 1, 2, 0.0}
        };
    }
}
