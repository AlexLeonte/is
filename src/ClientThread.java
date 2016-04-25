/**
 * Created by lad on 25.04.2016.
 */
import java.net.*;
import java.io.*;
class ClientThread extends Thread {
    Socket socket = null ;
    public ClientThread (Socket socket) {
        this.socket = socket ;
    }
    public void run () {
        // Processing the clients request
        String request , response;
        try {
            // in is the input stream from the client
            BufferedReader in = new BufferedReader ( new
                    InputStreamReader(socket.getInputStream () ));
// out is an output stream through the client
            PrintWriter out = new PrintWriter (socket.getOutputStream ());
// We receive the request from the client
            request = in.readLine();
// We send a response to the client
            response = " Hello " + request + "!";
            //jessWorld.function
            out.println( response );
            out.flush();
        } catch ( IOException e) {System.err.println (" IO error \n" + e);}
        finally {
// We close the socket opened for the current client
            try {
                socket.close ();
            } catch ( IOException e) {System.err.println (" The socketcannot be closed \n" +e);}
        }
    }
}