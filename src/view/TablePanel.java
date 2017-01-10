package view;

import model.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-09.
 */
public class TablePanel extends JInternalFrame {

        private ArrayList<Program> pList;
        private RadioPanel radioPanel;

        public TablePanel(ArrayList<Program> pList){

                super(pList.get(0).getcName(), true, true);
                this.pList = pList;
                this.radioPanel = radioPanel;
                setSize(700,700);
                setLocation(10,10);
                setVisible(true);
                add(createScrollPane());

        /*
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                add(createScrollPane());
                System.out.println("hej");
            }

        },1,10000);
        */
                //setJMenuBar(new ProgramBar());
        }

        private JScrollPane createScrollPane(){

                JScrollPane scrollPane = new JScrollPane(createTable());
                scrollPane.getViewport().getView().addMouseListener(new MouseListener(radioPanel) {
                        @Override
                        public void mouseClicked(MouseEvent e) {

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
                });
                return scrollPane;

        }

        private JTable createTable(){

                String[] columnNames = {"Program namn", "Start tid", "Slut tid"};
                Object[][] data = new String[pList.size()][4];


                for (int i = 0; i < pList.size(); i++){
                        Program programEntry = pList.get(i);
                        data[i][0] = programEntry.getName();
                        data[i][1] = programEntry.getStartTime();
                        data[i][2] = programEntry.getEndTime();


                }

                DefaultTableModel model = new DefaultTableModel(data, columnNames){
                        @Override
                        public boolean isCellEditable(int row, int column){
                                return false;
                        }
                };

                JTable jTable = new JTable(model) {


                        @Override
                        public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                                Component c = super.prepareRenderer(renderer, row, col);
                                Program p = pList.get(row);
                                c.setName(p.getName());

                                if (p.getHasAired()) {
                                        c.setBackground(Color.LIGHT_GRAY);
                                } else {
                                        c.setBackground(Color.white);
                                }

                                return c;
                        }


                };

                return jTable;

        }

}
