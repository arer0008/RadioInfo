package view;

import model.Program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by c15aen on 2017-01-09.
 */
public class TableFrame {

        private JFrame programWindow = new JFrame();
        private ArrayList<Program> programs;
        private JTable jTable = new JTable();

        public TableFrame(ArrayList<Program> pList){

                programs = pList;

                jTable = createTable();

                programWindow.setSize(new Dimension(600,600));
                programWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


                JScrollPane jScrollPane = new JScrollPane(jTable);


                programWindow.add(jScrollPane);

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
        public void show() {

                programWindow.setVisible(true);
        }

        public void setTitle(String s) {
                programWindow.setTitle(s);
        }



        public JTable createTable(){

                Object[] columnNames = {"Program namn", "Start tid", "Slut tid"};
                Object[][] data = new String[programs.size()][3];


                for (int i = 0; i < programs.size(); i++){

                        Program p = programs.get(i);
                        System.out.println(p.getTitle());
                        data[i][0] = p.getTitle();
                        data[i][1] = p.getStartTime();
                        data[i][2] = p.getEndTime();



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
                                Program p = programs.get(row);
                                c.setName(p.getTitle());

                                if (p.hasAired()) {
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
