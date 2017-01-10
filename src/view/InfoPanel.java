package view;

import model.Channel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: Andreas, Arvid
 * File: TroopMakerPanel
 * Created: 16-11-23
 * Description: A panel object to create a TroopMaker JPanel for a frame.
 */
public class InfoPanel {



        //Sets the default image index to 0.
        private final int DEFAULT_IMAGE_INDEX = 0;
        private int currentImage = 0;

        // Cache image icon load
        private HashMap<String, ImageIcon> programIcons = new HashMap<>();
        private ArrayList<ActionListener> actionListeners = new ArrayList<>();

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
                //buttonPanelSetup();
                programIconPanelSetup();

                infoPanel.setBorder(BorderFactory.createTitledBorder("Programinfo"));
                infoPanel.setMinimumSize(new Dimension(40, 40));
                infoPanel.setLayout(new BorderLayout());

                infoPanel.add(programInfoPanel, BorderLayout.CENTER);
                //troopMakerPanel.add(buttonPanel, BorderLayout.SOUTH);
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
                programDescription.setBorder(BorderFactory.createTitledBorder("Programbeskrivning"));
                programDescription.setFont(new Font("Serif", Font.BOLD, 16));
                programDescription.setForeground(Color.CYAN);
                setProgramInfo("Testbeskrivning!!!");
                //changeUnitInfo("Speed: 20\nCost: 100\nHealth: 45");
        }



        private void programIconPanelSetup() {
                programIconPanel = new JPanel();
                programIconPanel.setBorder(BorderFactory.createTitledBorder("Programikon"));
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
         * @param path:int, index at the location of the wanted image.
         */
        public void setProgramImage(String path) {
                if (programIcons.get(path) != null) {
                        label.setIcon(programIcons.get(path));
                } else {
                        try {
                                programIcons.put(path, loadImage(path));
                                label.setIcon(programIcons.get(path));
                        } catch (NullPointerException e) {
                                programIcons.put(path, null);
                                e.printStackTrace();
                        }
                }
        }

        private ImageIcon loadImage(String path) {

                return new ImageIcon(getClass().getResource(path));
        }

        public void setProgramInfo(String description) {

                programDescription.setText(description);
        }

        public int getIconListSize() {

                return programIcons.size();
        }


}
