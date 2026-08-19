public class StudentView {

    public static void displayStudent(Student student) {
        System.out.println("Student Details: ");
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student Age: " + student.getStudentAge());
        System.out.println("Student Class: " + student.getStd());
        System.out.print("\n");
    }
}
