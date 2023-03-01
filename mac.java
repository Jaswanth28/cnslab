import java.security.*;
import javax.crypto.*;
import java.util.*;
public class mac {
    public static void main(String args[]) throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecureRandom secRandom = new SecureRandom();
        keyGen.init(secRandom);
        Key key = keyGen.generateKey();	 
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        String msg;
        System.out.println("enter msg");
        Scanner sc=new Scanner(System.in);
        msg=sc.nextLine();
        byte[] bytes = msg.getBytes();      
        byte[] macResult = mac.doFinal(bytes);
        System.out.println("Mac result:");
        System.out.println(new String(macResult));     
        sc.close();
     }
}
