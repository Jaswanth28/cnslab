import java.util.*;
import java.math.*;

public class DiffieHellman
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value for G:");
        BigInteger G = sc.nextBigInteger();
        System.out.print("Enter a value for P:");
        BigInteger P = sc.nextBigInteger();

        System.out.print("User1 chooses a private key:");
        BigInteger a = sc.nextBigInteger();
        System.out.print("User2 chooses a private key:");
        BigInteger b = sc.nextBigInteger();

        BigInteger A = G.modPow(a, P);
        BigInteger B = G.modPow(b, P);

        BigInteger s1 = B.modPow(a, P);
        BigInteger s2 = A.modPow(b, P);

        if(s1.equals(s2))
        {
            System.out.println("Private keys match. Key exchange successful.");
            System.out.println("Final shared secret key: " + s1);
        }
        else
        {
            System.out.println("Private keys do not match. Key exchange failed.");
        }
        sc.close();
    }
}

