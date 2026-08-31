import java.util.List;
import java.util.Scanner;

public class Main {

    private static Student getStudentById(
            Scanner scanner,
            StudentManager studentManager
    ) {
        int studentId = InputValidator.getValidStudentId(scanner);

        Student student = studentManager.searchStudent(studentId);

        if (student == null) {
            System.out.println("\nStudent not found!\n");
        }

        return student;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        StudentManager studentManager = new StudentManager();

        while (choice != 6) {
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
                    int studentId;

                    while (true) {
                        studentId = InputValidator.getValidStudentId(scanner);

                        if (!studentManager.studentIdExists(studentId)) {
                            break;
                        }

                        System.out.println(
                                "Student ID already exists. " +
                                        "Enter a different Valid ID.\n"
                        );
                    }

                    String name = InputValidator.getValidStudentName(scanner);

                    int age;
                    int std;

                    while (true) {
                        age = InputValidator.getValidStudentAge(scanner);
                        std = InputValidator.getValidStudentClass(scanner);

                        if (StudentInputHelper.validateAgeAndClass(scanner, age, std)) {
                            break;
                        }

                        System.out.println("Try entering details again.");
                    }

                    Student student = new Student(
                            studentId,
                            name,
                            age,
                            std
                    );

                    if (studentManager.addStudent(student)) {
                        System.out.println("Student added successfully.");
                    }

                    break;


                case 2:
                    Student searchStudent =
                            getStudentById(scanner, studentManager);

                    if (searchStudent != null) {
                        StudentView.displayStudent(searchStudent);
                    }

                    break;


                case 3:
                    Student findStudent =
                            getStudentById(scanner, studentManager);

                    if (findStudent != null) {

                        StudentView.displayStudent(findStudent);

                        int change = 0;

                        while (change != 4) {
                            System.out.println();
                            System.out.println("CHANGE ATTRIBUTES");
                            System.out.println("1. Change Student Name.");
                            System.out.println("2. Change Student Age.");
                            System.out.println("3. Change Student Class.");
                            System.out.println("4. Exit.");

                            change =
                                    InputValidator.getValidChoice(
                                            scanner,
                                            1,
                                            4
                                    );

                            switch (change) {

                                case 1:
                                    String oldName =
                                            findStudent.getStudentName();

                                    String newName =
                                            InputValidator.getValidStudentName(
                                                    scanner
                                            );

                                    if (newName.equals(oldName)) {
                                        System.out.println(
                                                "Student name is already that."
                                        );
                                    } else {
                                        findStudent.setStudentName(newName);

                                        System.out.println(
                                                "Student name updated successfully."
                                        );
                                    }

                                    break;


                                case 2:
                                    int newAge =
                                            InputValidator.getValidStudentAge(
                                                    scanner
                                            );

                                    if (newAge ==
                                            findStudent.getStudentAge()) {

                                        System.out.println(
                                                "Student is already " +
                                                        newAge +
                                                        " years old."
                                        );

                                        break;
                                    }

                                    if (StudentInputHelper.validateAgeAndClass(
                                            scanner,
                                            newAge,
                                            findStudent.getStd()
                                    )) {

                                        findStudent.setStudentAge(newAge);

                                        System.out.println(
                                                "Student age updated successfully."
                                        );

                                    } else {

                                        System.out.println(
                                                "Age was not changed."
                                        );
                                    }

                                    break;


                                case 3:
                                    int newStd =
                                            InputValidator.getValidStudentClass(
                                                    scanner
                                            );

                                    if (newStd == findStudent.getStd()) {

                                        System.out.println(
                                                "Student already in Class " +
                                                        newStd +
                                                        "."
                                        );

                                        break;
                                    }

                                    if(StudentInputHelper.validateAgeAndClass(scanner, findStudent.getStudentAge(), newStd)) {
                                        findStudent.setStd(newStd);

                                        System.out.println("Student Class changed successfully.");
                                    }
                                    else {
                                        System.out.println("Class was not changed.");
                                    }

                                    break;

                                case 4:
                                    break;
                            }
                        }
                    }

                    break;


                case 4:
                    Student foundStudent =
                            getStudentById(scanner, studentManager);

                    if (foundStudent != null) {

                        StudentView.displayStudent(foundStudent);

                        System.out.print(
                                "Delete the Student? (press Y or N): "
                        );

                        boolean delete =
                                InputValidator.getValidYOrN(scanner);

                        if (delete) {

                            studentManager.removeStudent(
                                    foundStudent.getStudentId()
                            );

                            System.out.println();
                            System.out.println(
                                    "Student removed successfully!"
                            );

                        } else {

                            System.out.println();
                            System.out.println(
                                    "Operation Terminated"
                            );
                        }

                        System.out.println();
                    }

                    break;


                case 5:
                    StudentView.displayStudents(studentManager.getStudents());
                    break;
            }
        }
    }
}