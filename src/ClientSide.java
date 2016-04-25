/**
 * Created by lad on 25.04.2016.
 */
import java.net.*;
import java.io.*;
public class ClientSide{
    public static void main ( String [] args ) throws IOException {
// The IP adress of the the computer on which the server is running
// (127.0.0.1   if the server is running on the local host)
        String serverAddress = "127.0.0.1";
// The port on which the server listens
        int PORT = 8100;
        Socket socket = null ;
        PrintWriter out = null ;
        BufferedReader in = null ;
        String request, response;
        try {
            socket = new Socket ( serverAddress , PORT );
            out = new PrintWriter ( socket . getOutputStream () , true );
            in = new BufferedReader ( new InputStreamReader (socket.getInputStream()));
// Trimitem o cerere la server
            request = " Bean ";
            out.println( request );
// We wait for the servers request (" Hello Duke !")
            response = in.readLine();
            System.out.println( response );
        } catch ( UnknownHostException e)
        {System.err.println ("The server cannot be found \n" + e);
            System.exit(1);}
        finally {
            if (out != null )
                out.close ();
            if (in != null )
                in.close ();
            if ( socket != null ) socket.close ();
        }
    }
}