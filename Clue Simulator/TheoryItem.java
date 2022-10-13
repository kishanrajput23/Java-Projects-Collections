/**
 * TheoryItem.java : Convenient class helps to keep track of different kinds of
 * murders, locations, and weapons. Constants can be used as limits (1 -
 * constant value), static methods mostly used for error checking or translating
 * between Strings and integers
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

public final class TheoryItem {

    public static final int TOTAL_MURDERS = 6;
    public static final int TOTAL_LOCATIONS = 10;
    public static final int TOTAL_WEAPONS = 6;

    /**
     * Converts location integer to String: Kitchen (1), Ballroom (2),
     * Conservatory (3), Billiard (4), Library (5), Study (6), Hall (7), Lounge
     * (8), Dining (9), Cellar (10).
     *
     * @param location
     *            integer to convert to String
     * @return String version of location number, null if invalid integer
     */
    public static String getLocationName(int location) {
        String locationName = null;

        switch (location) {
            case 1:
                locationName = "Kitchen";
                break;
            case 2:
                locationName = "Ballroom";
                break;
            case 3:
                locationName = "Conservatory";
                break;
            case 4:
                locationName = "Billiard";
                break;
            case 5:
                locationName = "Library";
                break;
            case 6:
                locationName = "Study";
                break;
            case 7:
                locationName = "Hall";
                break;
            case 8:
                locationName = "Lounge";
                break;
            case 9:
                locationName = "Dining";
                break;
            case 10:
                locationName = "Cellar";
                break;
        }
        return locationName;
    }

    /**
     * Converts location String to integer: Kitchen (1), Ballroom (2),
     * Conservatory (3), Billiard (4), Library (5), Study (6), Hall (7), Lounge
     * (8), Dining (9), Cellar (10).
     *
     * @param location
     *            String to convert to integer
     * @return integer version of location String, 0 if invalid String
     */
    public static int getLocationNumber(String location) {
        int locationNumber = 0;

        switch (location.toLowerCase()) {
            case "kitchen":
                locationNumber = 1;
                break;
            case "ballroom":
                locationNumber = 2;
                break;
            case "conservatory":
                locationNumber = 3;
                break;
            case "billiard":
                locationNumber = 4;
                break;
            case "library":
                locationNumber = 5;
                break;
            case "study":
                locationNumber = 6;
                break;
            case "hall":
                locationNumber = 7;
                break;
            case "lounge":
                locationNumber = 8;
                break;
            case "dining":
                locationNumber = 9;
                break;
            case "cellar":
                locationNumber = 10;
                break;
        }
        return locationNumber;
    }

    /**
     * Checks validity of location number
     *
     * @param location
     *            integer representing location
     * @return true if valid (1-10), false otherwise
     */
    public static boolean validateLocationNumber(int location) {
        return (location >= 1 && location <= 10);
    }

    /**
     * Converts person integer to String: Ms. Scarlet (1), Colonial Mustard (2),
     * Mrs. White (3), Reverend Green (4), Mrs. Peacock (5), Professor Plum (6)
     *
     * @param person
     *            integer to convert to String
     * @return String version of person number, null if invalid integer
     */
    public static String getPersonName(int person) {
        String personString = null;

        switch (person) {
            case 1:
                personString = "Ms. Scarlet";
                break;
            case 2:
                personString = "Colonial Mustard";
                break;
            case 3:
                personString = "Mrs. White";
                break;
            case 4:
                personString = "Reverend Green";
                break;
            case 5:
                personString = "Mrs. Peacock";
                break;
            case 6:
                personString = "Professor Plum";
                break;
        }
        return personString;
    }

    /**
     * Converts person String to integer: Ms. Scarlet (1), Colonial Mustard (2),
     * Mrs. White (3), Reverend Green (4), Mrs. Peacock (5), Professor Plum (6)
     *
     * @param person
     *            String to convert to integer
     * @return integer version of person String, 0 if invalid String
     *
     */
    public static int getPersonNumber(String person) {
        int personNumber = 0;

        switch (person.toLowerCase()) {
            case "ms. scarlet":
                personNumber = 1;
                break;
            case "colonial mustard":
                personNumber = 2;
                break;
            case "mrs. white":
                personNumber = 3;
                break;
            case "reverend green":
                personNumber = 4;
                break;
            case "mrs. peacock":
                personNumber = 5;
                break;
            case "professor plum":
                personNumber = 6;
                break;
        }
        return personNumber;
    }

    /**
     * Checks validity of person number
     *
     * @param person
     *            integer representing person
     * @return true if valid (1-6), false otherwise
     */
    public static boolean validatePersonNumber(int person) {
        return (person >= 1 && person <= 6);
    }

    /**
     * Converts weapon integer to String: rope (1), wrench (2), candlestick (3),
     * revolver (4), knife (5), pipe (6)
     *
     * @param weapon
     *            integer to convert to String
     * @return String version of weapon number, null if invalid integer
     */
    public static String getWeaponName(int weapon) {
        String weaponString = null;

        switch (weapon) {
            case 1:
                weaponString = "rope";
                break;
            case 2:
                weaponString = "wrench";
                break;
            case 3:
                weaponString = "candlestick";
                break;
            case 4:
                weaponString = "revolver";
                break;
            case 5:
                weaponString = "knife";
                break;
            case 6:
                weaponString = "pipe";
                break;

        }
        return weaponString;
    }

    /**
     * Converts weapon String to integer: rope (1), wrench (2), candlestick (3),
     * revolver (4), knife (5), pipe (6)
     *
     * @param weapon
     *            String to convert to integer
     * @return integer version of weapon number, 0 if invalid String
     *
     */
    public static int getWeaponNumber(String weapon) {
        int weaponNumber = 0;

        switch (weapon.toLowerCase()) {
            case "rope":
                weaponNumber = 1;
                break;
            case "wrench":
                weaponNumber = 2;
                break;
            case "candlestick":
                weaponNumber = 3;
                break;
            case "revolver":
                weaponNumber = 4;
                break;
            case "knife":
                weaponNumber = 5;
                break;
            case "pipe":
                weaponNumber = 6;
                break;
        }
        return weaponNumber;
    }

    /**
     * Checks validity of weapon number
     *
     * @param weapon
     *            integer representing weapon
     * @return true if valid (1-6), false otherwise
     */
    public static boolean validateWeaponNumber(int weapon) {
        return (weapon >= 1 && weapon <= 6);
    }
}
