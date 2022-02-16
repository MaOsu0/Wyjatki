package Lekcja.trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lekcja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[2];
        boolean error = true;

        do {
            try {
                System.out.println("Podaj 1 liczbę");
                numbers[0] = sc.nextInt();
                System.out.println("Podaj 2 liczbę");
                numbers[1] = sc.nextInt();

                System.out.println("Którą wartośc chcesz wyświetlić ? 1 czy 2");
                System.out.println("Liczba " + numbers[sc.nextInt() - 1]);
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Nie podałeś liczby całkowitej");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Miało być 1 lub 2, zacznijmy od nowa");
            } finally {
                sc.nextLine();
            }
        } while (error);
        sc.close();
    }
}
