import org.example.CompareNumbers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareNumbersTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Запуск теста сравнения чисел");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Завершение теста сравнения чисел");
    }

    @Test(dataProvider = "compareNumbersDataProvider", description = "Сравниваем два целых числа")
    public void testCompareWithDataProvider(int a, int b, String expected){
        assertEquals(CompareNumbers.compare(a, b), expected);
    }

    @DataProvider
    public static Object[][] compareNumbersDataProvider(){
        return new Object[][]{
                {5, 2, "a больше чем b"},
                {1, 3, "a меньше чем b"},
                {4, 4, "a равно b"},
                {0, 0, "a равно b"},
                {-1, 0, "a меньше чем b"},
                {0, -1, "a больше чем b"}
        };
    }
}
