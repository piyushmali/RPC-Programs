import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client 
{	
	public static void main(String[] args) throws Exception {
		//specify the socket and the scanners
		try (var Socket = new Socket("localhost", 6000)) {
			var scanner = new Scanner(System.in);
			var scanner2 = new Scanner(System.in);
			var in = new Scanner(Socket.getInputStream());
			var out = new PrintWriter(Socket.getOutputStream(), true);
			int menu;
			String number;
			String cmd="";
			int keep=0;
			//menu
			while(true) {
				System.out.println("press 1 for average");
				System.out.println("press 2 for product");
				System.out.println("press 3 for square root");
				System.out.println("press 4 for sum");
				System.out.println("press 5 for factorial");
				System.out.println("press 6 to exit");
				menu=scanner.nextInt();
				//exit menu
				if(menu==15) {
					break;
				}

				//avarage menu
				else if(menu==1) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="avarage,";
						for(int i=0;i<=9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an avarage for ");
						number=scanner2.nextLine();
						cmd="avarage,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				
				//product menu
				else if(menu==2) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="product,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an product for ");
						number=scanner2.nextLine();
						cmd="product,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//square root menu
				else if(menu==3) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="squareroot,";
						cmd=cmd+(int)(Math.random()*10+1);

					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an square root for ");
						number=scanner2.next();
						cmd="squareroot,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
				//sum menu
				else if(menu==4) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random value between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="sum,";
						for(int i=0;i<9;i++) {
							cmd=cmd+(int)(Math.random()*10+1)+" ";
						}
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do a sum for ");
						number=scanner2.nextLine();
						cmd="sum,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
	
				//factorial function
				else if(menu==5) {
					int numbermenu=0;
					System.out.println("if you want to enter the number press 1 else press 0 to get a random number between 1 and 10");
					numbermenu=scanner.nextInt();
					//random numbers
					if(numbermenu==0) {
						cmd="factorial,";
						cmd=cmd+(int)(Math.random()*10+1);
					}
					//numbers from client
					else {
						System.out.println("enter the number you want to do an factorial for ");
						number=scanner.next();
						cmd="factorial,";
						cmd=cmd+number;
					}
					out.println(cmd);
					System.out.println(in.nextLine());	
					System.out.println("if you want to do another task press 1 else press 0");
					keep=scanner.nextInt();
					if(keep==0) {
						break;
					}
				}
                                
				//everything else menu
				else {
					System.out.println("we have no such function");
				}
			}
			System.out.println("thank you");
		}


	}

}