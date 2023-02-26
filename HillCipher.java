import java.util.Scanner;

public class HillCipher
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the 2x2 key matrix : ");
        int[][] key = new int[2][2];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                key[i][j] = sc.nextInt();
            }
        }
        sc.nextLine();
        System.out.print("Enter the message to encrypt : ");
        String message = sc.nextLine();
        message = message.toUpperCase();
        message = message.replaceAll("[^A-Z]", "");
        int numBlocks = message.length() / 2;
        int[][] blocks = new int[numBlocks][2];
        for (int i = 0; i < numBlocks; i++)
        {
            char c1 = message.charAt(i * 2);
            char c2 = message.charAt(i * 2 + 1);
            blocks[i][0] = c1 - 'A';
            blocks[i][1] = c2 - 'A';
        }
        int[][] encryptedBlocks = new int[numBlocks][2];
        for (int i = 0; i < numBlocks; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                for (int k = 0; k < 2; k++)
                {
                    encryptedBlocks[i][j] += key[j][k] * blocks[i][k];
                }
                encryptedBlocks[i][j] %= 26;
            }
        }
        String encryptedMessage = "";
        for (int i = 0; i < numBlocks; i++)
        {
            encryptedMessage += (char) (encryptedBlocks[i][0] + 'A');
            encryptedMessage += (char) (encryptedBlocks[i][1] + 'A');
        }
        System.out.println("Encrypted message :  " + encryptedMessage);
        sc.close();
    }
}

/*
	Enter the 2x2 key matrix : 3 3 2 5
	Enter the message to encrypt : TEXT
	Encrypted message : RGWL
*/