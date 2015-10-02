import com.sun.javafx.collections.MappingChange;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
    private JComboBox<String> histo;
    private MigLayout form;
    private MainServer mainServer;
    private JTextArea textArea;
    private HashMap<String, Integer> place = new HashMap<String, Integer>();

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
        histo = new JComboBox();
        title = new JLabel("Current Stock prices");
        textArea = new JTextArea("History....\n");
        form = new MigLayout();
        Dimension label = new Dimension(100,50);

        place.put("FB",0);
        place.put("MSFT", 0);
        place.put("VRTU", 0);
        place.put("GOOGL", 0);
        place.put("YHOO", 0);
        place.put("XLNX", 0);
        place.put("TSLA", 0);
        place.put("TXN", 0);

        disp = new JPanel(form);

        disp.setPreferredSize(new Dimension(600, 500));
        disp.setFont(new Font("Calibri", Font.ITALIC, 24));

        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(title, "span 2, grow, shrink, wrap");

        stockFB.setPreferredSize(label);
        stockFB.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockFB, "grow, shrink");

        FB.setPreferredSize(label);
        FB.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(FB, "grow, shrink");

        //histo.addItem("None");
        histo.addItem("FB");
        histo.addItem("VRTU");
        histo.addItem("GOOGL");
        histo.addItem("MSFT");
        histo.addItem("YHOO");
        histo.addItem("XLNX");
        histo.addItem("TSLA");
        histo.addItem("TXN");
        histo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(histo.getSelectedItem() + " Bidding History\n");
                textArea.append(mainServer.getHistory((String) histo.getSelectedItem(), 0));
            }
        });
        disp.add(histo, "grow, shrink, span 2, wrap");


        stockGOOGL.setPreferredSize(label);
        stockGOOGL.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockGOOGL, "grow, shrink");

        GOOGL.setPreferredSize(label);
        GOOGL.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(GOOGL, "grow, shrink");

        textArea.setPreferredSize(new Dimension(400, 200));
        textArea.setFont(new Font("Calibri", Font.BOLD, 24));
        disp.add(textArea, "grow, shrink, span 2 8, wrap");


        stockMSFT.setPreferredSize(label);
        stockMSFT.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockMSFT, "grow, shrink");

        MSFT.setPreferredSize(label);
        MSFT.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(MSFT, "grow, shrink, wrap");

        stockTSLA.setPreferredSize(label);
        stockTSLA.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockTSLA, "grow, shrink");

        TSLA.setPreferredSize(label);
        TSLA.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(TSLA, "grow, shrink, wrap");

        stockTXN.setPreferredSize(label);
        stockTXN.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockTXN, "grow, shrink");

        TXN.setPreferredSize(label);
        TXN.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(TXN, "grow, shrink, wrap");

        stockVRTU.setPreferredSize(label);
        stockVRTU.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockVRTU, "grow, shrink");

        VRTU.setPreferredSize(label);
        VRTU.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(VRTU, "grow, shrink, wrap");


        stockXLNX.setPreferredSize(label);
        stockXLNX.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockXLNX, "grow, shrink");

        XLNX.setPreferredSize(label);
        XLNX.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(XLNX, "grow, shrink, wrap");

        stockYHOO.setPreferredSize(label);
        stockYHOO.setHorizontalAlignment(SwingConstants.CENTER);
        disp.add(stockYHOO, "grow, shrink");

        YHOO.setPreferredSize(label);
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

        textArea.append(history());

        place.replace("FB", mainServer.getsizehistory("FB"));
        place.replace("MSFT",mainServer.getsizehistory("MSFT"));
        place.replace("VRTU",mainServer.getsizehistory("VRTU"));
        place.replace("GOOGL",mainServer.getsizehistory("GOOGL"));
        place.replace("YHOO",mainServer.getsizehistory("YHOO"));
        place.replace("XLNX",mainServer.getsizehistory("XLNX"));
        place.replace("TSLA",mainServer.getsizehistory("TSLA"));
        place.replace("TXN",mainServer.getsizehistory("TXN"));
    }

    public String history(){
        String st = String.valueOf(histo.getSelectedItem());
        if(place.containsKey(st) && ((place.get(st))!=0)){
            return mainServer.getHistory(st, (place.get(st)));
        }
        return "";
    }
}
