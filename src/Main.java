import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        StudentManager studentManager = new StudentManager();
        StudentOperations studentOperations = new StudentOperations(scanner, studentManager);

        do {
            System.out.println();
            System.out.println("""
                    ============================================
                             Student Management System
                    ============================================
                        1. Add NEW Student.
                        2. Search an EXISTING Student.
                        3. Change Student ATTRIBUTES.
                        4. Remove EXISTING Student.
                        5. View EXISTING Students in Structure.
                        6. Exit
                    """);

            choice = InputValidator.getValidChoice(scanner, 1, 6);

            switch (choice) {

                case 1:
                    studentOperations.addStudent();
                    break;


                case 2:
                    studentOperations.searchStudent();
                    break;


                case 3:
                    studentOperations.updateStudent();
                    break;


                case 4:
                    studentOperations.removeStudent();
                    break;


                case 5:
                    StudentView.displayStudents(studentManager.getStudents());
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Exiting Student Management System...");
                    System.out.println("Goodbye!");
                    break;
            }
        }while (choice != 6);
    }
}
