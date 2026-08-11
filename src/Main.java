import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        StudentManager studentManager = new StudentManager();

        System.out.println("""
                ============================================
                         Student Management System
                ============================================
                    1. Add NEW Student.
                    2. Remove EXISTING Student.
                    3. Change Student ATTRIBUTES.
                    4. Search an EXISTING Student.
                    5. View EXISTING Students in Structure.
                    6. Exit
                """);

        while(true) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            if(choice > 0 && choice < 7) {
                break;
            }
            else {
                System.out.println("Enter valid Choice.");
            }
        }

        switch(choice) {
            case 1:
                int iD;
                String name;
                int age;
                int std;

                System.out.print("Enter the Student ID(4 DIGIT): ");
                iD = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the name of the Student: ");
                name = scanner.nextLine();

                System.out.print("Enter the Student's age: ");
                age = scanner.nextInt();

                System.out.print("Enter the class of the Student: ");
                std = scanner.nextInt();

                Student student = new Student(iD, name, age, std);
                studentManager.addStudent(student);
        }

    }
}
