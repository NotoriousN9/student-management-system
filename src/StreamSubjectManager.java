import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StreamSubjectManager {
    private final Map<String, List<Subject>> streams = new LinkedHashMap<>();

    public boolean addStream(String streamName) {
        if(streamName.isEmpty()) {
            System.out.println("Invalid. Try again!");
            return false;
        }
        else if (streams.containsKey(streamName)) {
            System.out.println("Stream already exists.");
            return false;
        }

        streams.put(streamName, new ArrayList<>());
        return true;
    }

    public boolean addSubjectToStream(String streamName, Subject subject) {
        List <Subject> subjects = streams.get(streamName);

        if(subjects == null) {
            return false;
        }

        for(Subject existingSubject : subjects){
            if (existingSubject.getSubjectCode() == subject.getSubjectCode()) {
                return false;
            }
        }

        subjects.add(subject);
        return true;
    }

    public List<Subject> getSubjectForStream(String streamName){
        List <Subject> subjects = streams.get(streamName);

        if(streamName.isEmpty()) {
            System.out.println("Invalid. Try again!");
            return List.of();
        }

        return List.copyOf(subjects);
    }

    public boolean removeSubjectFromStream(String streamName, int subjectCode) {
        List <Subject> subjects = streams.get(streamName);

        if(subjects == null) {
            return false;
        }

        for (int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getSubjectCode() == subjectCode) {
                subjects.remove(i);
                return true;
            }
        }

        return false;
    }
}
