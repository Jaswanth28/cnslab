import java.util.Scanner;

public class CaesarCipher
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Message : ");
		String ms=sc.nextLine();
		System.out.print("Enter Shift value(1-26) : ");
		int shift=sc.nextInt()%26;
		StringBuilder EM=new StringBuilder();
		
		for(char c: ms.toCharArray())
		{
			if(c>='a' && c<='z')
			{
				EM.append((char)('a'+(c-'a'+shift)%26));
			}
			else if(c>='A' && c<='Z')
			{
				EM.append((char)('A'+(c-'A'+shift)%26));
			}
			else
			{
				EM.append(c);
			}
		}
		System.out.print("Encrypted Message : "+EM);
		sc.close();
	}
}