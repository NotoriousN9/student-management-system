import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        int iD;
        String name;
        int age;
        int std;

        StudentManager studentManager = new StudentManager();

        while(choice != 6) {
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

                switch(choice) {
                    case 1:
                        while (true) {
                            iD = InputValidator.getValidStudentId(scanner);

                            if (studentManager.searchStudents(iD) == null) {
                                break;
                            }
                            System.out.println("Student ID already exists. Enter a different Valid ID.\n");
                        }

                        System.out.println();
                        System.out.print("Enter the name of the Student: ");
                        name = scanner.nextLine();

                        while (true) {
                            age = InputValidator.getValidStudentAge(scanner);
                            std = InputValidator.getValidStudentClass(scanner);

                            if (StudentRules.isAgeClassValid(age, std)) {
                                break;
                            }

                            else {
                                int stdNew = std + 5;
                                System.out.printf("\nThe Age and Class combination don't really add up. (Expected Age %d-%d-%d for Class %d)\n", stdNew - 1, stdNew, stdNew + 1, std);
                                System.out.print("Treat this as an exception? (Y / N): ");
                                boolean exceptionAgeClass = InputValidator.getValidYOrN(scanner);

                                if(exceptionAgeClass) {
                                    break;
                                }

                                System.out.println("Try entering details again.");

                            }
                        }

                        Student student = new Student(iD, name, age, std);
                        studentManager.addStudent(student);
                        System.out.println("Student added successfully.");

                        System.out.print("\n");
                        break;


                    case 2:
                        iD = InputValidator.getValidStudentId(scanner);

                        Student searchStudent = studentManager.searchStudents(iD);

                        if (searchStudent != null) {
                            StudentView.displayStudent(searchStudent);
                        }

                        else {
                            System.out.println("\nStudent not Found!\n");
                        }

                        break;

                    case 3:
                        iD = InputValidator.getValidStudentId(scanner);

                        Student findStudent = studentManager.searchStudents(iD);

                        if(findStudent != null) {
                            StudentView.displayStudent(findStudent);

                            int change = 0;

                            while(change != 4) {
                                System.out.println("CHANGE ATTRIBUTES");
                                System.out.println("1. Change Student Name.");
                                System.out.println("2. Change Student Age.");
                                System.out.println("3. Change Student Class.");
                                System.out.println("4. Exit.");
                                System.out.print("What to change?: ");
                                change = InputValidator.getValidChoice(scanner, 1, 4);

                                switch (change) {
                                    case 1:
                                        System.out.println();
                                        System.out.print("Enter the new Name: ");
                                        String newName = scanner.nextLine();
                                        findStudent.setStudentName(newName);
                                        System.out.println("New Name set successfully.\n");

                                        break;

                                    case 2:
                                        int newAge = InputValidator.getValidStudentAge(scanner);

                                        if(StudentRules.isAgeClassValid(newAge, findStudent.getStd())) {
                                            findStudent.setStudentAge(newAge);
                                            System.out.println("New Age set successfully.\n");
                                        }
                                        else {
                                            int expectedAge = findStudent.getStd() + 5;

                                            System.out.printf("\nThe Age and Class combination don't really add up. (Expected Age %d-%d-%d for Class %d)\n", expectedAge - 1, expectedAge, expectedAge + 1, findStudent.getStd());

                                            System.out.print("Treat this as an exception? (Y / N): ");

                                            boolean exceptionAgeClass = InputValidator.getValidYOrN(scanner);

                                            if(exceptionAgeClass) {
                                                findStudent.setStudentAge(newAge);
                                                System.out.println("Age and Class set successfully.");
                                            }
                                            else {
                                                System.out.println("Age was not changed.");
                                            }
                                        }

                                        break;

                                    case 3:
                                        int newStd = InputValidator.getValidStudentClass(scanner);
                                        findStudent.setStd(newStd);
                                        System.out.println("New Class set successfully.\n");

                                        break;

                                    case 4:
                                        break;
                                }
                            }
                        }

                        else{
                            System.out.println();
                            System.out.println("Student not found.");
                        }

                        break;


                    case 4:
                        iD = InputValidator.getValidStudentId(scanner);

                        Student foundStudent = studentManager.searchStudents(iD);

                        if (foundStudent != null) {
                            StudentView.displayStudent(foundStudent);

                            String delete;

                            while (true) {
                                System.out.print("Delete the Student? (press Y or N) : ");
                                delete = scanner.nextLine();

                                if(delete.equals("Y") || delete.equals("y")) {
                                    studentManager.removeStudent(foundStudent.getStudentId());
                                    System.out.println();
                                    System.out.println("Student removed successfully!");
                                    System.out.println();
                                    break;

                                } else if (delete.equals("N") || delete.equals("n")) {
                                    System.out.println();
                                    System.out.println("Operation Terminated");
                                    System.out.println();
                                    break;

                                } else {
                                    System.out.println();
                                    System.out.println("Try again.");
                                    System.out.println();
                                }
                            }
                        }

                        else {
                            System.out.println();
                            System.out.println("Student not Found!");
                            System.out.println();
                        }

                        break;


                    case 5:
                        List<Student> students = studentManager.getStudents();

                        for (Student studentView : students) {
                            StudentView.displayStudent(studentView);
                        }

                        break;
                }
        }
    }
}
