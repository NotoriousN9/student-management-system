public class Student {
    StudentManager studentManager = new StudentManager();

    private final int studentId;
    private final String studentName;
    private final int studentAge;
    private final int std;

    public Student(int studentId, String studentName, int studentAge, int std) {
        this.studentId = studentId;
        this.studentAge = studentAge;
        this.studentName = studentName;
        this.std = std;
    }
}
