package pro.sky.Spring.calculator.ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Spring.calculator.Exceptions.DivisionByZeroException;
import pro.sky.Spring.calculator.Exceptions.InvalidParameterException;
import pro.sky.Spring.calculator.Service.CalculatorService;
import pro.sky.Spring.calculator.Service.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setApp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void plusTest1() {
        int result = calculatorService.plus(5, 3);
        assertEquals(8, result);
    }

    @Test
    void plusTest2() {
        int result = calculatorService.plus(-2, 7);
        assertEquals(5, result);
    }

    @Test
    void minusTest1() {
        int result = calculatorService.minus(5, 3);
        assertEquals(2, result);
    }

    @Test
    void minusTest2() {
        int result = calculatorService.minus(10, 20);
        assertEquals(-10, result);
    }

    @Test
    void multiplyTest1() {
        int result = calculatorService.multiply(2, 3);
        assertEquals(6, result);
    }

    @Test
    void multiplyTest2() {
        int result = calculatorService.multiply(-4, 5);
        assertEquals(-20, result);
    }

    @Test
    void divideTest1() {
        int result = calculatorService.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    void divideTest2() {
        int result = calculatorService.divide(9, 3);
        assertEquals(3, result);
    }

    @Test
    void divideShouldThrowExceptionWhenDivideByZero() {
        DivisionByZeroException exception = assertThrows(DivisionByZeroException.class, () ->
                calculatorService.divide(10, 0)
        );
        assertEquals("Error: Деление на ноль.", exception.getMessage());
    }

    @Test
    void parametersValidShouldThrowWhenNull1() {
        assertThrows(InvalidParameterException.class, () -> calculatorService.parametersValid(null, 5));
    }

    @Test
    void parametersValidShouldThrowWhenNull2() {
        assertThrows(InvalidParameterException.class, () -> calculatorService.parametersValid(5, null));
    }

    @Test
    void parametersValidShouldThrowWhenBothNull() {
        assertThrows(InvalidParameterException.class, () -> calculatorService.parametersValid(null, null));
    }

    @Test
    void parametersValidShouldPassWhenNotNull() {
        assertDoesNotThrow(() -> calculatorService.parametersValid(5, 10));
    }
}