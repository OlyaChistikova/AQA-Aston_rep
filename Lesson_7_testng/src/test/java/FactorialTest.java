import org.example.Factorial;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Запуск теста факториала");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Завершение теста факториала");
    }

    @Test(description = "Проверка факториала для 5")
    public void testFactorialForFive() {
        assertEquals(Factorial.factorial(5), 120);
    }

    @Test(description = "Проверка факториала для 0")
    public void testFactorialForZero() {
        assertEquals(Factorial.factorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, description = "Некорректный ввод: отрицательное число")
    public void testFactorialNegative() {
        Factorial.factorial(-1);
    }

    @Test(dataProvider = "factorialDataProvider", description = "Параметризованный тест факториала")
    public void testFactorialWithDataProvider(int number, long expected) {
        if (number < 0) {
            assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(number));
        } else {
            assertEquals(Factorial.factorial(number), expected);
        }
    }

    @DataProvider
    public static Object[][] factorialDataProvider(){
        return new Object[][]{
                {1, 1},
                {2, 2},
                {4, 24},
                {-1, 0} // ожидается исключение
        };
    }
}
