import java.util.List;

public class StudentView {
    public static void displayUpdateMenu(){
        System.out.println();
        System.out.println("CHANGE ATTRIBUTES");
        System.out.println("1. Change Student Name.");
        System.out.println("2. Change Student Age.");
        System.out.println("3. Change Student Class.");
        System.out.println("4. Exit.");
    }

    public static void displayStudent(Student student) {
        System.out.println("Student Details: ");
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student Age: " + student.getStudentAge());
        System.out.println("Student Class: " + student.getStd());
        System.out.println();
    }

    public static void displayStudents(List<Student> students) {
        if(students.isEmpty()) {
            System.out.println("\nNo student found\n");
            return;
        }

        for (Student student : students) {
            displayStudent(student);
        }
    }
}
