
import java.io.IOException;

public class Main {

    public static void main(String [] args) throws IOException {
        //Create and set up the window.
        Display serverdisp = new Display();
        serverdisp.setVisible(true);
        DBStocks stocks = new DBStocks("stocks.csv","Symbol","Security Name","Price");
        MainServer server = new MainServer(MainServer.BASE_PORT,
                stocks);
        server.server_loop();



    }
}
