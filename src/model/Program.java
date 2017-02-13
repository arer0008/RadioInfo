package model;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

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
        private String imageString;
        private ImageIcon imageIcon;
        private boolean hasAired;
        private static Date today = new Date();


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


        public void setImageString(String image) {

                this.imageString = image;
        }

        public void setImageIcon(ImageIcon image) {

                this.imageIcon = image;
        }

        public boolean gethasAired() {

                return hasAired;
        }

        public void setHasAired() {

                DateFormat d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date date = null;
                Date nowDate = new Date();
                try {
                        date = d.parse(endTime);

                } catch (ParseException e) {
                        e.printStackTrace();
                }

                assert date != null;
                if (date.before(nowDate)) {
                        hasAired = true;
                } else {
                        hasAired= false;
                }


        }

        public boolean isWithinTimeframe() {

                DateFormat d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date show = null;

                try {
                        show = d.parse(endTime);
                } catch (ParseException e) {
                        e.printStackTrace();
                }

                Date twelveAhead = new Date(today.getTime() + (1000 * 60 * 60 * 12));
                Date twelveBefore = new Date(today.getTime() - (1000 * 60 * 60 * 12));

                assert show != null;
                return show.after(twelveBefore) && show.before(twelveAhead);


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

        public String getUnformattedStartTime() {
                return startTime;
        }

        public String getUnformattedEndTime() {
                return endTime;
        }

        public String getStartTime() {

                return startTime.substring(11,19);
        }

        public String getEndTime() {

                return endTime.substring(11,19);
        }

        public String getChannelID() {
                return channelID;
        }

        public String getChannelName() {
                return channelName;
        }

        public String getImageString() {
                return imageString;
        }
        public ImageIcon getImageIcon() {
                return imageIcon;
        }

        public void print() {
                System.out.println(title);
                System.out.println(startTime);
                System.out.println(channelName);
                //System.out.println(title);
        }
}
