import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileRepository {

    // Load data from file into memory
    public DataStore loadData(String fileName) {
        DataStore dataStore = new DataStore();
        File file = new File(fileName);

        // If file does not exist, return empty data store
        if (!file.exists()) {
            return dataStore;
        }

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            String section = "";

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Skip empty lines
                if (line.length() == 0) {
                    continue;
                }

                // Detect section headers
                if (line.equals("[TEACHERS]")) {
                    section = "TEACHERS";
                    continue;
                } else if (line.equals("[REQUIREMENTS]")) {
                    section = "REQUIREMENTS";
                    continue;
                } else if (line.equals("[TRAINING]")) {
                    section = "TRAINING";
                    continue;
                }

                String[] parts = line.split("\\|");

                // Load only training records for Role 5
                if (section.equals("TRAINING")) {
                    if (parts.length >= 7) {
                        TrainingSession session = new TrainingSession(
                                parts[0],
                                parts[1],
                                parts[2],
                                parts[3],
                                parts[4],
                                parts[5],
                                parts[6]
                        );
                        dataStore.getTrainingSessions().add(session);
                    }
                }

                // Teacher and requirement loading can be added later
            }

        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }

        return dataStore;
    }

    // Save data from memory into file
    public void saveData(String fileName, DataStore dataStore) {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(fileName));

            writer.println("[TEACHERS]");
            // Future integration point for teacher data

            writer.println();
            writer.println("[REQUIREMENTS]");
            // Future integration point for requirement data

            writer.println();
            writer.println("[TRAINING]");
            for (TrainingSession session : dataStore.getTrainingSessions()) {
                writer.println(session.toFileString());
            }

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}