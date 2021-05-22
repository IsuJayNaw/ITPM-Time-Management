/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.timetablemanagement.main;



import allocateTime_modifySessions.addConsecutiveSession;
import allocateTime_modifySessions.addDetails_allocationTime_Home;
import allocateTime_modifySessions.addParallelSessions;


import com.itpm.timetablemanagement.form.student_details.addDetails_Home;
import com.itpm.timetablemanagement.form.student_details.groupId_generate;
import com.itpm.timetablemanagement.form.student_details.sub_GroupId_generate;
import com.itpm.timetablemanagement.form.student_details.view_All_Details;




import com.itpm.timetablemanagement.form.session.AddSession;
import com.itpm.timetablemanagement.form.session.ViewSession;




import com.itpm.timetablemanagement.form.tag_details.enterTag;
import com.itpm.timetablemanagement.home.SplashScreen;



import com.itpm.timetablemanagement.util.DBconnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import com.itpm.timetablemanagement.menu.MenuItem;

/**
 *
 * @author Tiran Harsha
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        this.setExtendedState(MAXIMIZED_BOTH);
        execute();
        
    }

    private void execute(){
       
        ImageIcon iconWorkingDay = null;
        ImageIcon iconSubmenu = null;
        try{
         iconWorkingDay = new ImageIcon(MainFrame.class.getResource("workingTime.png"));
         iconSubmenu = new javax.swing.ImageIcon(getClass().getResource("/com/spm/timetablemanagement/resource/426430-PE93QI-643.jpg"));
        }catch(Exception e){
           
        }
        
        //ID generates sub items
        MenuItem s1IDGenerate = new MenuItem(iconSubmenu, "Group ID", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelBody.removeAll();
               panelBody.add(new groupId_generate());
               panelBody.repaint();
               panelBody.revalidate();
            }
        });
        MenuItem s2IDGenerate = new MenuItem(iconSubmenu, "Sub-Group ID", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelBody.removeAll();
               panelBody.add(new sub_GroupId_generate());
               panelBody.repaint();
               panelBody.revalidate();
            }
        });
        


        
        //Student submenu items
        MenuItem s1Student = new MenuItem(iconSubmenu, "Add Student Details", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelBody.removeAll();
               panelBody.add(new addDetails_Home());
               panelBody.repaint();
               panelBody.revalidate();
            }
        });
        MenuItem s2Student = new MenuItem(iconSubmenu, "ID Generates", null, s1IDGenerate, s2IDGenerate);
        
        MenuItem s3Student = new MenuItem(iconSubmenu, "View Student Details", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelBody.removeAll();
               panelBody.add(new view_All_Details());
               panelBody.repaint();
               panelBody.revalidate();
            }
        });
            
        

        
        //Tag submenu items Statistics
        MenuItem s1Tag = new MenuItem(iconSubmenu, "Add Tag Details", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelBody.removeAll();
               panelBody.add(new enterTag());
               panelBody.repaint();
               panelBody.revalidate();
            }
        });
        


        
        //Handle Session submenu items
        MenuItem s1HandleSession = new MenuItem(iconSubmenu, "Create Sessions", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new AddSession());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem s2HandleSession = new MenuItem(iconSubmenu, "View Sessions",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new ViewSession());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
//        MenuItem s3HandleSession = new MenuItem(iconSubmenu, "Search Sessions", null);
        
        //Allocate Time Session submenu items
        MenuItem s1AllocateTime = new MenuItem(iconSubmenu, "Allocate Not Available Time", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelBody.removeAll();
               panelBody.add(new addDetails_allocationTime_Home());
               panelBody.repaint();
               panelBody.revalidate();
            }
        });
        MenuItem s2AllocateTime = new MenuItem(iconSubmenu, "Consective Sessions", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelBody.removeAll();
               panelBody.add(new addConsecutiveSession());
               panelBody.repaint();
               panelBody.revalidate();
            }
        });
        MenuItem s3AllocateTime = new MenuItem(iconSubmenu, "Parallel Sessions", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelBody.removeAll();
               panelBody.add(new addParallelSessions());
               panelBody.repaint();
               panelBody.revalidate();
            }
        });
        

        MenuItem s2GenerateTimeTable = new MenuItem(iconSubmenu, "View Time Table", null);
        

        MenuItem menuStudent = new MenuItem(iconWorkingDay, "Student", null, s1Student, s2Student, s3Student);

    
        MenuItem menuTag = new MenuItem(iconSubmenu, "Tag", null, s1Tag);
     
        MenuItem menuCreateSession = new MenuItem(iconSubmenu, "Handle Session", null, s1HandleSession, 
                s2HandleSession);
        MenuItem menuAllTime = new MenuItem(iconSubmenu, "Allocate Time and Modify Sessions", null, s1AllocateTime,
                s2AllocateTime, s3AllocateTime);
//        MenuItem menuView = new MenuItem(iconSubmenu, "View Details", null);
    
        
        
        
        addMenu(menuStudent, menuTag, menuCreateSession, menuAllTime);
    }
    
    private void addMenu(MenuItem... menu){
        
        ArrayList<MenuItem> subMenu = new ArrayList();
        
        for(int i = 0; i < menu.length; i++){
            
            menus.add(menu[i]);
            
            subMenu = menu[i].getSubMenu();
            
            for(int j = 0; j < subMenu.size(); j++){
                addMenu(subMenu.get(j));
                
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

        panelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ABC Institute");

        panelHeader.setBackground(new java.awt.Color(13, 125, 231));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ABC Institute");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Time Table Management System");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setPreferredSize(new java.awt.Dimension(250, 413));
        panelMenu.setRequestFocusEnabled(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(255, 255, 255));
        panelBody.setLayout(new java.awt.BorderLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spm/timetablemanagement/resource/426430-PE93QI-643.jpg"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel3.setMinimumSize(new java.awt.Dimension(500, 500));
        jLabel3.setPreferredSize(new java.awt.Dimension(500, 500));
        panelBody.add(jLabel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 813, 535);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SplashScreen screen = new SplashScreen();
        screen.setVisible(true);
     
        try {
            for(int i =0;i<=100;i++){
                Thread.sleep(20);
                screen.prg_bar.setValue(i);
            }
        } catch (Exception e) {
            
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                screen.setVisible(false);
                new MainFrame().setVisible(true);
            }
        });
        
        try {
            DBconnection.getConnection();
            
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null , "Cannot configure database", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    public javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
