import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student searchStudents(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    public boolean removeStudent(int studentId) {
        Iterator<Student> iterator = students.iterator();

        while(iterator.hasNext()) {
            Student student = iterator.next();

            if(student.getStudentId() == studentId) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
