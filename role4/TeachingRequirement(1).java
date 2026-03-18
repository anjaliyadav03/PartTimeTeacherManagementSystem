import java.io.Serializable;
import java.util.UUID;

public class TeachingRequirement implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reqId;
    private String module;
    private String skill;
    private String term;
    private int hours;
    private boolean isAssigned;

    public TeachingRequirement(String module, String skill, String term, int hours) {
        // Generate a short ID for easy testing
        this.reqId = UUID.randomUUID().toString().substring(0, 8);
        this.module = module;
        this.skill = skill;
        this.term = term;
        this.hours = hours;
        this.isAssigned = false;
    }

    public String getReqId() { return reqId; }
    public String getModule() { return module; }
    public String getSkill() { return skill; }
    public String getTerm() { return term; }
    public int getHours() { return hours; }
    public boolean isAssigned() { return isAssigned; }

    // State transition method to maintain high cohesion
    public void markAsAssigned() {
        this.isAssigned = true;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Module: %s | Skill: %s | Term: %s | Hours: %d | Status: %s",
                reqId, module, skill, term, hours, (isAssigned ? "Assigned" : "Open"));
    }
}