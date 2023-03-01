import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class RSAEncryption
{
	public static void main(String[] args) throws NoSuchAlgorithmException,NoSuchPaddingException,InvalidKeyException,IllegalBlockSizeException,BadPaddingException	
	{
		KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
		SecureRandom secureRandom=new SecureRandom();
		keyPairGenerator.initialize(2048,secureRandom);
		KeyPair pair=keyPairGenerator.generateKeyPair();
		PublicKey publicKey=pair.getPublic();
		
		String publicKeyString=Base64.getEncoder().encodeToString(publicKey.getEncoded());
		// System.out.print("Public Key "+publicKeyString);
		PrivateKey privateKey=pair.getPrivate();
		
		String privateKeyString=Base64.getEncoder().encodeToString(privateKey.getEncoded());
		// System.out.println("\nPrivate Key : "+privateKeyString);
		
		//Encrypt User Message
		Cipher encryptionCipher=Cipher.getInstance("RSA");
		encryptionCipher.init(Cipher.ENCRYPT_MODE,privateKey);
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter Plain Text Message : ");
		String message=sc.nextLine();
		byte[] encryptedMessage=encryptionCipher.doFinal(message.getBytes());
		String encryption=Base64.getEncoder().encodeToString(encryptedMessage);
		System.out.print("\nEncrypted Message : "+encryption);
		
		//Decrypt User Message
		Cipher decryptionCipher=Cipher.getInstance("RSA");
		decryptionCipher.init(Cipher.DECRYPT_MODE,publicKey);
		byte[] decryptedMessage=decryptionCipher.doFinal(encryptedMessage);
		String decryption=new String(decryptedMessage);
		System.out.print("\n\nDecrypted Message : "+decryption);
		sc.close();
	}
}
