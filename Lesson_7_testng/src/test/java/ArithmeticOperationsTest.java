import org.example.ArithmeticOperations;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class ArithmeticOperationsTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Запуск теста арифметических операций");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Завершение теста арифметических операций");
    }

    @Test(description = "Проверка сложения")
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(2, 3), 5);
    }

    @Test(description = "Проверка вычитания")
    public void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(3, 2), 1);
    }

    @Test(description = "Проверка умножения")
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(2, 3), 6);
    }

    @Test(description = "Проверка деления")
    public void testDivision() {
        assertEquals(ArithmeticOperations.divide(4, 2), 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class, description = "Деление на ноль")
    public void testDivisionByZero() {
        ArithmeticOperations.divide(4, 0);
    }

    @DataProvider
    public static Object[][] arithmeticOperationsDataProvider(){
        return new Object[][]{
                {1, 2, 3},
                {0, 0, 0},
                {-1, -1, -2}
        };
    }

    @Test(dataProvider = "arithmeticOperationsDataProvider", description = "Параметризованный тест сложения")
    public void testAdditionWithDataProvider(int a, int b, int expected) {
        assertEquals(ArithmeticOperations.add(a, b), expected);
    }
}
