import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClassSubjectManager {
    private final Map<Integer, List<Subject>> classSubjects = new LinkedHashMap<>();

    public Map<Integer, List<Subject>> getClassSubjects(){
        return Map.copyOf(classSubjects);
    }

    public List<Subject> getSubjectsForClass(int classNumber) {
        List<Subject> subjects = classSubjects.get(classNumber);

        if (subjects == null) {
            return List.of();
        }

        return List.copyOf(subjects);
    }

    public boolean addSubjectToClass(int classNumber, Subject subject) {
        List<Subject> subjects = classSubjects.get(classNumber);

        if(subjects == null) {
            subjects = new ArrayList<>();
            classSubjects.put(classNumber, subjects);
        }

        if(subjects.size() >= 6) {
            return false;
        }

        for(Subject existingSubject : subjects) {
            if(existingSubject.getSubjectCode() == subject.getSubjectCode()) {
                return false;
            }
        }

        subjects.add(subject);
        return true;
    }

    public boolean removeSubjectFromClass(int classNumber, int subjectCode) {
        List<Subject> subjects = classSubjects.get(classNumber);

        if(subjects == null) {
            return false;
        }

        for(int i = 0; i < subjects.size(); i++){
            if(subjects.get(i).getSubjectCode() == subjectCode) {
                subjects.remove(i);
                return true;
            }
        }

        return false;
    }
}
