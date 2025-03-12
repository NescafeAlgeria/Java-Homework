import java.util.ArrayList;
import java.util.List;

///  Mitila Alin

public class Main {

    public static void main(String[] args) {
        Project Project1 = new Project("Project1", ProjectType.PRACTICAL);
        Student Student1 = new Student("Bill Gates");

        List<Project> DesiredProjects = new ArrayList<Project>();
        DesiredProjects.add(Project1);

        Student1.setAssignedProject(Project1);
        Student1.setDesiredProjects(DesiredProjects);

        System.out.println(Student1);
        System.out.println(Project1);


    }
}