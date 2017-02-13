package controller;

import model.Program;
import view.InfoPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-18.
 */
public class MouseListener implements java.awt.event.MouseListener {

        private ArrayList<Program> programs = new ArrayList<>();
        private InfoPanel infoPanel;
        private Program p;

        public MouseListener(ArrayList<Program> programs, InfoPanel infoPanel) {

                this.programs = programs;
                this.infoPanel = infoPanel;


        }

        @Override
        public void mouseClicked(MouseEvent e) {

                JTable source = (JTable) e.getSource();
                int row = source.rowAtPoint(e.getPoint());
                int column = source.columnAtPoint(e.getPoint());
                System.out.println(source.getValueAt(row, column));
                String s = (String) source.getValueAt(row, column);

                for (int i = 0 ; i < programs.size(); i++) {
                        if(s.equals(programs.get(i).getTitle())) {
                                p = programs.get(i);
                                infoPanel.setProgramInfo(p.getDescription());
                                infoPanel.setProgramImage(p.getImageIcon());
                                break;
                        }
                }

                //System.out.println(p.getDescription());

                //infoPanel.setProgramImage();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
}
