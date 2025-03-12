import java.util.Objects;

/**
 * The type Project.
 */
public class Project {
    private String title;
    private Teacher proposer;

    /**
     * Instantiates a new Project.
     *
     * @param title    the title
     * @param proposer the proposer
     */
    public Project(String title, Teacher proposer) {
        this.title = title;
        this.proposer = proposer;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() { return title; }

    /**
     * Gets proposer.
     *
     * @return the proposer
     */
    public Teacher getProposer() { return proposer; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Project p = (Project) obj;
        return title.equals(p.title) && proposer.equals(p.proposer);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, proposer);
    }
}
