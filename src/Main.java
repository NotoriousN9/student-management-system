import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        int iD = 0;
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
            choice = scanner.nextInt();
            if(choice > 0 && choice <= 6) {
                switch(choice) {
                    case 1:
                        while(true) {
                            System.out.print("Enter the Student ID(4 DIGIT): ");
                            iD = scanner.nextInt();
                            scanner.nextLine();

                            if(iD < 1000 || iD > 9999) {
                                System.out.println("Enter a valid ID.\n");
                            }

                            else {
                                break;
                            }
                        }

                        System.out.print("Enter the name of the Student: ");
                        name = scanner.nextLine();

                        while(true) {
                            System.out.print("Enter the Student's age: ");
                            age = scanner.nextInt();
                            scanner.nextLine();

                            if (age < 1 || age > 19) {
                                System.out.println("Enter a valid age.");
                            }

                            else {
                                break;
                            }
                        }

                        while(true) {
                            System.out.print("Enter the class of the Student: ");
                            std = scanner.nextInt();
                            scanner.nextLine();

                            if(std < 1 || std > 12) {
                                System.out.println("Enter a valid Class of the Student.");
                            }

                            else{
                                break;
                            }
                        }


                        Student student = new Student(iD, name, age, std);
                        studentManager.addStudent(student);

                        System.out.print("\n");
                        break;


                    case 2:
                        while(true) {
                            System.out.print("Enter the Student ID(4 DIGIT): ");
                            iD = scanner.nextInt();
                            scanner.nextLine();

                            if(iD < 1000 || iD > 9999) {
                                System.out.println("Enter a valid ID.\n");
                            }

                            else {
                                break;
                            }
                        }

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
                        while(true) {
                            System.out.print("Enter the Student ID(4 DIGIT): ");
                            iD = scanner.nextInt();
                            scanner.nextLine();

                            if(iD < 1000 || iD > 9999) {
                                System.out.println("Enter a valid ID.\n");
                            }

                            else {
                                break;
                            }
                        }

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
                                        while(true) {
                                            System.out.print("Enter the Student's age: ");
                                            int newAge = scanner.nextInt();
                                            scanner.nextLine();

                                            if (newAge < 1 || newAge > 19) {
                                                System.out.println("Enter a valid age.");
                                            }

                                            else {
                                                findStudent.setStudentAge(newAge);
                                                break;
                                            }
                                        }

                                        break;

                                    case 3:
                                        while(true) {
                                            System.out.print("Enter the class of the Student: ");
                                            int newStd = scanner.nextInt();
                                            scanner.nextLine();

                                            if(newStd < 1 || newStd > 12) {
                                                System.out.println("Enter a valid Class of the Student.");
                                            }

                                            else{
                                                findStudent.setStd(newStd);
                                                break;
                                            }
                                        };
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
                        while(true) {
                            System.out.print("Enter the Student ID(4 DIGIT): ");
                            iD = scanner.nextInt();
                            scanner.nextLine();

                            if(iD < 1000 || iD > 9999) {
                                System.out.println("Enter a valid ID.\n");
                            }

                            else {
                                break;
                            }
                        }

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
            }
        }

    }
}
