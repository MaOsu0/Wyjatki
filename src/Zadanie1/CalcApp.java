package Zadanie1;

import java.util.InputMismatchException;

public class CalcApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.calc();
        } catch (UnknownOperatorException | ArithmeticException e) {
            Calculator.printText(e.getMessage());
        }
    }
}
