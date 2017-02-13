package controller;

import model.Channel;
import model.Program;
import view.InfoPanel;
import view.TableFrame;

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
        private InfoPanel infoPanel;

        public ButtonListener(Channel channel, InfoPanel infoPanel) {

                this.infoPanel = infoPanel;
                channels.add(channel);

        }


        public void actionPerformed(ActionEvent e) {

                for(int i = 0; i < channels.size(); i++) {

                        if (e.getActionCommand().equals(channels.get(i).getName())) {
                                channels.get(i).setPrograms();
                                System.out.println("Pressed channel " + channels.get(i).getName());
                                programs = channels.get(i).getPrograms();
                                TableFrame tableFrame = new TableFrame(programs, infoPanel);
                                tableFrame.setTitle(channels.get(i).getName());
                                tableFrame.show();


                                break;
                        }
                }


        }
}