import javafx.beans.binding.MapExpression;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Rama on 9/23/2015.
 */
public class MainServer {

    /* Some constants */
    public static final int BASE_PORT = 2000;  // do not change


    /* local data for the server
     * Every main server is defined in terms of the port it
     * listens and the database of allowed users
     */
    private ServerSocket serverSocket=null;  // server Socket for main server
    private DBStocks stocks=null;     // who are allowed to chat




    private static Map<String,LinkedList> history = new HashMap<String,LinkedList>();


    public MainServer(int socket, DBStocks stocks) {
        this.stocks = stocks;
        history.put("FB", new LinkedList<Tuple<String, Double>>());
        history.put("VRTU", new LinkedList<Tuple<String, Double>>());
        history.put("MSFT", new LinkedList<Tuple<String, Double>>());
        history.put("GOOGL", new LinkedList<Tuple<String, Double>>());
        history.put("YHOO", new LinkedList<Tuple<String, Double>>());
        history.put("XLNX", new LinkedList<Tuple<String, Double>>());
        history.put("TSLA", new LinkedList<Tuple<String, Double>>());
        history.put("TXN", new LinkedList<Tuple<String, Double>>());

        try {
            this.serverSocket = new ServerSocket(socket);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public void server_loop() {
        try {
            while(true) {
                Socket socket = this.serverSocket.accept();
                ConnectionServer worker = new ConnectionServer(this);
                worker.handleConnection(socket);
            }
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    public boolean isAuthorized(String line) {
        return this.stocks.isin(line);
        }


    public int changePrice(String stock, String line) {
        return this.stocks.updatePrice(stock, line);
    }

    public void addHistory(String stockSymbol, String clientName, String line) {
        LinkedList<Tuple<String, Double>> arr=  history.get(stockSymbol);
        arr.add(new Tuple<String, Double>(clientName, Double.parseDouble(line)));
        history.replace(stockSymbol,arr);
    }

    public double getPrice(String stockSymbol){
        return stocks.findPrice(stockSymbol);
    }
}
