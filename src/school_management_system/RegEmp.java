/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_system;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Kwame
 */
public class RegEmp extends javax.swing.JFrame {

    String EmpNo;
    
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    /**
     * Creates new form RegEmp
     */
    public RegEmp() {
        initComponents();
        conn = MyConnection.Connect();
        getEmpNoCount();
        getEmpId();
        dis_date();
    }
    private String Gender;
    
    String imgPath = null;
    
    int mousepX;
    int mousepY;
    
    //CLOSE FORM
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
         Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    //resize image
    private ImageIcon ResizeImage(String ImagePath, byte[] pic){
        
        ImageIcon MyImage = null;
        if(ImagePath != null){
            MyImage = new ImageIcon(ImagePath);
        }
        else{
            MyImage = new ImageIcon(pic);
        }
        //get and scale image
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        
        return image;
    }
    
    //get number of Employees + 1
    private void getEmpNoCount(){
        try{
            String sql = "select count(Emp_Id) from employees";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if(rs.next()){
                int get = rs.getInt("count(Emp_Id)");
                if(get == 0){
                get = get + 1;
                }
                else{
                get = get + 1;
                }
                EmpNo = String.valueOf(get);
                txtEmployeeNo.setText(" " + EmpNo);
            }

        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            try{
                rs.close();
                ps.close();
            }
            catch(SQLException exc){
               JOptionPane.showMessageDialog(null,exc.getMessage());
            }
        }
    }
        
