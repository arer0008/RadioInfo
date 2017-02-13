package model;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-04.
 */
public class ChannelGetter {

        private URL url;
        private URLConnection conn;
        private org.w3c.dom.Document doc;
        private int pages;
        private ArrayList<Channel> channels = new ArrayList<>();
        private String nextpage;

        public ChannelGetter(String s)  {

                setUpConnection(s);
                createDocument();

                NodeList channelNodeList;
                NodeList paginationNodes;

                paginationNodes = doc.getElementsByTagName("pagination");
                NodeList p = paginationNodes.item(0).getChildNodes();
                for(int i = 0; i < p.getLength(); i++) {
                        if(p.item(i).getNodeName().equals("totalpages")) {
                                pages = Integer.valueOf(p.item(i).getTextContent());
                                break;

                        }

                }

                int loops = 0;
                while(loops < pages) {

                        paginationNodes = doc.getElementsByTagName("pagination");
                        NodeList p2 = paginationNodes.item(0).getChildNodes();

                        for(int i = 0; i < p2.getLength(); i++) {

                                if(p2.item(i).getNodeName().equals("nextpage")) {
                                        nextpage = p2.item(i).getTextContent();

                                }
                        }
                        channelNodeList = doc.getElementsByTagName("channel");


                        for (int i = 0; i < channelNodeList.getLength(); i++) {
                                Channel c = new Channel();


                                Node channelNode = channelNodeList.item(i);


                                NamedNodeMap nnm = channelNode.getAttributes();
                                c.setID(nnm.getNamedItem("id").getTextContent());
                                c.setName(nnm.getNamedItem("name").getTextContent());

                                NodeList childNodeList = channelNode.getChildNodes();
                                for (int j = 0; j < childNodeList.getLength(); j++) {



                                        if (childNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                                String st = childNodeList.item(j).getNodeName();

                                                if (st.equals("scheduleurl")) {
                                                        c.setSceduleurl(childNodeList.item(j).getTextContent());


                                                }

                                                if (st.equals("image")) {

                                                        c.setImageString(childNodeList.item(j).getTextContent());
                                                        String img = childNodeList.item(j).getTextContent();
                                                        URL hej = null;

                                                        if(img.length() > 0) {
                                                                try {
                                                                        hej = new URL(img);
                                                                } catch (MalformedURLException e) {
                                                                        e.printStackTrace();
                                                                }

                                                                try {

                                                                        BufferedImage bufImg = ImageIO.read(hej);

                                                                        ImageIcon icon = new ImageIcon(bufImg.getScaledInstance(170,100,Image.SCALE_SMOOTH));
                                                                        c.setImageIcon(icon);


                                                                } catch (IOException e) {
                                                                        e.printStackTrace();
                                                                }

                                                        }

                                                }
                                                if (st.equals("color")) {
                                                        c.setColor(childNodeList.item(j).getTextContent());
                                                }



                                        }


                                }

                                //c.setPrograms();
                                if(c.getSceduleurl() != null) {
                                        channels.add(c);
                                }


                        }
                        loops++;

                        setUpConnection(nextpage);
                        createDocument();

                }






        }

        public void setUpConnection(String s) {

                try {
                        //System.out.println(s);
                        url = new URL(s);
                        conn = url.openConnection();
                        conn.connect();
                } catch (IOException e) {
                        e.printStackTrace();
                }


        }

        public void createDocument() {


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


        }

        public ArrayList<Channel> getChannels() {

                return channels;
        }

        public void print() {
                System.out.println(channels.size());
                for(Channel c:channels){
                        c.print();
                }
        }


}