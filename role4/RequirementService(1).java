import java.util.ArrayList;
import java.util.List;

public class RequirementService {

    private List<TeachingRequirement> requirementsList;

    public RequirementService() {
        this.requirementsList = new ArrayList<>();
    }

    public void loadData(List<TeachingRequirement> savedData) {
        if (savedData != null) {
            this.requirementsList = savedData;
        }
    }

    public List<TeachingRequirement> extractData() {
        return this.requirementsList;
    }

    // Record a new teaching requirement into the system
    public void recordRequirement(String module, String skill, String term, int hours) {
        TeachingRequirement req = new TeachingRequirement(module, skill, term, hours);
        this.requirementsList.add(req);
    }

    // Retrieve all requirements that have not been assigned a teacher yet
    public List<TeachingRequirement> getOpenRequirements() {
        List<TeachingRequirement> openList = new ArrayList<>();

        for (TeachingRequirement req : this.requirementsList) {
            if (!req.isAssigned()) {
                openList.add(req);
            }
        }
        return openList;
    }

    // Update the requirement status when a teacher is successfully matched
    public boolean assignTeacherToRequirement(String targetId) {
        for (TeachingRequirement req : this.requirementsList) {
            if (req.getReqId().equals(targetId)) {
                req.markAsAssigned();
                return true;
            }
        }
        return false;
    }
}