package model;

import javax.swing.*;

/**
 * Created by c15aen on 2017-01-04.
 */
public class Program {

        private String ID;
        private String description;
        private String title;
        private String startTime;
        private String endTime;
        private String channelID;
        private String channelName;
        private String name;
        private String imageString;
        private ImageIcon imageIcon;

        public Program() {

        }

        public void setID(String ID) {

                this.ID = ID;

        }

        public void setDescription(String description) {

                this.description = description;

        }

        public void setTitle(String title) {

                this.title = title;

        }

        public void setStart(String startTime) {

                this.startTime = startTime;

        }

        public void setEnd(String endTime) {

                this.endTime = endTime;

        }

        public void setChannelID(String channelID) {

                this.channelID = channelID;

        }
        public void setChannelName(String channelName) {

                this.channelName = channelName;

        }

        public void setName(String name) {

                this.name = name;

        }

        public void setImageString(String image) {

                this.imageString = image;
        }

        public void setImageIcon(ImageIcon image) {

                this.imageIcon = image;
        }



        public String getID() {
                return ID;
        }

        public String getDescription() {
                return description;
        }

        public String getTitle() {
                return title;
        }

        public String getStartTime() {
                return startTime;
        }

        public String getEndTime() {
                return endTime;
        }

        public String getChannelID() {
                return channelID;
        }

        public String getChannelName() {
                return channelName;
        }

        public String getName() {
                return name;
        }

        public String getImageString() {
                return imageString;
        }
        public ImageIcon getImageIcon() {
                return imageIcon;
        }

        public void print() {
                System.out.println(name);
                System.out.println(startTime);
                System.out.println(channelName);
                //System.out.println(title);
        }
}
