import java.io.*;
import java.net.*;
public class TCPserver
{
    public static void main(String args[])throws IOException
    {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server ready for connection");
        Socket sock = sersock.accept();
        System.out.println("Connection is successful");
        InputStream istream = sock.getInputStream();
        BufferedReader fileread = new BufferedReader(new InputStreamReader(istream));
        String fname = fileread.readLine();
        BufferedReader contentread = new BufferedReader(new FileReader(fname));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream,true);
        String str;
        while((str = contentread.readLine()) != null)
        {
            pwrite.println(str);
        }
        sock.close();
        sersock.close();
        pwrite.close();
        fileread.close();
    }
}
