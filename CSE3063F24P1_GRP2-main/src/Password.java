public class Password {
    // Attribute
    private String password;

    // Constructor
    public Password(String password) {
        this.password = password;
    }

    // Checks if the password is secure
    public boolean isSecurePassword() {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check password length (minimum 8 characters)
        if (password.length() < 8) {
            return false;
        }

        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check for at least one special character
        if (!password.matches(".*[@#$%^&+=!].*")) {
            return false;
        }

        return true; // If all conditions are met (no letter condition required)
    }

    // Getter and Setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
