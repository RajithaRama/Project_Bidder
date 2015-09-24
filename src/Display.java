import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rama on 9/23/2015.
 */
public class Display extends JFrame implements ActionListener{

    private JPanel server;
    private JLabel stockFB = new JLabel("FB");
    private JLabel stockVRTU = new JLabel("VRTU");
    private JLabel stockMSFT = new JLabel("MSFT");
    private JLabel stockGOOGL = new JLabel("GOOGL");
    private JLabel stockYHOO = new JLabel("YHOO");
    private JLabel stockXLNX = new JLabel("XLNX");
    private JLabel stockTSLA = new JLabel("TSLA");
    private JLabel stockTXN = new JLabel("TXN");





    public Display(){

        super("Stock Price");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer timer = new Timer(500, this);
        timer.start();


    }


    public void actionPerformed(ActionEvent e){

    }
}
