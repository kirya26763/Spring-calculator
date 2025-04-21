package pro.sky.Spring.calculator.Service;

import org.springframework.stereotype.Service;
import pro.sky.Spring.calculator.Exceptions.DivisionByZeroException;
import pro.sky.Spring.calculator.Exceptions.InvalidParameterException;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public void parametersValid(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new InvalidParameterException("Оба параметра должны быть переданы");
        }
    }

    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new DivisionByZeroException();
        }
        return num1/num2;
    }
}