    //get last emp number + 1
    private void getEmpId(){
        try{
            String sql = "select max(Emp_Id) from employees";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        
            if(rs.next()){
                int getId = rs.getInt("max(Emp_Id)");
                if(getId == 0){
                getId = getId + 1;
                }
                else{
                getId = getId + 1;
                }
                String EmpId = String.valueOf(getId);
                txtEmployeeId.setText(" EMP000" + EmpId);
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            try{
                rs.close();
                ps.close();
            }
            catch(SQLException exc){
               JOptionPane.showMessageDialog(null,exc.getMessage());
            }
        }
    }

    
    private void dis_date(){
        Calendar cal = new GregorianCalendar();
        
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
       txtDOE.setText( day + "-" + (month + 1) + "-" + year );
        
        Timer t;
        t = new Timer(1000, new RegEmp.Listener());
        t.start();
        
    }
    
    
    class Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
            
               Calendar rightnow = Calendar.getInstance();
               rightnow.getTime();
               //int second = rightnow.get(Calendar.SECOND);
               //int minute = rightnow.get(Calendar.MINUTE);
              //int hour = rightnow.get(Calendar.HOUR_OF_DAY);
                //int tm = rightnow.get(Calendar.);
               //lblCurrentTime.setText(hour + ":" + minute + ":" + second);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        lblPic = new javax.swing.JLabel();
        btnAddPhoto = new javax.swing.JButton();
        txtLastname = new javax.swing.JTextField();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        txtPhone = new javax.swing.JTextField();
        txtDOB = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboQualification = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtEmployedAs = new javax.swing.JTextField();
        txtEmployeeId = new javax.swing.JLabel();
        txtEmployeeNo = new javax.swing.JLabel();
        txtDOE = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(940, 710));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(940, 710));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 29, 62));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_add_administrator_filled_100px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Add new Employee");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 940, 100));

        jPanel2.setBackground(new java.awt.Color(251, 251, 251));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Employee ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 33, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Firstname");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Lastname");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 167, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Gender");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 301, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Date of birth");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 234, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Phone No.");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 366, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 299, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Employee No.");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 33, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Address");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 366, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Picture");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 33, -1, -1));

        txtFirstname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 126, 241, 30));

        lblPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 38, 160, 136));

        btnAddPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_pictures_folder_25px.png"))); // NOI18N
        btnAddPhoto.setText("Add Photo");
        btnAddPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhotoActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 130, -1));

        txtLastname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 193, 241, 30));

        rdbMale.setText("Male");
        rdbMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMaleActionPerformed(evt);
            }
        });
        jPanel2.add(rdbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 328, -1, -1));

        rdbFemale.setText("Female");
        rdbFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFemaleActionPerformed(evt);
            }
        });
        jPanel2.add(rdbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 328, -1, -1));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 392, 241, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 325, 228, 30));

        btnSave.setBackground(new java.awt.Color(0, 255, 0));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_save_close_25px.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 460, 98, 35));

        btnHome.setBackground(new java.awt.Color(0, 51, 204));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_home_25px_1.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel2.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 460, 104, 35));

        btnNew.setBackground(new java.awt.Color(255, 153, 51));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/school_management_system/Images/icons8_add_25px_1.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel2.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 460, 92, 35));

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 392, 228, 30));

        txtDOB.setDateFormatString("yyy-MM-d");
        jPanel2.add(txtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 260, 241, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Employed as");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 167, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Qualification");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 234, -1, -1));

        cboQualification.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "W.A.S.S.C.E", "Diploma", "HND", "Degree", "PHD", "Other" }));
        jPanel2.add(cboQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 258, 228, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Date of Employment");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 100, -1, -1));

        txtEmployedAs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtEmployedAs, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 193, 228, 30));

        txtEmployeeId.setBackground(new java.awt.Color(251, 251, 251));
        txtEmployeeId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtEmployeeId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(txtEmployeeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 59, 241, 30));

        txtEmployeeNo.setBackground(new java.awt.Color(251, 251, 251));
        txtEmployeeNo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtEmployeeNo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(txtEmployeeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 59, 228, 30));

        txtDOE.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDOE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(txtDOE, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 126, 228, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 940, 530));

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    //Home button
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new MainS().setVisible(true);
        close();
    }//GEN-LAST:event_btnHomeActionPerformed

    
    //Back button
    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        // TODO add your handling code here:
        new Register().setVisible(true);
        close();
    }//GEN-LAST:event_btnbackMouseClicked

    //ATTACH PICTURE
    private void btnAddPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhotoActionPerformed
        //browse image
        JFileChooser choser = new JFileChooser();
        choser.setCurrentDirectory(new File(System.getProperty("user.home")));
        ///filter the files for images
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png");
        choser.addChoosableFileFilter(filter);
        int result = choser.showOpenDialog(null);
        // if the user clicks open button
        if(result == JFileChooser.APPROVE_OPTION){
            File sf = choser.getSelectedFile();
            String path = sf.getAbsolutePath();
            lblPic.setIcon(ResizeImage(path,null));
            
            imgPath = path;
        }
    }//GEN-LAST:event_btnAddPhotoActionPerformed

    //SAVE
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
           
       if(txtEmployeeNo.getText().trim().isEmpty() || txtFirstname.getText().trim().isEmpty() || txtLastname.getText().trim().isEmpty() || txtAddress.getText().trim().isEmpty() || txtPhone.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty() || txtDOB.getDate().toString().trim().isEmpty() || txtDOE.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill in the details");
        }
        else

        if(imgPath != null)
        {
            try{
                String sql = "insert into employees(Emp_No,Emp_Card_No,Firstname,Lastname,DOB,Gender,Address,DOE,Role,Email,Phone,Picture,Qualification) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                ps=conn.prepareStatement(sql);
                //ps.setString(1, txtEmployeeId.getText());
                ps.setString(1, txtEmployeeNo.getText());
                ps.setString(2, txtEmployeeId.getText());
                ps.setString(3, txtFirstname.getText());
                ps.setString(4, txtLastname.getText());
                ps.setString(5,  ((JTextField)txtDOB.getDateEditor().getUiComponent()).getText());
                ps.setString(6, Gender);
                ps.setString(7, txtAddress.getText());
                ps.setString(8, txtDOE.getText());
                ps.setString(9, txtEmployedAs.getText());
                ps.setString(10, txtEmail.getText());
                ps.setString(11, txtPhone.getText());

                String quali = cboQualification.getSelectedItem().toString();

                try {
                    InputStream img = new FileInputStream(new File(imgPath));
                    ps.setBlob(12, img);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RegEmp.class.getName()).log(Level.SEVERE, null, ex);
                }
                ps.setString(13, quali);

                ps.execute();

                JOptionPane.showMessageDialog(null, "Items Saved successfully!!");
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            finally{
                try{
                    rs.close();
                    ps.close();
                }
                catch(SQLException exc){
                   JOptionPane.showMessageDialog(null,exc.getMessage());
                }
            }

        }
        //JOptionPane.showMessageDialog(null, "Items Saved successfully!!");
        else{
            JOptionPane.showMessageDialog(null, "Item was not saved!!!");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    
    //gender
    private void rdbFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFemaleActionPerformed
        Gender = "female";
    }//GEN-LAST:event_rdbFemaleActionPerformed

    private void rdbMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMaleActionPerformed
        Gender = "Male";
    }//GEN-LAST:event_rdbMaleActionPerformed

    //clear/New button
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtFirstname.setText("");
        txtLastname.setText("");
        txtAddress.setText("");
        txtEmployeeNo.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtEmployedAs.setText("");
        lblPic.setIcon(null);
    }//GEN-LAST:event_btnNewActionPerformed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int cordinateX = evt.getXOnScreen();
        int cordinateY = evt.getYOnScreen();
        
        this.setLocation(cordinateX-mousepX,cordinateY-mousepY);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

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
            java.util.logging.Logger.getLogger(RegEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegEmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPhoto;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel btnback;
    private javax.swing.JComboBox cboQualification;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblPic;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTextField txtAddress;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JLabel txtDOE;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployedAs;
    private javax.swing.JLabel txtEmployeeId;
    private javax.swing.JLabel txtEmployeeNo;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
