import java.util.*;

/**
 * The type Solution.
 */
public class Solution {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Problem problem = new Problem(5, 3, 5);

        Teacher teacher1 = new Teacher("Dr. Smith", "1975-5-20", 3);
        Teacher teacher2 = new Teacher("Prof. Johnson", "1980-4-21", 3);

        Project project1 = new Project("AI Research", teacher1);
        Project project2 = new Project("Blockchain", teacher1);
        Project project3 = new Project("Cybersecurity", teacher2);

        teacher1.propose(project1);
        teacher1.propose(project2);
        teacher2.propose(project3);

        Student student1 = new Student("Alice", "2001-7-10", "S123");
        Student student2 = new Student("Bob", "2000-11-5", "S124");

        problem.addTeacher(teacher1);
        problem.addTeacher(teacher2);
        problem.addProject(project1);
        problem.addProject(project2);
        problem.addProject(project3);
        problem.addStudent(student1);
        problem.addStudent(student2);

        Map<Student, Project> allocation = problem.allocateProjects();
        for (Map.Entry<Student, Project> entry : allocation.entrySet()) {
            System.out.println(entry.getKey().getName() + " is assigned to " + entry.getValue().getTitle());
        }
        System.out.println("Persons involved in Problem: ");
        for(Person p : problem.getAllPersons()){
            System.out.println(p.getName());
        }
    }
}
