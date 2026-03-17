import java.io.PrintStream;

public class Teacher {
    private String name;
    private String skill;
    private boolean available;
    
    public Teacher(String name, String skill){
        this.name = name;
        this.skill = skill;
        this.available = true;
    }
    public void print(PrintStream ps) {
        ps.printf("name: %-10s | skill: %-10s | status: %s%n", 
            name, skill, (available ? "available" : "unavailable"));
    }


    //getters
    public String getName() { return this.name; }
    public String getSkill() { return this.skill; }
    public boolean getAvailable() { return this.available; }

    //set available to True/False
    public void setAvailable(boolean ava) {this.available = ava;}

}
