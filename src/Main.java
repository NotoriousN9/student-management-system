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

        while(choice != 6) {
            System.out.println();
            System.out.print("Enter your choice: ");
            System.out.println();
            choice = scanner.nextInt();
            if(choice > 0 && choice <= 6) {
                switch(choice) {
                    case 1:
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

                        System.out.print("\n");
                        break;


                    case 2:
                        System.out.print("Enter the Student ID(4 DIGIT): ");
                        System.out.println();
                        iD = scanner.nextInt();
                        scanner.nextLine();

                        Student searchStudent = studentManager.searchStudents(iD);

                        if (searchStudent != null) {
                            System.out.println("Student Details: ");
                            System.out.println("Student ID: " + searchStudent.getStudentId());
                            System.out.println("Student Name: " + searchStudent.getStudentName());
                            System.out.println("Student Age: " + searchStudent.getStudentAge());
                            System.out.println("Student Class: " + searchStudent.getStd());
                            System.out.print("\n");


                        }

                        else {
                            System.out.println();
                            System.out.println("Student not Found!");
                        }

                        break;

                    case 3:
                        System.out.print("Enter the ID of the student(4 Digits): ");
                        System.out.println();
                        iD = scanner.nextInt();
                        scanner.nextLine();

                        Student findStudent = studentManager.searchStudents(iD);

                        if(findStudent != null) {
                            System.out.println("Student Details: ");
                            System.out.println("Student ID: " + findStudent.getStudentId());
                            System.out.println("Student Name: " + findStudent.getStudentName());
                            System.out.println("Student Age: " + findStudent.getStudentAge());
                            System.out.println("Student Class: " + findStudent.getStd());
                            System.out.print("\n");

                            int change = 0;

                            while(change != 4) {
                                System.out.println("CHANGE ATTRIBUTES");
                                System.out.println("1. Change Student Name.");
                                System.out.println("2. Change Student Age.");
                                System.out.println("3. Change Student Class.");
                                System.out.println("4. Exit.");
                                System.out.print("What to change?: ");
                                change = scanner.nextInt();
                                scanner.nextLine();

                                switch (change) {
                                    case 1:
                                        System.out.println();
                                        System.out.print("Enter the new Name: ");
                                        String newName = scanner.nextLine();
                                        findStudent.setStudentName(newName);
                                        break;

                                    case 2:
                                        System.out.println();
                                        System.out.print("Enter the new Age: ");
                                        int newAge = scanner.nextInt();
                                        scanner.nextLine();
                                        findStudent.setStudentAge(newAge);
                                        break;

                                    case 3:
                                        System.out.println();
                                        System.out.print("Enter the new Class: ");
                                        int newStd = scanner.nextInt();
                                        scanner.nextLine();
                                        findStudent.setStd(newStd);
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
                        System.out.print("Enter the ID of the student(4 Digit): ");
                        iD = scanner.nextInt();
                        scanner.nextLine();

                        Student foundStudent = studentManager.searchStudents(iD);

                        if (foundStudent != null) {
                                System.out.println("Student Details: ");
                                System.out.println("Student ID: " + foundStudent.getStudentId());
                                System.out.println("Student Name: " + foundStudent.getStudentName());
                                System.out.println("Student Age: " + foundStudent.getStudentAge());
                                System.out.println("Student Class: " + foundStudent.getStd());
                                System.out.print("\n");

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
                            System.out.println("Student Details: ");
                            System.out.println("Student ID: " + studentView.getStudentId());
                            System.out.println("Student Name: " + studentView.getStudentName());
                            System.out.println("Student Age: " + studentView.getStudentAge());
                            System.out.println("Student Class: " + studentView.getStd());
                            System.out.print("\n");
                        }

                        break;
                }
            }
            else {
                System.out.println();
                System.out.println("Enter valid Choice.");
                System.out.println();
            }
        }

    }
}
