/**
 * Created by lad on 25.04.2016.
 */
import java.net.*;
import java.io.*;
public class ServerSide {
    // We define the port on which the server
    // resides (not in the interval 1-1024)
    public static final int PORT = 8100;
    public ServerSide () throws IOException 	{
        ServerSocket serverSocket = null ;

        try {
            serverSocket = new ServerSocket ( PORT );
            while ( true ) {
                System.out.println(" Expecting a client... ");
                Socket socket = serverSocket.accept();
                // We process the clients request in a thread
                ClientThread t = new ClientThread( socket );
                JessWorld jessworld = new JessWorld();                                          //include jess world in server
                jessworld.start();                                                              //start jess thread file
                t.start();
            }
        } catch ( IOException e) {System . err. println (" Eroare IO \n" + e);
        }
        finally {
            serverSocket . close ();
        }
    }
    public static void main ( String [] args ) throws IOException {
        ServerSide server = new ServerSide ();
    }
}  // end of class