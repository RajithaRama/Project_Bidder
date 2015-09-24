import java.io.*;
import java.net.Socket;

/**
 * Created by Rama on 9/24/2015.
 */
public class ConnectionServer implements Runnable {
    public static final int WAIT_AUTH = 0;
    public static final int AUTH_DONE = 1;

    public static final String GET_NAME_MSG = "Your Name :";
    public static final String GET_STOCK_MSG = "Stock You are willing to Bid :";
    public static final String AUTH_DONE_MSG = "You are authorised to bid\n";
    public static final String MSG_POSTED    = "Your bid is success\n";

    // per connection variables
    private Socket mySocket; // connection socket per thread
    private int currentState;
    private String clientName;
    private String stockSymbol;
    private MainServer mainServer;

    public ConnectionServer(MainServer mainServer) {
        this.mySocket = null; // we will set this later
        this.currentState = -1;
        this.clientName = null;
        this.mainServer = mainServer;
        // who created me. He should give some interface
    }

    public void run(){
        BufferedReader in=null;
        PrintWriter out=null;
        try {
            in = new
                    BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            out = new
                    PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));
            out.println(GET_NAME_MSG);
            String line, outline;
            for(line = in.readLine();
                line != null && !line.equals("quit");
                line = in.readLine()) {

                switch(currentState) {
                    case -1:
                        clientName = line;
                        currentState = WAIT_AUTH;
                        outline = GET_STOCK_MSG;
                        break;

                    case WAIT_AUTH:
                        // we are waiting for name and stock symbol
                        // e number should be the line

                        if(mainServer.isAuthorized(line)) {
                            stockSymbol = line;
                            currentState = AUTH_DONE;
                            outline = AUTH_DONE_MSG;
                        }
                        else {
                            outline = GET_STOCK_MSG;
                        }
                        break;
                    /*****************************/
                    case AUTH_DONE:
                        mainServer.changePrice(stockSymbol,line);
                        mainServer.addHistory(stockSymbol,clientName,line);
                        outline = MSG_POSTED;
                        break;
                    default:
                        System.out.println("Undefined state");
                        return;
                } // case

                out.print(outline); // Send the said message
                out.flush(); // flush to network

            } // for

            // close everything
            out.close();
            in.close();
            this.mySocket.close();
        } // try
        catch (IOException e) {
            System.out.println(e);
        }
    }


    public boolean handleConnection(Socket socket) {
        this.mySocket = socket;
        Thread newThread = new Thread(this);
        newThread.start();
        return true;

    }
}
