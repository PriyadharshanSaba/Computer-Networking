import java.net.*;
import java.io.*;
public class UDPserver
{
    public static void main(String args[])
    {
        DatagramSocket skt = null;
        try
        {
            skt = new DatagramSocket(6788);
            byte buffer[]=new byte[1000];
            while(true)
            {
                DatagramPacket request = new DatagramPacket(buffer,buffer.length);
                skt.receive(request);
                String message[] = (new String(request.getData())).split("");
                byte sending[]=(message[0]+"network laboratory").getBytes();
                DatagramPacket reply = new DatagramPacket(sending,sending.length,request.getAddress(),request.getPort());
                skt.send(reply);
            }
        }
        catch(Exception e)
        {
        }
    }
}
