import java.util.Map;
import java.util.HashMap;

/**
 * The type Problem.
 */
public class Problem {
    private Student[] students;
    private Teacher[] teachers;
    private Project[] projects;
    private int studentCount = 0;
    private int teacherCount = 0;
    private int projectCount = 0;

    /**
     * Instantiates a new Problem.
     *
     * @param maxStudents the max students
     * @param maxTeachers the max teachers
     * @param maxProjects the max projects
     */
    public Problem(int maxStudents, int maxTeachers, int maxProjects) {
        students = new Student[maxStudents];
        teachers = new Teacher[maxTeachers];
        projects = new Project[maxProjects];
    }

    /**
     * Add student.
     *
     * @param student the student
     */
    public void addStudent(Student student) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].equals(student)) return;
        }
        if (studentCount < students.length) {
            students[studentCount++] = student;
        }
    }

    /**
     * Add teacher.
     *
     * @param teacher the teacher
     */
    public void addTeacher(Teacher teacher) {
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].equals(teacher)) return;
        }
        if (teacherCount < teachers.length) {
            teachers[teacherCount++] = teacher;
        }
    }

    /**
     * Add project.
     *
     * @param project the project
     */
    public void addProject(Project project) {
        for (int i = 0; i < projectCount; i++) {
            if (projects[i].equals(project)) return;
        }
        if (projectCount < projects.length) {
            projects[projectCount++] = project;
        }
    }

    /**
     * Get all persons person [ ].
     *
     * @return the person [ ]
     */
    public Person[] getAllPersons() {
        Person[] allPersons = new Person[studentCount + teacherCount];
        System.arraycopy(students, 0, allPersons, 0, studentCount);
        System.arraycopy(teachers, 0, allPersons, studentCount, teacherCount);
        return allPersons;
    }

    /**
     * Allocate projects map.
     *
     * @return the map
     */
    public Map<Student, Project> allocateProjects() {
        Map<Student, Project> allocation = new HashMap<>();
        int projectIndex = 0;

        for (int i = 0; i < studentCount; i++) {
            if (projectIndex < projectCount) {
                allocation.put(students[i], projects[projectIndex++]);
            } else {
                break;
            }
        }
        return allocation;
    }

}
