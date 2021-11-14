import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    Calculator sut;


    @BeforeEach
    public void init() {
        System.out.println("Начало теста");
        sut = new Calculator();
    }

    @BeforeAll
    public static void started() {
        System.out.println("test started");
    }

    @AfterEach
    public void finished() {
        System.out.println("Конец теста");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("test completed");
    }

    @Test //Тест на сложение
    public void plus() {
        //given
        int x = 2;
        int y = 7;
        int expected = 9;
        //when
        int result = sut.plus.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest //Параметризованный тест
    @MethodSource("MinusEnd")
    public void minus(int x, int y, int expected) {
        int result = sut.minus.apply(x, y);
        Assertions.assertEquals(expected, result);
    }

    protected static Stream<Arguments> MinusEnd() {
        return Stream.of(
                Arguments.of(4, 1, 3),
                Arguments.of(5, 1, 4),
                Arguments.of(0, 1, -1),
                Arguments.of(7, 6, 1),
                Arguments.of(3, 3, 0)
        );
    }

    @Test //Тест на положительное число
    public void positiveNumber() {
        //given
        Calculator sut = new Calculator();
        final int x = -2;
        final Boolean expected = false;
        //when
        final Boolean result = sut.isPositive.test(x);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test //Тест на деление
    public void devide() {
        //given
        int x = 4;
        int y = 2;
        int expected = 2;
        //when
        int result = sut.devide.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }
}
