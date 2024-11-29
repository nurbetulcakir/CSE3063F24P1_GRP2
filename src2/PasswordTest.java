//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//
//public class PasswordTest {
//
//    @Test
//    public void testSecurePassword() {
//        
//        Password password = new Password("Secure@123");
//
//        assertTrue(password.isSecurePassword(), "Password should be secure");
//    }
//
//    @Test
//    public void testWeakPassword_NoUppercase() {
//        
//        Password password = new Password("weakpassword123@");
//
//        assertFalse(password.isSecurePassword(), "Password should be invalid, missing uppercase letter");
//    }
//
//    @Test
//    public void testWeakPassword_NoDigit() {
//        Password password = new Password("WeakPassword@");
//
//        assertFalse(password.isSecurePassword(), "Password should be invalid, missing digit");
//    }
//
//    @Test
//    public void testWeakPassword_NoSpecialCharacter() {
//        Password password = new Password("WeakPassword123");
//
//        assertFalse(password.isSecurePassword(), "Password should be invalid, missing special character");
//    }
//
//    @Test
//    public void testWeakPassword_TooShort() {
// 
//        Password password = new Password("Weak@1");
//
//        assertFalse(password.isSecurePassword(), "Password should be invalid, too short");
//    }
//
//    @Test
//    public void testPasswordSetter() {
//        Password password = new Password("Valid@123");
//
//        password.setPassword("New@Password123");
//
//        assertTrue(password.isSecurePassword(), "New password should be valid");
//    }
//
//    @Test
//    public void testInvalidPasswordSetter() {
//        Password password = new Password("Valid@123");
//
//        assertThrows(IllegalArgumentException.class, () -> password.setPassword("short"));
//    }
//}
