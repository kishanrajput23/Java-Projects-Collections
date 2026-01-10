/**
 * Theory.java : stores values for weapon, location, and person
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

public class Theory {
    private int weapon;
    private int location;
    private int person;

    /**
     * Full constructor, specifying each part of theory
     *
     * @param weapon
     *            integer representing weapon
     * @param location
     *            integer representing location
     * @param person
     *            integer representing person
     *
     * @see TheoryItem for values
     */
    public Theory(int weapon, int location, int person) {
        this.weapon = weapon;
        this.location = location;
        this.person = person;
    }

    /**
     * Copy constructor, deep copies Theory object
     *
     * @param other
     *            used to get all theory parts and deep copy
     */
    public Theory(Theory other) {
        this.weapon = other.weapon;
        this.location = other.location;
        this.person = other.person;
    }

    /**
     * Accessor for weapon value
     *
     * @return weapon integer value
     */
    public int getWeapon() {
        return weapon;
    }

    /**
     * Mutator for weapon value
     *
     * @param weapon
     *            integer value representing weapon
     */
    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    /**
     * Accessor for location value
     *
     * @return location integer value
     */
    public int getLocation() {
        return location;
    }

    /**
     * Mutator for location value
     *
     * @param location
     *            integer value representing location
     */
    public void setLocation(int location) {
        this.location = location;
    }

    /**
     * Accessor for person value
     *
     * @return person integer value
     */
    public int getPerson() {
        return person;
    }

    /**
     * Mutator for person value
     *
     * @param person
     *            integer value representing person
     */
    public void setPerson(int person) {
        this.person = person;
    }

    /**
     * Equals method checks ALL instance variables are equal
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Theory other = (Theory) obj;

        return (this.weapon != other.weapon || this.person != other.person || this.location != other.location);

    }

    /**
     * toString representing objects values
     *
     * @return formatted string of weapon, person, and location
     */
    @Override
    public String toString() {
        return String.format("Theory is: Weapon = %s (%d), Person = %s (%d), Location = %s (%d)",
                TheoryItem.getWeaponName(this.weapon), this.weapon, TheoryItem.getPersonName(this.person), this.person,
                TheoryItem.getLocationName(this.location), this.location);
    }

}