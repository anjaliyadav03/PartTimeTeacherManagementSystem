import java.util.ArrayList;
import java.util.List;

public class TrainingService {

    // List that stores all training sessions
    private List<TrainingSession> trainingSessions;

    // Constructor
    public TrainingService(List<TrainingSession> trainingSessions) {
        this.trainingSessions = trainingSessions;
    }

    // Schedule a new training session for a teacher
    public void scheduleTraining(String trainingId, String teacherId, String teacherName,
                                 String moduleName, String skill, String trainingDate) {
        TrainingSession session = new TrainingSession(
                trainingId,
                teacherId,
                teacherName,
                moduleName,
                skill,
                trainingDate,
                "PLANNED"
        );
        trainingSessions.add(session);
    }

    // Return all training sessions
    public List<TrainingSession> listTrainingSessions() {
        return trainingSessions;
    }

    // Find all training sessions for a specific teacher
    public List<TrainingSession> findTrainingByTeacherId(String teacherId) {
        List<TrainingSession> result = new ArrayList<TrainingSession>();

        for (TrainingSession session : trainingSessions) {
            if (session.getTeacherId().equalsIgnoreCase(teacherId)) {
                result.add(session);
            }
        }

        return result;
    }

    // Update the status of a training session
    public boolean updateTrainingStatus(String trainingId, String newStatus) {
        for (TrainingSession session : trainingSessions) {
            if (session.getTrainingId().equalsIgnoreCase(trainingId)) {
                session.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }
}