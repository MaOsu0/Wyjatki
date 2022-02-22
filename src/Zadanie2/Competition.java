package Zadanie2;

public class Competition {
    private String name;
    private Participant[] participants;
    private int ageLimit;
    private int size;

    public Competition(String name, int maxParticipants, int ageLimit) {
        this.name = name;
        this.ageLimit = ageLimit;
        this.participants = new Participant[maxParticipants];
    }

    void addParticipant(Participant participant) {
        if (participant.getAge() < ageLimit) {
            throw new AgeViolationException("Nie jest spełniony limit wieku. Minimalny wiek to " + ageLimit);
        }
        if (size >= participants.length) {
            throw new MaxCompetitorsException("Limit maksymalnej liczby uczestników. Obecnie wynosi on "
                    + participants.length);
        }
        checkDuplicate(participant);
        participants[size] = participant;
        size++;
    }

    private void checkDuplicate(Participant participant) {
        for (int i = 0; i < size; i++) {
            if (participants[i].getDocumentId().equals(participant.getDocumentId())) {
                throw new DuplicateException("Uczestnik jest już zapisany na zawody");
            }
        }
    }

    boolean hasFreeSpots() {
        return size < participants.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Zawody ")
                .append(name)
                .append("\n")
                .append("Liczba uczestników: ").append(size);
        for (int i = 0; i < size; i++) {
            builder.append("\n");
            builder.append(" > ");
            builder.append(participants[i].toString());
        }
        return builder.toString();
    }
}
