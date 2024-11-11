public class ID {
    // Attribute
    private String id;

    // Constructor
    public ID(String id) {
        this.id = id;
    }

    // Method to check if the ID format is valid
    public boolean isValidIDFormat() {
        // Checks if the ID is valid based on predefined rules
        // Example rules for ID validation (this can be customized)
        if (id == null || id.isEmpty()) {
            return false;
        }

        // Student IDs should start with 'S' and be followed by 7 digits (e.g., S1234567)
        if (id.matches("S\\d{7}")) {
            return true;
        }

        // Lecturer IDs should start with 'L' and be followed by 7 digits (e.g., L1234567)
        if (id.matches("L\\d{7}")) {
            return true;
        }

        // Course IDs should start with 'C' and be followed by 4 digits (e.g., CSE1010)
        if (id.matches("C\\d{4}")) {
            return true;
        }

        return false; // If none of the formats match, the ID is invalid
    }

    // Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
