import java.util.ArrayList;
import java.util.List;

///  Mitila Alin

enum ProjectType{
    THEORETICAL,
    PRACTICAL
}

class Project{
    private String name;
    private ProjectType type;

    public Project(String name, ProjectType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Project " + name + " of type " + type;
    }
}

class Student {
    String name;
    private List<Project> DesiredProjects;
    private Project AssignedProject;

    public Student(String name) {
        this.name = name;
    }

    public Project getAssignedProject() {
        return AssignedProject;
    }

    public String getName() {
        return name;
    }

    public List<Project> getDesiredProjects() {
        return DesiredProjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesiredProjects(List<Project> desiredProjects) {
        DesiredProjects = desiredProjects;
    }

    public void setAssignedProject(Project assignedProject) {
        AssignedProject = assignedProject;
    }

    @Override
    public String toString() {
        return "Student " + name + " wants " + getDesiredProjects() + " assigned to " + getAssignedProject();
    }
}


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
