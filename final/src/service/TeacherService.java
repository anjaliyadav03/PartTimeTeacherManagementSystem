import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private List<Teacher> teacherList = new ArrayList<>();


    public void addTeacher(Teacher t) {
        if (t != null) {
            teacherList.add(t);
        }
    }

    public boolean removeTeacher(String name) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().equals(name)) {
                teacherList.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Teacher> findTeacherBySkill(String skill) {
        List<Teacher> result = new ArrayList<>();
        for (Teacher t : teacherList) {
            if (t.getSkill().equals(skill) && t.getAvailable()) {
                result.add(t);
            }
        }
        return result;
    }

    public void listTeachers(PrintStream ps) {
        if (teacherList.isEmpty()) {
            ps.println("Current teacher list is empty");
            return;
        }
        ps.println("===== Teacher Information List =====");
        for (Teacher t : teacherList) {
            t.print(ps); 
        }
    }
    
}
