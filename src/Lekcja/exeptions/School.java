package Lekcja.exeptions;

public class School {

    private Student[] students;
    private int studentNumbers;

    public School(int studentNumbers) {
        students = new Student[studentNumbers];
    }

    public void add(Student s) throws NoMoreSpaceExeption {
        if (studentNumbers >= students.length)
            throw new NoMoreSpaceExeption("Brak miejsca w szkole " + students.length);
        students[studentNumbers] = s;
        studentNumbers++;
    }

    public Student find(String firstName, String lastName) throws NoElementFoundExeption {
        for (int i = 0; i < studentNumbers; i++) {
            if (students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                return students[i];
            }
        }
        throw new NoElementFoundExeption("Nie znaleziono elementu: " + firstName + lastName);
    }
}
