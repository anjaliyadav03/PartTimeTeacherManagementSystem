import java.util.ArrayList;
import java.util.List;

public class DataStore {

    // These lists are placeholders for integration with other team modules
    private List<Object> teachers;
    private List<Object> requirements;

    // This list stores all training sessions for Role 5
    private List<TrainingSession> trainingSessions;

    // Constructor initializes empty lists
    public DataStore() {
        teachers = new ArrayList<Object>();
        requirements = new ArrayList<Object>();
        trainingSessions = new ArrayList<TrainingSession>();
    }

    public List<Object> getTeachers() {
        return teachers;
    }

    public List<Object> getRequirements() {
        return requirements;
    }

    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }
}