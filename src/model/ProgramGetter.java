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
 * Created by c15aen on 2017-01-05.
 */
public class ProgramGetter {

        private URL url;
        private URLConnection conn;
        private org.w3c.dom.Document doc;
        private ArrayList<Program> programs = new ArrayList<>();
        private int pages;
        private String nextpage;

        public ProgramGetter(String s) {

                setUpConnection(s);
                createDocument();

                NodeList sceduleNodeList;
                NodeList paginationNodes;





                paginationNodes = doc.getElementsByTagName("pagination");
                NodeList paginationChildren = paginationNodes.item(0).getChildNodes();
                for (int i = 0; i < paginationChildren.getLength(); i++) {
                        if (paginationChildren.item(i).getNodeName().equals("totalpages")) {
                                pages = Integer.valueOf(paginationChildren.item(i).getTextContent());
                                break;

                        }

                }


                int loops = 0;
                while (loops < pages) {

                        paginationNodes = doc.getElementsByTagName("pagination");
                        NodeList p2 = paginationNodes.item(0).getChildNodes();

                        for (int i = 0; i < p2.getLength(); i++) {

                                if (p2.item(i).getNodeName().equals("nextpage")) {
                                        nextpage = p2.item(i).getTextContent();

                                }
                        }

                        sceduleNodeList = doc.getElementsByTagName("scheduledepisode");


                        for (int i = 0; i < sceduleNodeList.getLength(); i++) {
                                Program p = new Program();

                                Node sceduleNode = sceduleNodeList.item(i);


                                NodeList childNodeList = sceduleNode.getChildNodes();

                                for (int j = 0; j < childNodeList.getLength(); j++) {


                                        if (childNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                                String st = childNodeList.item(j).getNodeName();
                                                if (st.equals("title")) {
                                                        p.setTitle(childNodeList.item(j).getTextContent());
                                                }
                                                if (st.equals("description")) {
                                                        p.setDescription(childNodeList.item(j).getTextContent());
                                                }
                                                if (st.equals("starttimeutc")) {
                                                        p.setStart(childNodeList.item(j).getTextContent());
                                                }
                                                if (st.equals("endtimeutc")) {
                                                        p.setEnd(childNodeList.item(j).getTextContent());
                                                }
                                                if (st.equals("program")) {
                                                        NamedNodeMap nnm = childNodeList.item(j).getAttributes();
                                                        p.setID(nnm.getNamedItem("id").getTextContent());
                                                        //p.setName(nnm.getNamedItem("name").getTextContent());
                                                }
                                                /*if (st.equals("channel")) {
                                                        NamedNodeMap nnm = childNodeList.item(j).getAttributes();
                                                        p.setChannelID(nnm.getNamedItem("id").getTextContent());
                                                        p.setChannelName(nnm.getNamedItem("name").getTextContent());

                                                }*/

                                                if (st.equals("imageurl")) {

                                                        p.setImageString(childNodeList.item(j).getTextContent());
                                                        //String img = childNodeList.item(j).getTextContent();
                                                        //System.out.println(img);
                                                        //img = img.trim();
                                                        //URL hej = null;
                                                        /*if(img.length() > 0) {
                                                                try {
                                                                        hej = new URL(img);
                                                                } catch (MalformedURLException e) {
                                                                        System.err.println("fel" + img);
                                                                        e.printStackTrace();
                                                                }

                                                                try {

                                                                        BufferedImage bufImg = ImageIO.read(hej);
                                                                        Image th = bufImg.getScaledInstance(170,100,Image.SCALE_SMOOTH);
                                                                        ImageIcon icon = new ImageIcon(th);
                                                                        p.setImageIcon(icon);


                                                                } catch (IOException e) {
                                                                        e.printStackTrace();
                                                                }

                                                        }*/

                                                }


                                        }

                                }

                                programs.add(p);


                        }
                        loops++;
                        setUpConnection(nextpage);
                        createDocument();
                }

        }



        public void setUpConnection(String s) {


                try {
                        url = new URL(s);
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

        public ArrayList<Program> getPrograms() {

                return programs;
        }

        public void print() {
                System.out.println(programs.size());
                programs.forEach(Program::print);
        }


}



