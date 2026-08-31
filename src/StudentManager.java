import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if(searchStudent(student.getStudentId()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

    public boolean studentIdExists(int studentId) {
        return searchStudent(studentId) != null;
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    public Student searchStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    public boolean removeStudent(int studentId) {
        return students.removeIf(
                student -> student.getStudentId() == studentId
        );
    }
}
