/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author kwame
 */
public class Attendance extends javax.swing.JFrame {
    
     String getClass;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    int mousepX;
    int mousepY;
    
    String getAttendance;
    
    private TableModel model;
    
    /**
     * Creates new form Attendance
     */
    public Attendance() {
        initComponents();
        conn = MyConnection.Connect();
        Update_Table();
    }
    
    //CLOSE FORM
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
         Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    //modifying table
    public class CheckBoxWrapperTableModel extends AbstractTableModel{
        
        private final Map<Integer, Boolean> checkBoxes = new HashMap<>();

        public TableModel model;
        private String columnName;

        public CheckBoxWrapperTableModel(TableModel model, String columnName)
        {
            this.model = model;
            this.columnName = columnName;
        }


        @Override
        public String getColumnName(int col)
        {
            return (col > 0) ? model.getColumnName(col - 1) : columnName;
        }

        @Override
        public int getRowCount()
        {
            return model.getRowCount();
        }

        @Override
        public int getColumnCount()
        {
            return model.getColumnCount()+ 1;
        }

        @Override
        public Object getValueAt(int row, int col)
        {
            if (col > 0)
                return model.getValueAt(row, col - 1);
            else
            {
                Object value = checkBoxes.get(row);
                return (value == null) ? Boolean.FALSE : value;
            }
        }

        @Override
        public boolean isCellEditable(int row, int col)
        {
            if (col > 0)
                return model.isCellEditable(row, col - 1);
            else
                return true;
        }

        @Override
        public void setValueAt(Object value, int row, int col)
        {
            if (col > 0)
                model.setValueAt(value, row, col);
            else
                checkBoxes.put(row, (Boolean) value);

            fireTableCellUpdated(row, col);
        }

        @Override
        public Class getColumnClass(int col)
        {
            return (col > 0) ? model.getColumnClass(col - 1) : Boolean.class;
        }
    }
    
    
    // getting value from checkbox

public class CheckBoxModelListener implements TableModelListener {

        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == e.getColumn()) {
                TableModel model = (TableModel) e.getSource();
                String columnName = model.getColumnName(column);
                Boolean checked = (Boolean) model.getValueAt(row, column);
                if (checked) {
                    getAttendance = "Absent";
                    System.out.println(getAttendance);
                } else {
                    getAttendance = "Present";
                    System.out.println(getAttendance);
                }
            }
        }
    }


    // Update table
   private void Update_Table(){
        try{
            String sql ="select Std_Card_Id as 'Student ID', Firstname, Lastname, Gender, Class from students where Class ='"+getClass+"'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //STable.setModel(DbUtils.resultSetToTableModel(rs));
            TableModel utilsModel = DbUtils.resultSetToTableModel(rs);
            TableModel wrapperModel = new CheckBoxWrapperTableModel(utilsModel, "Absent");
            STable.setModel(wrapperModel);
            STable.getModel().addTableModelListener(new CheckBoxModelListener());
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            try{
                rs.close();
                ps.close();
            }
            catch(SQLException ex){
               JOptionPane.showMessageDialog(null,ex.getMessage());
            }           
        }
    
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnback = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboClass = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        STable = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 29, 62));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_test_results_100px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Attendance");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 940, 100));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_school_house_30px.png"))); // NOI18N

        btnback.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnback.setForeground(new java.awt.Color(116, 116, 119));
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_chevron_left_round_30px.png"))); // NOI18N
        btnback.setText("Back");
        btnback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(27, 27, 27)
                .addComponent(btnback)
                .addGap(0, 822, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(btnback))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 30));

        jPanel2.setBackground(new java.awt.Color(251, 251, 251));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Select Class");

        cboClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nursery 1", "Nursery 2", "K.G 1", "K.G 2", "Class 1", "Class 2", "Class 3", "Class 4", "Class 5", "Class 6", "J.H.S 1", "J.H.S 2", "J.H.S 3" }));
        cboClass.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboClassPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        STable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        STable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(STable);
        STable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_save_close_25px.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 940, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //back button
    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        // TODO add your handling code here:
        new Register().setVisible(true);
        close();
    }//GEN-LAST:event_btnbackMouseClicked

    //combo bOX
    private void cboClassPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboClassPopupMenuWillBecomeInvisible
        getClass = cboClass.getSelectedItem().toString();
        
        Update_Table();
    }//GEN-LAST:event_cboClassPopupMenuWillBecomeInvisible

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int cordinateX = evt.getXOnScreen();
        int cordinateY = evt.getYOnScreen();
        
        this.setLocation(cordinateX-mousepX,cordinateY-mousepY);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    //save button
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            int rows = STable.getRowCount();

            for(int row = 0; row<rows; row++)
            {   
                String  Attendance= (String)STable.getValueAt(row, 0).toString();
                String Std_Card_Id = (String) STable.getValueAt(row, 1);
                String Fname = (String)STable.getValueAt(row, 2);
                String Lname = (String)STable.getValueAt(row, 3);
                String Gender = (String)STable.getValueAt(row, 4);
                String Class = (String)STable.getValueAt(row, 5);
                
                if(Attendance.trim().contains("true")){
                    Attendance = "Absent";
                }
                else{
                    Attendance = "Present";
                }
                String sql = "Insert into attendance(Std_Card_Id, Attendance, Firstname, Lastname, Gender, Class) values ('"+Std_Card_Id+"','"+Attendance+"','"+Fname+"','"+Lname+"','"+Gender+"','"+Class+"')";

                ps = conn.prepareStatement(sql);
                ps.execute();     
            }
            JOptionPane.showMessageDialog(null, "You have successfully marked the Attendance for today!!");
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable STable;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel btnback;
    private javax.swing.JComboBox cboClass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
