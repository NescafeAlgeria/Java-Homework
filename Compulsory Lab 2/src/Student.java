import java.util.List;

class Student {
    private String name;
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
