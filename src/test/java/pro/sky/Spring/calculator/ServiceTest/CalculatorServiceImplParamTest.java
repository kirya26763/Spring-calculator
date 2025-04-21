package pro.sky.Spring.calculator.ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.Spring.calculator.Service.CalculatorService;
import pro.sky.Spring.calculator.Service.CalculatorServiceImpl;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplParamTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("providePlusArguments")
    void plusTest(int num1, int num2, int expected) {
        int result = calculatorService.plus(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideMinusArguments")
    void minusTest(int num1, int num2, int expected) {
        int result = calculatorService.minus(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideMultiplyArguments")
    void multiplyTest(int num1, int num2, int expected) {
        int result = calculatorService.multiply(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideDivideArguments")
    void divideTest(int num1, int num2, int expected) {
        int result = calculatorService.divide(num1, num2);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideArguments(String operation) {
        return switch (operation) {
            case "plus" -> List.of(
                    Arguments.of(5, 3, 8),
                    Arguments.of(-2, 7, 5)
            ).stream();
            case "minus" -> List.of(
                    Arguments.of(5, 3, 2),
                    Arguments.of(10, 20, -10)
            ).stream();
            case "multiply" -> List.of(
                    Arguments.of(2, 3, 6),
                    Arguments.of(-4, 5, -20)
            ).stream();
            case "divide" -> List.of(
                    Arguments.of(10, 2, 5),
                    Arguments.of(9, 3, 3)
            ).stream();
            default -> Stream.empty();
        };
    }

    static Stream<Arguments> providePlusArguments() {
        return provideArguments("plus");
    }

    static Stream<Arguments> provideMinusArguments() {
        return provideArguments("minus");
    }

    static Stream<Arguments> provideMultiplyArguments() {
        return provideArguments("multiply");
    }

    static Stream<Arguments> provideDivideArguments() {
        return provideArguments("divide");
    }
}