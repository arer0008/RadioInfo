package view;

import model.Channel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Author: Andreas, Arvid
 * File: TroopMakerPanel
 * Created: 16-11-23
 * Description: A panel object to create a TroopMaker JPanel for a frame.
 */
public class InfoPanel {

        private JLabel label;
        private JPanel infoPanel;
        private JPanel programInfoPanel;
        private JPanel programIconPanel;
        private JTextPane programDescription;

        public InfoPanel() {
                label = new JLabel();
                infoPanel = new JPanel();
                panelSetup();
        }

        public void refresh() {

                programIconPanel.repaint();
        }

        /**
         * Setups the buttons needed and configures their sizes.
         */

        /**
         * Setups the panel and adds all the button panels
         * to the Troop Maker Panel.
         */
        private void panelSetup() {

                programInfoPanelSetup();
                programIconPanelSetup();

                infoPanel.setMinimumSize(new Dimension(40, 40));
                infoPanel.setLayout(new BorderLayout());

                infoPanel.add(programInfoPanel, BorderLayout.CENTER);
                infoPanel.add(programIconPanel, BorderLayout.NORTH);
        }

        private void programInfoPanelSetup() {
                programInfoPanel = new JPanel();
                //troopInfoPanel.setPreferredSize(new Dimension(25,320));
                programDescription = new JTextPane();
                programInfoPanel.add(programDescription);
                programDescription.setEditable(false);
                programDescription.setBackground(Color.GRAY);
                programDescription.setPreferredSize(new Dimension(220, 319));
                programDescription.setBorder(BorderFactory.createTitledBorder("Information"));
                programDescription.setFont(new Font("Serif", Font.BOLD, 16));
                programDescription.setForeground(Color.YELLOW);
                setProgramInfo("Om du klickar på en kanal visas en pop-up " +
                        "ruta med en tablå innehållande de program som " +
                        "som kanalen sänder 12 timmar frammåt samt de som " +
                        "redan sänts de 12 senaste timmarna. \nNär du klickar" +
                        " på ett program i tablån visas information om" +
                        " programmet i denna ruta");
        }



        private void programIconPanelSetup() {
                programIconPanel = new JPanel();
                programIconPanel.setBorder(BorderFactory.createTitledBorder("Programikon"));
                programIconPanel.setPreferredSize(new Dimension(220,230));
                programIconPanel.add(label, BorderLayout.CENTER);
        }

        /**
         * Returns a JPanel of the TroopMaker panel.
         *
         * @return JPanel, returns a JPanel of the TroopMakerPanel.
         */
        public JPanel getJPanel() {

                return infoPanel;
        }

        /**
         * Sets the current viewing troop image to the image from the
         * image list at the given index.
         *
         * @param image:int, index at the location of the wanted image.
         */
        public void setProgramImage(ImageIcon image) {

                if(image == null) {
                        label.setIcon(null);
                        label.setText("Ingen tillgänglig bild för detta program");
                }
                else {
                        label.setText(null);
                        label.setIcon(image);
                }

        }

        private ImageIcon loadImage(String path) {

                return new ImageIcon(getClass().getResource(path));
        }

        public void setProgramInfo(String description) {

                if(description.length() < 1) {
                        programDescription.setText("Ingen tillgänglig information om detta program");
                }
                else {
                        programDescription.setText(description);

                }
        }



}
