package Lekcja.exeptions;

public class SchoolTest {
    public static void main(String[] args) {
        School school = new School(2);


        try {
            school.add(new Student(1, "Jan", "Kowalski"));
            school.add(new Student(2, "Marta", "Zawadzka"));
            school.add(new Student(3, "Paweł", "Bogucki"));
        } catch (NoMoreSpaceExeption e) {
            System.out.println(e.getMessage());
        }


        try {
            Student student = school.find("Krzysztofa", "Zawadzki");
            System.out.println("Znaleziony student id: " + student.getStudentId());
        } catch (NoElementFoundExeption e) {
            System.out.println(e.getMessage());
        }


    }

}
