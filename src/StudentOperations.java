import java.util.List;
import java.util.Scanner;

public class StudentOperations {
    private final Scanner scanner;
    private final StudentManager studentManager;
    private final ClassSubjectManager classSubjectManager;

    private Student getStudentById() {
        int studentId = InputValidator.getValidStudentId(scanner);

        Student student = studentManager.findStudent(studentId);

        if (student == null) {
            System.out.println("\nStudent not found!\n");
        }

        return student;
    }

    public StudentOperations(Scanner scanner, StudentManager studentManager, ClassSubjectManager classSubjectManager) {
        this.scanner = scanner;
        this.studentManager = studentManager;
        this.classSubjectManager = classSubjectManager;
    }

    public void addStudent(){
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

        List<Subject> classSubjects = classSubjectManager.getSubjectsForClass(student.getStd());

        for(Subject subject : classSubjects) {
            student.addSubject(subject);
        }

        if (studentManager.addStudent(student)) {
            System.out.println("Student added successfully.");

            for (Subject subject : student.getSubjects()) {
                System.out.println(subject.getSubjectName());
            }
        }
    }


    public void searchStudent(){
        Student searchStudent =
                getStudentById();

        if (searchStudent != null) {
            StudentView.displayStudent(searchStudent);
        }
    }

    public void updateStudent(){
        Student findStudent =
                getStudentById();

        if (findStudent != null) {

            StudentView.displayStudent(findStudent);

            int change = 0;

            while (change != 4) {
                StudentView.displayUpdateMenu();

                change =
                        InputValidator.getValidChoice(
                                scanner,
                                1,
                                4
                        );

                switch (change) {

                    case 1:
                        updateName(findStudent);
                        break;


                    case 2:
                        updateAge(findStudent);
                        break;


                    case 3:
                        updateClass(findStudent);
                        break;

                    case 4:
                        break;
                }
            }
        }
    }

    public void removeStudent(){
        Student foundStudent =
                getStudentById();

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
    }

    private void updateName(Student student) {
        String oldName =
                student.getStudentName();

        String newName =
                InputValidator.getValidStudentName(
                        scanner
                );

        if (newName.equals(oldName)) {
            System.out.println(
                    "Student name is already that."
            );
        } else {
            student.setStudentName(newName);

            System.out.println(
                    "Student name updated successfully."
            );
        }
    }

    private void updateAge(Student student) {
        int newAge =
                InputValidator.getValidStudentAge(
                        scanner
                );

        if (newAge ==
                student.getStudentAge()) {

            System.out.println(
                    "Student is already " +
                            newAge +
                            " years old."
            );

            return;
        }

        if (StudentInputHelper.validateAgeAndClass(
                scanner,
                newAge,
                student.getStd()
        )) {
            student.setStudentAge(newAge);

            System.out.println(
                    "Student age updated successfully."
            );

        } else {
            System.out.println(
                    "Age was not changed."
            );
        }
    }

    private void updateClass(Student student) {
        int newStd =
                InputValidator.getValidStudentClass(
                        scanner
                );

        if (newStd == student.getStd()) {

            System.out.println(
                    "Student already in Class " +
                            newStd +
                            "."
            );

            return;
        }

        if(StudentInputHelper.validateAgeAndClass(scanner, student.getStudentAge(), newStd)) {
            student.setStd(newStd);

            System.out.println("Student Class changed successfully.");
        }
        else {
            System.out.println("Class was not changed.");
        }
    }
}
