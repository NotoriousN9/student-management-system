import java.util.ArrayList;
import java.util.List;

public class Student {
    private final int studentId;
    private final String studentName;
    private final int studentAge;

    private List<Student> students = new ArrayList<>();

    Student(int studentId, String studentName, int studentAge) {
        this.studentId = studentId;
        this.studentAge = studentAge;
        this.studentName = studentName;
    }

    
}
