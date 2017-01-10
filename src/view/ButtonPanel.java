package view;

import model.Channel;
import controller.ButtonListener;

import javax.swing.*;
import java.awt.*;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-09.
 */
public class ButtonPanel {

        private ArrayList<Channel> channels;
        private ArrayList<JButton> buttons = new ArrayList<>();
        private JPanel buttonPanel;
        private URL url;
        private URLConnection conn;

        public ButtonPanel(ArrayList<Channel> channels) {


                buttonPanel = new JPanel();
                this.channels = channels;
                createButtons();
        }

        public void createButtons() {

                Dimension buttonDimension = new Dimension(175, 105);

                for(int i = 0; i < channels.size() ; i++) {
                        if(channels.get(i).getName() != null && channels.get(i).getImageIcon() != null) {
                                JButton button = new JButton();
                                button.setIcon(channels.get(i).getImageIcon());
                                button.setPreferredSize(buttonDimension);
                                button.addActionListener(new ButtonListener(channels.get(i)));
                                button.setActionCommand(channels.get(i).getName());

                                addButton(button);
                        }

                }


                /*TroopMakerListener spawnListener = new ActionListener();
                actionListeners.add(spawnListener);


                prevTroop.addActionListener(spawnListener);
                nextTroop.addActionListener(spawnListener);
                spawnTroop.addActionListener(spawnListener);*/


        }

        public void addButton(JButton button) {
                buttons.add(button);
                buttonPanel.add(button);

        }

        public JPanel getJPanel(){
                return buttonPanel;
        }

        public ArrayList<JButton> getButtons() {
                return buttons;
        }

}
