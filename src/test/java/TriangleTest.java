import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        //System.out.println("¬ыполнитс€ один раз перед всеми тестами");
        logger.info("¬ыполнитс€ один раз перед всеми тестами");

    }

    @BeforeEach
    void beforeEach() {
        //logger.error("LOGERROR ¬ыполнитс€ один раз перед всеми тестами");
        logger.info("¬ыполнитс€ перед запуском каждого теста");

    }

    @Test
    @DisplayName("ѕроверка метода вычислени€ площади треугольника")
    void areaTest() throws IsNotTriangleException {

        double result = new AreaOfTriangle().areaOfTriangle(1,1,1);
        assertThat(result).isGreaterThan(0.43).isLessThan(0.44);
    }

    @ParameterizedTest
    @CsvSource({"3,4,5, 6.0", "6,6,3,8.715", "5,6,3,7.484"})
    void paramAreaTest(int a, int b, int c, double expectedResult) throws IsNotTriangleException {
        double result = new AreaOfTriangle().areaOfTriangle(a,b,c);
        assertEquals(expectedResult,result);
    }

    @Test
    @DisplayName("ѕроверка метода вычислени€ площади треугольника когда одна из сторон меньше или равна 0")
    void areaNegTest() {

        Assertions.assertThrows(IsNotTriangleException.class,()->{
            double result = new AreaOfTriangle().areaOfTriangle(-1,1,1);
        }, "нет исключени€");
    }

    @Test
    @DisplayName("ѕроверка метода вычислени€ площади треугольника когда одна из сторон длинее суммы длин других сторон")
    void NotTriangleTest() {
        Assertions.assertThrows(IsNotTriangleException.class,()->{
            double result = new AreaOfTriangle().areaOfTriangle(100,3,4);
        }, "нет исключени€");
    }

    /*@AfterEach
    void afterEach() {
        System.out.println("ћетод выполнитс€ после каждого теста");
    }*/

    @AfterAll
    static void afterAll() {
        logger.info("ћетод выполнитс€ один раз после выполнени€ всех тестов класса ");
    }
}
