import java.util.Scanner;

public class InputValidator {

    public static int getValidStudentId(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.print("Enter the Student ID(4 DIGIT): ");
            int studentId = scanner.nextInt();
            scanner.nextLine();

            if (studentId < 1000 || studentId > 9999) {
                return studentId;
            }

            System.out.println("Enter a valid ID.\n");
        }
    }

    public static int getValidStudentAge(Scanner scanner) {
        while(true) {
            System.out.println();
            System.out.print("Enter the Student's age: ");
            int studentAge = scanner.nextInt();
            scanner.nextLine();

            if (studentAge < 1 || studentAge > 19) {
                return studentAge;
            }

            System.out.println("Enter a valid age.\n");
        }
    }

    public static int getValidStudentClass (Scanner scanner) {
        while(true) {
            System.out.println();
            System.out.print("Enter the class of the Student: ");
            int studentStd = scanner.nextInt();
            scanner.nextLine();

            if(studentStd < 1 || studentStd > 12) {
                return studentStd;
            }

            System.out.println("Enter a valid Class of the Student.\n");
        }
    }
}