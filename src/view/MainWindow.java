package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by c15aen on 2017-01-04.
 */
public class MainWindow {

        private JFrame mainWindow = new JFrame("RadioInfo");
        private Dimension d = new Dimension(800,600);
        private JPanel upperPanel = new JPanel();
        private JPanel centerPanel = new JPanel();

        public MainWindow() {
                mainWindow.setLayout(new BorderLayout());
                mainWindow.setSize(d);
                mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                //MenuPanel menuPanel = new MenuPanel();
                mainWindow.setJMenuBar(new MenuPanel());
                centerPanel.setPreferredSize(d);
                mainWindow.add(upperPanel, BorderLayout.NORTH);
                mainWindow.add(centerPanel, BorderLayout.CENTER);


        }

        public void show() {
                mainWindow.setVisible(true);
        }
}
