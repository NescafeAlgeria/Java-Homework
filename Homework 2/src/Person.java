import java.util.*;

/**
 * The type Person.
 */
abstract class Person {

    /**
     * The Name.
     */
    protected String name;
    /**
     * The Birthday.
     */
    protected String birthday;

    /**
     * Instantiates a new Person.
     *
     * @param name     the name
     * @param birthday the birthday
     */
    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person)obj;
        return name.equals(person.name) && birthday.equals(person.birthday);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }


}
