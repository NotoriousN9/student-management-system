import java.util.LinkedHashMap;
import java.util.Map;

public class SubjectManager {
    private final Map<Integer, Subject> subjects = new LinkedHashMap<>();

    public boolean addSubject(Subject subject) {
        if(subjectCodeExists(subject.getSubjectCode())) {
            return false;
        }
        subjects.put(subject.getSubjectCode(), subject);
        return true;
    }

    public boolean subjectCodeExists(int subjectCode){
        return subjects.containsKey(subjectCode);
    }

    public Subject findSubject(int subjectCode) {
        return subjects.get(subjectCode);
    }
}
