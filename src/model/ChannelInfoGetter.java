package model;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by c15aen on 2017-01-04.
 */
public class ChannelInfoGetter {

        private URL url;
        private URLConnection conn;
        private org.w3c.dom.Document doc;

        public ChannelInfoGetter()  {
                try {
                        url = new URL("http://api.sr.se/api/v2/channels/");
                } catch (MalformedURLException e) {
                        e.printStackTrace();
                }
                try {
                        conn = url.openConnection();
                } catch (IOException e) {
                        e.printStackTrace();
                }


                try {
                        conn.connect();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = null;
                try {
                        db = dbf.newDocumentBuilder();
                } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                }
                try {
                        doc = db.parse(conn.getInputStream());
                } catch (SAXException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                NodeList n = new NodeList() {
                        @Override
                        public Node item(int index) {
                                return null;
                        }

                        @Override
                        public int getLength() {
                                return 0;
                        }
                };
                n = doc.getElementsByTagName("channel");
                System.out.println(n.item(1));



        }


}