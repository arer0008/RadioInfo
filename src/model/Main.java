package model;

import view.MainWindow;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-04.
 */
public class Main {

        public static void main(String [ ] args) {



                ChannelGetter c = new ChannelGetter("http://api.sr.se/api/v2/channels/");
                ArrayList<Channel> channels = c.getChannels();
                System.out.println("Antal kanaler är :"+channels.size());


                SwingUtilities.invokeLater(() -> {
                        MainWindow m = new MainWindow(channels);
                        m.show();
                });





        }
}
