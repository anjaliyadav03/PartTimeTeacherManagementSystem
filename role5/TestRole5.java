import java.util.List;

public class TestRole5 {

    public static void main(String[] args) {

        // Create repository object for file operations
        FileRepository repository = new FileRepository();

        // Load existing data from file
        DataStore dataStore = repository.loadData("role5/data.txt");

        // Create training service using loaded training session list
        TrainingService trainingService = new TrainingService(dataStore.getTrainingSessions());

        // Display training sessions loaded from file
        System.out.println("=== Training Sessions Loaded From File ===");
        List<TrainingSession> sessions = trainingService.listTrainingSessions();
        for (TrainingSession session : sessions) {
            System.out.println(session);
        }

        // Add a new training session
        trainingService.scheduleTraining("TR3", "T3", "Charlie", "CS301", "Databases", "2026-03-25");

        System.out.println();
        System.out.println("=== After Adding New Training Session ===");
        for (TrainingSession session : trainingService.listTrainingSessions()) {
            System.out.println(session);
        }

        // Update the status of the newly added training session
        boolean updated = trainingService.updateTrainingStatus("TR3", "COMPLETED");

        System.out.println();
        if (updated) {
            System.out.println("Training status updated successfully.");
        } else {
            System.out.println("Training session not found.");
        }

        // Display training sessions after status update
        System.out.println();
        System.out.println("=== After Status Update ===");
        for (TrainingSession session : trainingService.listTrainingSessions()) {
            System.out.println(session);
        }

        // Save updated data back into file
        repository.saveData("role5/data.txt", dataStore);

        System.out.println();
        System.out.println("Data saved successfully.");
    }
}