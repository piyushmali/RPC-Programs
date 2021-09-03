import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class server {

	public static void main(String[] args) throws IOException {
		//specify the sockets and the multi thread
		try (var listener = new ServerSocket(6000)) { 
			System.out.println("The statistics server is running...");
			var pool = Executors.newFixedThreadPool(20);
			while (true) {
				pool.execute(new StatThread (listener.accept()));

			}
		}
	}
	private static class StatThread implements Runnable { 
		private Socket socket;
		StatThread (Socket socket) 
		{
			this.socket = socket; 
		}
		@Override
		public void run() {
			System.out.println("Connected: " + socket);
			try { 
				var in = new Scanner(socket.getInputStream());
				var out = new PrintWriter(socket.getOutputStream(), true);
				while (in.hasNextLine()) {
					String[] exp = in.nextLine().toString().split(",");
					String command = exp[0];
					String []values = exp[1].split(" ");
					double result=0;
					//avarage function
					if(command.equals("average")) {
						//calculate the avarage by summing all the numbers
						for(int i=0;i<values.length;i++) {
							result=result+Integer.parseInt(values[i]);	
						}
						//then dividing by the number of elements
						result=result/(values.length);
					}
					
					//sum function
					else if(command.equals("sum")) {
						//sum all the elements
						for(int i=0;i<values.length;i++) {
							result= Integer.parseInt(values[i])+result;
						}
					}
					//product function
					else if(command.equals("product")) {
						//go over all the elements and multiply them by each others
						result=Integer.parseInt(values[0]);
						for(int i=1;i<values.length;i++) {
							result=Integer.parseInt(values[i])*result;
						}
					}
					//square root function
					else if(command.equals("squareroot")){
						//if negative take the absolute value and then use square root
						if(Integer.parseInt(values[0])<0) {
							result=-Integer.parseInt(values[0]);
							result=Math.pow(result, 0.5);
						}
						else {
							result=Math.pow(Integer.parseInt(values[0]), 0.5);
						}
					}
				
					//factorial function
					else if(command.equals("factorial")) {
						//result=factorial(Integer.parseInt(values[0]));
						result=1;
						for(int i=1;i<=Integer.parseInt(values[0]);i++) {
							result=result*i;
						}
					}
					//send the answer
					out.println(result);
				}

			}
			catch(Exception e) { 
				System.out.println("Error:" + socket);
			}
			finally {
				try { socket.close(); } catch (IOException e) {}
				System.out.println("Closed: " + socket);
			}
		}

	}
}