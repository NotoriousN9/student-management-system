import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

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

        while(choice > 0 && choice < 7) {
            System.out.println("Choice: ");
            choice = scanner.nextInt();
        }

    }
}
