import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        try {

            //create a server socket as well as data input and output streams

            Socket s = new Socket("localhost",8080);
            DataInputStream dinst = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            //accepting client/user input

            System.out.print("\nEnter a Number : ");
            int num = scan.nextInt();

            //writing the input to the server for analysis

            dout.writeInt(num);
            String ans = (String) dinst.readUTF();
            System.out.println("\nNumber " + num + " Is Prime Number: " + ans);
            dout.flush();
            dout.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        scan.close();
    }
}