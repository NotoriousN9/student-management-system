public class Student {
    private final int studentId;
    private String studentName;
    private int studentAge;
    private int std;

    public Student(int studentId, String studentName, int studentAge, int std) {
        this.studentId = studentId;
        this.studentAge = studentAge;
        this.studentName = studentName;
        this.std = std;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public int getStd() {
        return std;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public void setStd(int std) {
        this.std = std;
    }

}
