import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {
    private final Map<Integer, Student> students = new LinkedHashMap<>();

    public boolean addStudent(Student student) {
        if(studentIdExists(student.getStudentId())) {
            return false;
        }

        students.put(student.getStudentId(), student);
        return true;
    }

    public boolean studentIdExists(int studentId) {
        return students.containsKey(studentId);
    }

    public List<Student> getStudents() {
        return List.copyOf(students.values());
    }

    public Student findStudent(int studentId) {
        return students.get(studentId);
    }

    public boolean removeStudent(int studentId) {
        return students.remove(studentId) != null;
    }
}
