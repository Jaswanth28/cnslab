import java.util.Scanner;

public class SubstitutionCipher
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message to Encrypt : ");
        String ms = sc.nextLine();
        System.out.print("Enter the cipher key (26 letters): ");
        String key = sc.nextLine();
        String encoded = encode(ms, key);
        System.out.println("Encrypted Message: " + encoded);
        sc.close();
    }
    
    public static String encode(String ms, String key)
    {
        ms = ms.toLowerCase();
        key = key.toLowerCase();
        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < ms.length(); i++)
        {
            char c = ms.charAt(i);
            if (c >= 'a' && c <= 'z')
            {
                int j = c - 'a';
                char e = key.charAt(j);
                encoded.append(e);
            }
            else
            {
                encoded.append(c);
            }
        }
        return encoded.toString();
    }
}

/*
 	Enter message to Encrypt : HELLO WORLD
	Enter the cipher key (26 letters): qwertyuiopasdfghjklzxcvbnm
	Encrypted Message: itssg vgksr
*/