import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        StudentManager studentManager = new StudentManager();
        ClassSubjectManager classSubjectManager = new ClassSubjectManager();
        StudentOperations studentOperations = new StudentOperations(scanner, studentManager, classSubjectManager);

        //Temporary
        Subject maths = new Subject(101, "Mathematics");
        Subject english = new Subject(102, "English");
        Subject physics = new Subject(103, "Physics");
        Subject socialScience = new Subject(104, "Social Science");
        Subject history = new Subject(105, "History");
        Subject bengali = new Subject(106, "Bengali");

        classSubjectManager.addSubjectToClass(10, maths);
        classSubjectManager.addSubjectToClass(10, english);
        classSubjectManager.addSubjectToClass(10, physics);
        classSubjectManager.addSubjectToClass(10, socialScience);
        classSubjectManager.addSubjectToClass(10, history);
        classSubjectManager.addSubjectToClass(10, bengali);

        SubjectManager subjectManager = new SubjectManager();
        classSubjectManager = new ClassSubjectManager();

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
        } while (choice != 6);
    }
}
