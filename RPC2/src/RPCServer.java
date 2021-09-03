import java.util.*;
import java.net.*;
class RPCServer
{
    DatagramSocket ds;
    DatagramPacket dp;
    String str,methodName,result;
    int val1,val2,val3;
    RPCServer()
    {
        try
        {
            ds= new DatagramSocket(1200);
            byte b[]=new byte[4096];
            while(true)
            {
                dp= new DatagramPacket(b,b.length);
                ds.receive(dp);
                str= new String(dp.getData(),0,dp.getLength());
                if(str.equalsIgnoreCase("q"))
                {
                    System.exit(1);
                }
                else
                {
                    StringTokenizer st=new StringTokenizer(str," ");
                    int i=0;
                    while(st.hasMoreTokens())
                    {
                        String token=st.nextToken();
                        methodName=token;
                        val1= Integer.parseInt(st.nextToken());
                        val2= Integer.parseInt(st.nextToken());
                        val3= Integer.parseInt(st.nextToken());
                    }
                }
                System.out.println(str);
                InetAddress ia=InetAddress.getLocalHost();
                if(methodName.equalsIgnoreCase("SI"))
                {
                    result="" + SI(val1,val2,val3);
                }
              
                
                byte bl[]=result.getBytes(); 
                DatagramSocket ds1 = new DatagramSocket(); 
                DatagramPacket dp1 = new DatagramPacket(bl,bl.length,InetAddress.getLocalHost(),1300);
                System.out.println("result : "+result+"\n"); 
                ds1.send(dp1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public int SI(int val1, int val2, int val3)
    {
    return val1*val2*val3/100;
    }
    
    public static void main(String[] args) 
    { 
        new RPCServer();
    }
}