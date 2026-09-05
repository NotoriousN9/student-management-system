public class Student {
    private final int studentId;
    private String studentName;
    private int studentAge;
    private int std;

    public Student(int studentId, String studentName, int studentAge, int std) {
        if(!StudentRules.isValidStudentName(studentName)) {
            throw new IllegalArgumentException("Invalid Student Name");
        }

        if(!StudentRules.isValidStudentId(studentId)) {
            throw new IllegalArgumentException("Invalid Student ID");
        }

        if (!StudentRules.isValidStudentAge(studentAge)) {
            throw new IllegalArgumentException("Invalid Student Age");
        }

        if(!StudentRules.isValidStudentClass(std)) {
            throw new IllegalArgumentException("Invalid Student Class");
        }

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
        if(!StudentRules.isValidStudentName(studentName)) {
            throw new IllegalArgumentException("Invalid Student Name");
        }

        this.studentName = studentName;
    }

    public void setStudentAge(int studentAge) {
        if(!StudentRules.isValidStudentAge(studentAge)) {
            throw new IllegalArgumentException("Invalid Student Age");
        }

        this.studentAge = studentAge;
    }

    public void setStd(int std) {
        if(!StudentRules.isValidStudentClass(std)) {
            throw new IllegalArgumentException("Invalid Student Class");
        }

        this.std = std;
    }

}
