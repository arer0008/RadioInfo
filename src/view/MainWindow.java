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
        private JFrame mainWindow = new JFrame("RadioInfo");
        private Dimension d = new Dimension(400,200);
        private JPanel upperPanel = new JPanel();
        private JPanel rightPanel = new JPanel();
        private JPanel centerPanel = new JPanel();

        public MainWindow(ArrayList<Channel> channels) {
                mainWindow.setLayout(new BorderLayout());
                mainWindow.setSize(d);
                mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                infoPanel = new InfoPanel();
                buttonPanel = new ButtonPanel(channels);

                mainWindow.setJMenuBar(new MenuPanel());
                rightPanel = infoPanel.getJPanel();
                centerPanel = buttonPanel.getJPanel();
                rightPanel.setPreferredSize(d);
                mainWindow.setSize(new Dimension(1400,1050));
                mainWindow.add(upperPanel, BorderLayout.NORTH);
                mainWindow.add(rightPanel, BorderLayout.EAST);
                mainWindow.add(centerPanel, BorderLayout.CENTER);


        }

        public void show() {

                mainWindow.setVisible(true);
        }
}
