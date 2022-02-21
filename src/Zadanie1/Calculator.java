package Zadanie1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";


    public String option = "";
    Scanner sc = new Scanner(System.in);

    public void calc() {
        boolean error = true;
        do {
            try {
                printText("Wybierz pierwszą liczbę");
                double a = sc.nextDouble();
                printText("Wybierz drugą liczbę");
                double b = sc.nextDouble();
                sc.nextLine();
                printText("Wybierz opcję: + , - , * , / ");
                this.option = sc.nextLine();
                double result = 0;
                switch (option) {
                    case PLUS -> result = plus(a, b);
                    case MINUS -> result = minus(a, b);
                    case MULTIPLY -> result = multiply(a, b);
                    case DIVIDE -> {
                        if (b == 0) {
                            throw new ArithmeticException("Nie możesz dzielić przez 0");
                        } else
                            result = divide(a, b);
                    }
                    default -> throw new UnknownOperatorException("Niewłaściwie wprowadzona operacja");
                }
                printText("wynik działania: " + option + " to: " + result);

            } catch (InputMismatchException ex) {
                System.err.println("Niewłaściwie wprowadzona liczba");
            }
        } while (error);
    }


    private double divide(double a, double b) {
        return a / b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }


    private double plus(double a, double b) {
        return a + b;
    }

    private double minus(double a, double b) {
        return a - b;
    }

    public static void printText(String text) {
        System.out.println(text);
    }

}
