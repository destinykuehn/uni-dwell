package BCrypt_Hasher;

import org.mindrot.jbcrypt.BCrypt;

public class Hasher {
    private static int log_rounds = 10;
    public static String hash(String plain) {
        String salt = BCrypt.gensalt(log_rounds);
        return BCrypt.hashpw(plain, salt);
    }

    public static boolean verify_hash(String plain, String hash) {
        return BCrypt.checkpw(plain, hash);
    }
}