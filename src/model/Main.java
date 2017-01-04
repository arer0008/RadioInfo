package model;

import org.xml.sax.SAXException;
import view.MainWindow;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by c15aen on 2017-01-04.
 */
public class Main {

        public static void main(String [ ] args) {

                System.out.println("Hello");
                MainWindow m = new MainWindow();
                m.show();

                        ChannelInfoGetter c = new ChannelInfoGetter();



        }
}
