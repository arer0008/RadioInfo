package model;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-04.
 */
public class Channel {

        private String name;
        private String ID;
        private String imageString;
        private String sceduleurl;
        private String color;
        private ArrayList<Program> programs = new ArrayList<>();
        private ImageIcon imageIcon;


        public Channel() {


        }

        public void setPrograms() {
                //System.out.println(sceduleurl);

                if(sceduleurl != null) {
                        ProgramGetter pg = new ProgramGetter(sceduleurl);
                        programs = pg.getPrograms();
                }

        }

        public void setName(String name) {
                this.name = name;

        }

        public void setID(String ID) {

                this.ID = ID;
        }

        public void setImageString(String image) {

                this.imageString = image;
        }

        public void setImageIcon(ImageIcon image) {
                imageIcon = image;

        }

        public void setSceduleurl(String sceduleurl) {
                this.sceduleurl = sceduleurl;
        }

        public void setColor(String color) {

                this.color = color;
        }

        public ArrayList<Program> getPrograms() {
                return programs;
        }

        public String getSceduleurl() {

                return sceduleurl;
        }

        public String getName() {

                return name;
        }

        public ImageIcon getImageIcon() {
                return imageIcon;
        }

        public String getID() {

                return ID;
        }

        public String getImageString() {

                return imageString;
        }

        public String getColor() {

                return color;
        }

        public void print() {
                System.out.println(name);
                System.out.println(ID);
                System.out.println(sceduleurl);
        }
}
