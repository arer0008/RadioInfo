package model;

/**
 * Created by c15aen on 2017-01-04.
 */
public class Channel {

        private String name;
        private String ID;
        private String image;
        private String sceduleurl;
        private String color;

        public Channel() {

        }

        public void setName(String name) {
                this.name = name;

        }

        public void setID(String ID) {
                this.ID = ID;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public void setSceduleurl(String sceduleurl) {
                this.sceduleurl = sceduleurl;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public void print() {
                System.out.println(name);
                System.out.println(ID);
                System.out.println(sceduleurl);
        }
}
