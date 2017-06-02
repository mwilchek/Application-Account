package Core; /**
 * Create Core.User Assignment; Core.Person Class
 * Attributes include: first name, last name, SSN, dob, gender
 */

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Person implements Serializable{
    private String firstName;
    private String lastName;
    private int ssn;
    private Date dob;
    private String gender;

    /**
     * Set Core.Person Class with null values
     */
    public Person() {

    }

    /**
     * Set Core.Person Class with Specific Attributes
     */
    public Person(String firstName, String lastName, int ssn, Date dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dob = dob;
        this.gender = gender;
    }

    /**
     * Return First Name
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return Last Name
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return SSN
     */
    public int getSSN() {
        return ssn;
    }

    public void setSSN(int ssn) {
        this.ssn = ssn;
    }

    /**
     * Return Core.Person Gender
     */
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Set DOB of person as Calendar type object
     */
    public void setDOB(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        this.dob = cal.getTime();
    }

    /**
     * Return DOB
     */
    public Date getDOB() {
        return dob;
    }

    @Override
    public String toString() {
        return "Core.Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}

