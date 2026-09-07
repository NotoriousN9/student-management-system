import java.util.Scanner;

public class InputValidator {

    public static String getValidStudentName (Scanner scanner) {
        while (true) {
            System.out.print("Enter the name of the Student: ");
            String studentName = scanner.nextLine().trim();

            if(StudentRules.isValidStudentName(studentName)) {
                return studentName;
            }

            System.out.println("Enter a valid student name.\n");
        }
    }

    public static int getValidStudentId(Scanner scanner) {
        while(true) {
            System.out.print("Enter the Student ID(4 DIGIT): ");

            if(scanner.hasNextInt()) {
                int studentId = scanner.nextInt();
                scanner.nextLine();

                if (StudentRules.isValidStudentId(studentId)) {
                    return studentId;
                }

            }
            else{
                scanner.nextLine();
            }

            System.out.println("Enter a valid ID.\n");
        }
    }

    public static int getValidStudentAge(Scanner scanner) {
        while(true) {
            System.out.print("Enter the Student's age: ");

            if(scanner.hasNextInt()) {
                int studentAge = scanner.nextInt();
                scanner.nextLine();

                if (StudentRules.isValidStudentAge(studentAge)) {
                    return studentAge;
                }
            }
            else{
                scanner.nextLine();
            }

            System.out.println("Enter a valid age.\n");
        }
    }

    public static int getValidStudentClass (Scanner scanner) {
        while(true) {
            System.out.print("Enter the class of the Student: ");

            if(scanner.hasNextInt()) {
                int studentStd = scanner.nextInt();
                scanner.nextLine();

                if(StudentRules.isValidStudentClass(studentStd)) {
                    return studentStd;
                }
            }
            else{
                scanner.nextLine();
            }

            System.out.println("Enter a valid Class of the Student.\n");
        }
    }

    public static int getValidChoice(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Enter a valid choice.");
        }
    }

    public static boolean getValidYOrN(Scanner scanner) {
        while (true) {
            String choice = scanner.nextLine();

            if(choice.equalsIgnoreCase("Y")) {
                return true;
            }

            if (choice.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.print("Please enter Y or N: ");
        }
    }
}