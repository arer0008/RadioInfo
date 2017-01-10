package model;

import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-05.
 */
public class Scedule {

        ArrayList<Program> programs = new ArrayList<>();
        String channelID;

        public Scedule() {

        }

        public void setChannelID(String ID) {

                channelID = ID;

        }

        public void addProgram(Program p) {

                programs.add(p);

        }

        public ArrayList<Program> getPrograms() {

                return programs;
        }

        public String getChannelID() {
                return channelID;
        }
}
