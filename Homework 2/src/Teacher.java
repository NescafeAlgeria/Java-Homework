/**
 * The type Teacher.
 */
class Teacher extends Person {
    private Project[] projects;
    private int projectsCount = 0;

    /**
     * Instantiates a new Teacher.
     *
     * @param name        the name
     * @param birthDate   the birth date
     * @param maxProjects the max projects
     */
    public Teacher(String name, String birthDate, int maxProjects) {
        super(name, birthDate);
        this.projects = new Project[maxProjects];
    }

    /**
     * Propose.
     *
     * @param p the p
     */
    public void propose(Project p) {
        for (int i = 0; i < projectsCount; i++) {
            if (p.equals(projects[i])) return;
        }
        if(projectsCount < projects.length) {
            projects[projectsCount++] = p;
        }
    }

    /**
     * Get projects project [ ].
     *
     * @return the project [ ]
     */
    public Project[] getProjects() {
        return projects;
    }
}
