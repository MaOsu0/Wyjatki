package Zadanie2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CompetitionController {
    private Scanner scanner = new Scanner(System.in);

    void run() {
        Competition competition = createCompetition();
        fillParticipantsInfo(competition);
        printCompetition(competition);
    }

    private Competition createCompetition() {
        Competition result = null;
        try {
            System.out.println("Podaj nazwę zawodów:");
            String competitionName = scanner.nextLine();
            System.out.println("Podaj maksymalną liczbę uczestników:");
            int maxParticipants = scanner.nextInt();
            if (maxParticipants <= 0) {
                throw new IllegalArgumentException("Nie może być ujemna lub zerowa liczba uczestników");
            }
            System.out.println("Podaj ograniczenie wiekowe:");
            int ageLimit = scanner.nextInt();
            if (ageLimit <= 0) {
                throw new IllegalArgumentException("Limit wieku nie może wynosić mniej niż 1");
            }
            scanner.nextLine();
            result = new Competition(competitionName, maxParticipants, ageLimit);
        }catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    private void fillParticipantsInfo(Competition competition) {
        while (competition.hasFreeSpots()) {
            try {
                System.out.println("Dodaj nowego uczestnika");
                Participant participant = createParticipant();
                competition.addParticipant(participant);
            } catch (AgeViolationException | MaxCompetitorsException | DuplicateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private Participant createParticipant() {
        Participant result = null;
        try {
            System.out.println("Podaj imię:");
            String firstName = scanner.nextLine();
            System.out.println("Podaj nazwisko:");
            String lastName = scanner.nextLine();
            System.out.println("Podaj id (np. pesel):");
            String id = scanner.nextLine();
            if (Integer.parseInt(id) <= 0) {
                throw new IllegalArgumentException("Wartość id niepoprawna");
            }
            System.out.println("Podaj wiek:");
            int age = scanner.nextInt();
            if (age <= 0) {
                throw new IllegalArgumentException("Wiek nie może być mniejszy niż 1");
            }
            scanner.nextLine();
            result = new Participant(firstName, lastName, id, age);
        } catch (InputMismatchException e) {
            System.err.println("Nieprawidłowy format wprowadzonych danych");
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        return result;
    }

    private void printCompetition(Competition competition) {
        System.out.println(competition.toString());
    }
}
