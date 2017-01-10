package controller;

import javafx.scene.control.Tab;
import model.Channel;
import model.Program;
import view.TablePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-09.
 */
public class ButtonListener implements ActionListener {


        private ArrayList<Channel> channels = new ArrayList<>();
        private ArrayList<Program> programs = new ArrayList<>();

        public ButtonListener(Channel channel) {

                channels.add(channel);

        }


        public void actionPerformed(ActionEvent e) {

                for(int i = 0; i < channels.size(); i++) {

                        if (e.getActionCommand().equals(channels.get(i).getName())) {
                                System.out.println("Pressed channel " + channels.get(i).getName());
                                programs = channels.get(i).getPrograms();
                                TablePanel tablePanel = new TablePanel(programs);
                                break;
                        }
                }


        }
}