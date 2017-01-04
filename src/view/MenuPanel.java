package view;

import javax.swing.*;

/**
 * Created by c15aen on 2017-01-04.
 */
public class MenuPanel extends JMenuBar {


        private JMenu info;
        private JMenuItem quit;


        public MenuPanel() {
                super();


                info = new JMenu("info");
                quit = new JMenuItem("quit");
                info.add(quit);
                add(info);
        }


}
