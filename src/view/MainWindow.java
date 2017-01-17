package view;

import model.Channel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-04.
 */


public class MainWindow {

        private InfoPanel infoPanel;
        private ButtonPanel buttonPanel;
        private TableFrame tableFrame;
        private JFrame mainWindow = new JFrame("RadioInfo");
        private Dimension d = new Dimension(400,200);
        private JPanel upperPanel = new JPanel();
        private JPanel rightPanel = new JPanel();
        private JPanel centerPanel = new JPanel();
        private JTable popUpPanel = new JTable();


        public MainWindow(ArrayList<Channel> channels) {
                mainWindow.setLayout(new BorderLayout());
                mainWindow.setSize(d);
                mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                infoPanel = new InfoPanel();
                buttonPanel = new ButtonPanel(channels);
                tableFrame = new TableFrame(channels.get(1).getPrograms());


                mainWindow.setJMenuBar(new MenuPanel());
                rightPanel = infoPanel.getJPanel();
                centerPanel = buttonPanel.getJPanel();
                popUpPanel = tableFrame.createTable();
                rightPanel.setPreferredSize(d);
                mainWindow.setSize(new Dimension(1400,1050));
                mainWindow.add(upperPanel, BorderLayout.NORTH);
                mainWindow.add(rightPanel, BorderLayout.EAST);
                mainWindow.add(centerPanel, BorderLayout.CENTER);
                //mainWindow.add(popUpPanel, BorderLayout.WEST);



        }

        public void show() {

                mainWindow.setVisible(true);
        }


}
