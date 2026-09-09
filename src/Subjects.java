public class Subjects {
    private final int subjectCode;
    private String subjectName;

    public Subjects(int subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public int getSubjectCode(){
        return subjectCode;
    }

    public String getSubjectName(){
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
