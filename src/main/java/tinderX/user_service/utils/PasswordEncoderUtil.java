package tinderX.user_service.utils;


import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoderUtil {
    public static String encodePassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainPassword, String encodedPassword){
        return BCrypt.checkpw(plainPassword, encodedPassword);
    }
}