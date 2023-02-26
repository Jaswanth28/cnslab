import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DES
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter plaintext: ");
        String plainText = br.readLine();
        System.out.print("Enter key: ");
        String keyText = br.readLine();
        byte[] key = keyText.getBytes(StandardCharsets.UTF_8);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        DESKeySpec keySpec = new DESKeySpec(key);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance("DES");
        
        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);
        String encodedCipherText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted text: " + encodedCipherText);        
     
        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedCipherText = Base64.getDecoder().decode(encodedCipherText);
        byte[] decryptedBytes = cipher.doFinal(decodedCipherText);
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        System.out.println("Decrypted text: " + decryptedText);
    }
}
