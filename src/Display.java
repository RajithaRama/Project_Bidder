import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rama on 9/23/2015.
 */
public class Display extends JFrame implements ActionListener{

    private JPanel disp;
    private JLabel stockFB;
    private JLabel stockVRTU;
    private JLabel stockMSFT;
    private JLabel stockGOOGL;
    private JLabel stockYHOO;
    private JLabel stockXLNX;
    private JLabel stockTSLA;
    private JLabel stockTXN;
    private JLabel FB;
    private JLabel VRTU;
    private JLabel MSFT;
    private JLabel GOOGL;
    private JLabel YHOO;
    private JLabel XLNX;
    private JLabel TSLA;
    private JLabel TXN;
    private JLabel title;
    private MigLayout form;
    private MainServer mainServer;


    public Display(MainServer mainServer){

        super("Stock Price");
        this.mainServer = mainServer;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();

        Timer timer = new Timer(500, this);
        timer.start();



    }

    private void init() {
        stockFB = new JLabel("FB");
        stockMSFT = new JLabel("MSFT");
        stockVRTU = new JLabel("VRTU");
        stockGOOGL = new JLabel("GOOGL");
        stockYHOO = new JLabel("YHOO");
        stockXLNX = new JLabel("XLNX");
        stockTSLA = new JLabel("TSLA");
        stockTXN = new JLabel("TXN");
        FB = new JLabel();
        MSFT = new JLabel();
        VRTU = new JLabel();
        GOOGL = new JLabel();
        YHOO = new JLabel();
        XLNX = new JLabel();
        TSLA = new JLabel();
        TXN = new JLabel();
        title = new JLabel("Current Stock prices");
        form = new MigLayout();

        disp = new JPanel(form);

        disp.setSize(400, 600);
        disp.setFont(new Font("Calibri", Font.ITALIC, 24));

        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(title, "span 2, grow, shrink, wrap");

        stockFB.setSize(100, 50);
        stockFB.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockFB, "grow, shrink");

        FB.setSize(100, 50);
        FB.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(FB, "grow, shrink, wrap");

        stockGOOGL.setSize(100, 50);
        stockGOOGL.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockGOOGL, "grow, shrink");

        GOOGL.setSize(100, 50);
        GOOGL.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(GOOGL, "grow, shrink, wrap");


        stockMSFT.setSize(100, 50);
        stockMSFT.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockMSFT, "grow, shrink");

        MSFT.setSize(100, 50);
        MSFT.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(MSFT, "grow, shrink, wrap");

        stockTSLA.setSize(100, 50);
        stockTSLA.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockTSLA, "grow, shrink");

        TSLA.setSize(100, 50);
        TSLA.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(TSLA, "grow, shrink, wrap");

        stockTXN.setSize(100, 50);
        stockTXN.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockTXN, "grow, shrink");

        TXN.setSize(100, 50);
        TXN.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(TXN, "grow, shrink, wrap");

        stockVRTU.setSize(100, 50);
        stockVRTU.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockVRTU, "grow, shrink");

        VRTU.setSize(100, 50);
        VRTU.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(VRTU, "grow, shrink, wrap");


        stockXLNX.setSize(100, 50);
        stockXLNX.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockXLNX, "grow, shrink");

        XLNX.setSize(100, 50);
        XLNX.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(XLNX, "grow, shrink, wrap");

        stockYHOO.setSize(100, 50);
        stockYHOO.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockYHOO, "grow, shrink");

        YHOO.setSize(100, 50);
        YHOO.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(YHOO, "grow, shrink, wrap");

        disp.setOpaque(true);
        disp.setVisible(true);
        this.add(disp);
        this.pack();


    }


    public void actionPerformed(ActionEvent e){
        FB.setText(String.valueOf(mainServer.getPrice("FB")));
        MSFT.setText(String.valueOf(mainServer.getPrice("MSFT")));
        VRTU.setText(String.valueOf(mainServer.getPrice("VRTU")));
        GOOGL.setText(String.valueOf(mainServer.getPrice("GOOGL")));
        YHOO.setText(String.valueOf(mainServer.getPrice("YHOO")));
        XLNX.setText(String.valueOf(mainServer.getPrice("XLNX")));
        TSLA.setText(String.valueOf(mainServer.getPrice("TSLA")));
        TXN.setText(String.valueOf(mainServer.getPrice("TXN")));
    }
}
