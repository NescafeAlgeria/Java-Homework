import java.util.Objects;

/**
 * The type Student.
 */
class Student extends Person {
    private String regNr;

    /**
     * Instantiates a new Student.
     *
     * @param name      the name
     * @param birthDate the birth date
     * @param regNr     the reg nr
     */
    public Student(String name, String birthDate, String regNr) {
        super(name, birthDate);
        this.regNr = regNr;
    }

    /**
     * Gets reg nr.
     *
     * @return the reg nr
     */
    public String getRegNr() {return regNr;}

    /**
     * Sets reg nr.
     *
     * @param regNr the reg nr
     */
    public void setRegNr(String regNr) {this.regNr = regNr;}

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)) return false;
        Student student = (Student)obj;
        return regNr.equals(student.regNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), regNr);
    }

}
