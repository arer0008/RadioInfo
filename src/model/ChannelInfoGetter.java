package model;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-04.
 */
public class ChannelInfoGetter {

        private URL url;

        private URLConnection conn;

        private org.w3c.dom.Document doc;


        ArrayList<Channel> channels = new ArrayList<>();


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

                NodeList channelNodeList;
                channelNodeList = doc.getElementsByTagName("channel");


                for(int i = 0; i < channelNodeList.getLength(); i++) {
                        Channel c = new Channel();

                        Node channelNode = channelNodeList.item(i);


                        NamedNodeMap nnm = channelNode.getAttributes();
                        c.setID(nnm.getNamedItem("id").getTextContent());
                        c.setName(nnm.getNamedItem("name").getTextContent());

                        NodeList childNodeList = channelNode.getChildNodes();
                        for(int j = 0; j < childNodeList.getLength(); j++) {


                                if(childNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                        String st = childNodeList.item(j).getNodeName();
                                        if(st.equals("image")) {
                                                c.setImage(childNodeList.item(j).getTextContent());
                                        }
                                        if(st.equals("color")) {
                                                c.setColor(childNodeList.item(j).getTextContent());
                                        }
                                        if(st.equals("scheduleurl")) {
                                                c.setSceduleurl(childNodeList.item(j).getTextContent());
                                        }




                                }

                        }
                        channels.add(c);


                }






        }

        public ArrayList getChannels() {
                return channels;
        }

        public void print() {
                System.out.println(channels.size());
                for(Channel c:channels){
                        c.print();
                }
        }


}