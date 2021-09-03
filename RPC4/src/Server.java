import java.io.*;
import java.net.*;

public class Server
{
    public static String isPrime(int num)
    {
        if(num < 2)
        {
            return "No";
        }
        int i = 2;
        while(i < num)
        {
            if(num%i == 0)
            {
                return "No";
            }
            i++;
        }
        return "Yes";
    }
    public static void main(String[] args)
    {
        try{
            ServerSocket ss = new ServerSocket(8080);

            //establishes connection

            Socket s = ss.accept();
            DataInputStream dinst = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            int num = dinst.readInt();

            //call the function and return written value to the client

            dout.writeUTF(isPrime(num));
            dout.flush();
            dout.close();
            ss.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}