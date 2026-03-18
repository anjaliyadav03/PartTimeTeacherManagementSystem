public class TrainingSession {

    // Unique ID for the training session
    private String trainingId;

    // Teacher details
    private String teacherId;
    private String teacherName;

    // Training details
    private String moduleName;
    private String skill;
    private String trainingDate;
    private String status;

    // Constructor to create a training session
    public TrainingSession(String trainingId, String teacherId, String teacherName,
                           String moduleName, String skill, String trainingDate, String status) {
        this.trainingId = trainingId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.moduleName = moduleName;
        this.skill = skill;
        this.trainingDate = trainingDate;
        this.status = status;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getSkill() {
        return skill;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public String getStatus() {
        return status;
    }

    // Update training status
    public void setStatus(String status) {
        this.status = status;
    }

    // Convert object into text format for saving into file
    public String toFileString() {
        return trainingId + "|" + teacherId + "|" + teacherName + "|" +
               moduleName + "|" + skill + "|" + trainingDate + "|" + status;
    }

    // Display training session details in readable format
    @Override
    public String toString() {
        return "Training ID: " + trainingId +
               ", Teacher ID: " + teacherId +
               ", Teacher Name: " + teacherName +
               ", Module: " + moduleName +
               ", Skill: " + skill +
               ", Date: " + trainingDate +
               ", Status: " + status;
    }
}