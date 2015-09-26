
import java.io.IOException;

public class Main {

    public static void main(String [] args) throws IOException {
        //Create and set up the window.

        DBStocks stocks = new DBStocks("stocks.csv","Symbol","Security Name","Price");
        MainServer server = new MainServer(MainServer.BASE_PORT,
                stocks);
        Display serverdisp = new Display(server);
        serverdisp.setVisible(true);
        server.server_loop();



    }
}
