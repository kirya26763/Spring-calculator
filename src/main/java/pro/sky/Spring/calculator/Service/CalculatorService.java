package pro.sky.Spring.calculator.Service;

public interface CalculatorService {

    void parametersValid(Integer num1, Integer num2);

    int plus(int num1, int num2);

    int minus(int num1, int num2);

    int multiply(int num1, int num2);

    int divide(int num1, int num2);
}
