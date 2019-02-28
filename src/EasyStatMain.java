//  48, 48 IMAGE UPLOAD 

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author UMAR
 */
public class EasyStatMain extends javax.swing.JFrame {

    private Connection connection = null;
    private PreparedStatement pst = null;
    private ResultSet resultSet = null;
    private String filePath = null;

    /**
     * Creates new form EasyStatMain
     */
    public EasyStatMain() throws SQLException {
        initComponents();
        init();
        connection = JavaDbConnect.dbConnect();
        updateStudentInfoTbl();
        updateStdentShrtInfo();
        currentDate();
        updateDoc();

    }

    public void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void close() {
        WindowEvent winClosingEvnt = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvnt);
    }

    private void updateStudentInfoTbl() {
        try {
            String sql = "SELECT Student_id, First_name, Last_name, Department,  "
                    + "Series, Age, Height, Weight, Gender, Blood from STUDENT_INFO ";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            tblStudentInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    private void updateStdentShrtInfo() {
        try {
            String sql = "SELECT Student_id, First_name from STUDENT_INFO";

            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            tblStudentShrtInfo.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    private void updateDoc() {
        try {
            String sql = "SELECT * from Doc_table";

            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            tblDoc.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }

    private void getValue() {
        try {
            txtStudentId.setText(resultSet.getString("Student_ID"));
            txtStudentFirstName.setText(resultSet.getString("FIRST_NAME"));
            txtStudentLastName.setText(resultSet.getString("LAST_NAME"));
            txtStudentDept.setText(resultSet.getString("DEPARTMENT"));
            txtStudentSeries.setText(resultSet.getString("SERIES"));
            txtStudentAge.setText(resultSet.getString("AGE"));
            txtStudentHeight.setText(resultSet.getString("HEIGHT"));
            txtStudentWeight.setText(resultSet.getString("WEIGHT"));
            comboStudentGender.setSelectedItem(resultSet.getString("GENDER"));
            txtStudentBlood.setText(resultSet.getString("BLOOD"));

            //byte[] imageData = resultSet.getBytes("Photo");
            //ImageIcon format = new ImageIcon(scaledImage(imageData, labelImage.getWidth(), labelImage.getHeight()));
            //labelImage.setIcon(format);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(rootPane, e1);
        }
    }

    private void currentDate() {
        //Static Date and Time
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        menuDate.setText("Current Date:" + day + "/" + (month + 1) + "/" + year);
        menuDate.setForeground(Color.blue);

        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        menuTime.setText("Current Time:" + hour + "::" + minute + "::" + second);
        menuTime.setForeground(Color.MAGENTA);
    }
//get screenshot of selecetd components

    private static BufferedImage getScreenShot(Component com) {
        BufferedImage image = new BufferedImage(com.getWidth(), com.getHeight(), BufferedImage.TYPE_INT_RGB);
        com.paint(image.getGraphics());
        return image;

    }

    // save the image of selected component
    private static void saveScreenShot(Component com, String fileName) throws Exception {
        BufferedImage img = getScreenShot(com);
        ImageIO.write(img, "png", new File(fileName));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudentInfo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoc = new javax.swing.JTable();
        txtDocAtch = new javax.swing.JTextField();
        txtDocId = new javax.swing.JTextField();
        txtDocSId = new javax.swing.JTextField();
        txtDocName = new javax.swing.JTextField();
        btnDocAttch = new javax.swing.JButton();
        btnDocAdd = new javax.swing.JButton();
        btnDocDelete = new javax.swing.JButton();
        btnDocClear = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        txtSub = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAMsgBody = new javax.swing.JTextArea();
        txtAttFile = new javax.swing.JTextField();
        btnAttch = new javax.swing.JButton();
        txtAttchNme = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnSndMail = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearchHelp = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        panelStInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStudentLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStudentDept = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStudentFirstName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStudentAge = new javax.swing.JTextField();
        txtStudentHeight = new javax.swing.JTextField();
        txtStudentWeight = new javax.swing.JTextField();
        txtStudentBlood = new javax.swing.JTextField();
        comboStudentGender = new javax.swing.JComboBox<>();
        txtStudentSeries = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudentShrtInfo = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mItClose = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mItOffHelp = new javax.swing.JMenuItem();
        mItWebHelp = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuDate = new javax.swing.JMenu();
        menuTime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton1.setText("  Signout");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Help.png"))); // NOI18N
        btnHelp.setText("Help");
        btnHelp.setFocusable(false);
        btnHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHelp);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Action Panel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tblStudentInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblStudentInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudentInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentInfoMouseClicked(evt);
            }
        });
        tblStudentInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblStudentInfoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudentInfo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 354, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Data Table", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Chart", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Statistics", jPanel4);

        jPanel14.setBackground(new java.awt.Color(0, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocMouseClicked(evt);
            }
        });
        tblDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDocKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblDoc);

        jPanel14.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 11, 712, 151));
        jPanel14.add(txtDocAtch, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 194, -1));
        jPanel14.add(txtDocId, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 64, 112, -1));
        jPanel14.add(txtDocSId, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 107, 112, -1));

        txtDocName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocNameActionPerformed(evt);
            }
        });
        jPanel14.add(txtDocName, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 150, 112, -1));

        btnDocAttch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Attach.png"))); // NOI18N
        btnDocAttch.setText("Attach");
        btnDocAttch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocAttchActionPerformed(evt);
            }
        });
        jPanel14.add(btnDocAttch, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 19, -1, -1));

        btnDocAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnDocAdd.setText("Add");
        btnDocAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocAddActionPerformed(evt);
            }
        });
        jPanel14.add(btnDocAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 62, 85, -1));

        btnDocDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDocDelete.setText("Delete");
        btnDocDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocDeleteActionPerformed(evt);
            }
        });
        jPanel14.add(btnDocDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 105, 85, -1));

        btnDocClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clear.png"))); // NOI18N
        btnDocClear.setText("Clear");
        btnDocClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocClearActionPerformed(evt);
            }
        });
        jPanel14.add(btnDocClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 148, 85, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Doc ID");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 66, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Student ID");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 109, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Doc Name");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 152, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Documents", jPanel5);

        jPanel6.setBackground(new java.awt.Color(51, 255, 255));

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 102));
        jLabel12.setText("FROM");
        jPanel13.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("PASSWORD");
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("TO");
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("SUBJECT");
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 157, -1, -1));
        jPanel13.add(txtFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 21, 174, -1));
        jPanel13.add(txtTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 114, 194, -1));
        jPanel13.add(txtSub, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 152, 194, -1));

        tAMsgBody.setColumns(20);
        tAMsgBody.setRows(5);
        jScrollPane1.setViewportView(tAMsgBody);

        jPanel13.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 12, 375, 170));
        jPanel13.add(txtAttFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 0, 221, -1));

        btnAttch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Attach.png"))); // NOI18N
        btnAttch.setText("ATTACH");
        btnAttch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttchActionPerformed(evt);
            }
        });
        jPanel13.add(btnAttch, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 31, 221, -1));
        jPanel13.add(txtAttchNme, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 67, 221, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("ATTACHMENT NAME");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 98, 221, -1));

        btnSndMail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSndMail.setForeground(new java.awt.Color(0, 0, 153));
        btnSndMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mail.png"))); // NOI18N
        btnSndMail.setText("SEND");
        btnSndMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSndMailActionPerformed(evt);
            }
        });
        jPanel13.add(btnSndMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 124, 221, 48));
        jPanel13.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 67, 174, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Email", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 255)));

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 153));
        jLabel11.setText("WELCOME TO UMARSOFTWARE");

        txtSearch.setText("Search...");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnSearchHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        btnSearchHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHelpActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), new java.awt.Color(51, 255, 51))); // NOI18N

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit-icon.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(btnSearchHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        panelStInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "StudentInfo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 14), new java.awt.Color(51, 0, 153))); // NOI18N

        jLabel1.setText("  STUDENT ID  ");

        jLabel2.setText("  DEPARTMENT");

        jLabel3.setText("  LAST NAME");

        jLabel4.setText("  SERIES");

        jLabel5.setText("  FIRST NAME  ");

        jLabel6.setText("  BLOOD");

        jLabel7.setText("  GENDER");

        jLabel8.setText("  WEIGHT");

        jLabel9.setText("  HEIGHT");

        jLabel10.setText("  AGE");

        comboStudentGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", " " }));

        javax.swing.GroupLayout panelStInfoLayout = new javax.swing.GroupLayout(panelStInfo);
        panelStInfo.setLayout(panelStInfoLayout);
        panelStInfoLayout.setHorizontalGroup(
            panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStInfoLayout.createSequentialGroup()
                .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentSeries))
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentDept))
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentLastName))
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentFirstName))
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtStudentBlood))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboStudentGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentWeight))
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentHeight))
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentAge, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelStInfoLayout.setVerticalGroup(
            panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStudentAge, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelStInfoLayout.createSequentialGroup()
                        .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtStudentDept, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboStudentGender, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelStInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStudentSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblStudentShrtInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblStudentShrtInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudentShrtInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentShrtInfoMouseClicked(evt);
            }
        });
        tblStudentShrtInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblStudentShrtInfoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblStudentShrtInfo);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setText("jTextField1");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Attach.png"))); // NOI18N
        jButton2.setText("Upload");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        jButton3.setText("Save");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("  File  ");

        mItClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mItClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        mItClose.setText("Close");
        mItClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItCloseActionPerformed(evt);
            }
        });
        jMenu1.add(mItClose);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        jMenuItem1.setText(" EXit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("  Edit  ");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/snip.png"))); // NOI18N
        jMenuItem2.setText("Snip");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("  Help  ");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        mItOffHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mItOffHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Help.png"))); // NOI18N
        mItOffHelp.setText("Offline Help");
        mItOffHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItOffHelpActionPerformed(evt);
            }
        });
        jMenu3.add(mItOffHelp);

        mItWebHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        mItWebHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/webHelp.png"))); // NOI18N
        mItWebHelp.setText("Web Help");
        mItWebHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItWebHelpActionPerformed(evt);
            }
        });
        jMenu3.add(mItWebHelp);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("  About  ");
        jMenuBar1.add(jMenu4);

        menuDate.setText("  Date  ");
        jMenuBar1.add(menuDate);

        menuTime.setText("  Time  ");
        jMenuBar1.add(menuTime);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelStInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelStInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItCloseActionPerformed
        // TODO add your handling code here:

        try {
            close();
            LogIn obj = new LogIn();
            obj.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);

        } finally {
            try {
                resultSet.close();
                pst.close();
                connection.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex);

            }

        }
    }//GEN-LAST:event_mItCloseActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            close();
            LogIn obj = new LogIn();
            obj.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);

        } finally {
            try {
                //resultSet.close();
                //pst.close();
                connection.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex);

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblStudentShrtInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentShrtInfoMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblStudentShrtInfo.getSelectedRow();
            String tableClick = (tblStudentShrtInfo.getModel().getValueAt(row, 0).toString());
            String sql = "select * from STUDENT_INFO where Student_ID = '" + tableClick + "'  ";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                getValue();

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }//GEN-LAST:event_tblStudentShrtInfoMouseClicked

    private void tblStudentShrtInfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStudentShrtInfoKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            try {
                int row = tblStudentShrtInfo.getSelectedRow();
                String tableClick = (tblStudentShrtInfo.getModel().getValueAt(row, 0).toString());
                String sql = "select * from STUDENT_INFO where Student_ID = '" + tableClick + "'  ";
                pst = connection.prepareStatement(sql);
                resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    getValue();

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_tblStudentShrtInfoKeyReleased

    private void tblStudentInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentInfoMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblStudentInfo.getSelectedRow();
            String tableClick = (tblStudentInfo.getModel().getValueAt(row, 0).toString());
            String sql = "select * from STUDENT_INFO where Student_ID = '" + tableClick + "'  ";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                getValue();

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }

    }//GEN-LAST:event_tblStudentInfoMouseClicked

    private void tblStudentInfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStudentInfoKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            try {
                int row = tblStudentInfo.getSelectedRow();
                String tableClick = (tblStudentInfo.getModel().getValueAt(row, 0).toString());
                String sql = "select * from STUDENT_INFO where Student_ID = '" + tableClick + "'  ";
                pst = connection.prepareStatement(sql);
                resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    getValue();

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }

    }//GEN-LAST:event_tblStudentInfoKeyReleased

    private void mItOffHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItOffHelpActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Files\\HELP.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error Opening File..!!!!");
        }
    }//GEN-LAST:event_mItOffHelpActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:

        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Files\\HELP.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error Opening File..!!!!");
        }
    }//GEN-LAST:event_btnHelpActionPerformed

    private void mItWebHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItWebHelpActionPerformed
        try {
            // TODO add your handling code here:
            String url = "http://www.zuneecabs.com/English.html";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_mItWebHelpActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String sql = "select * from Student_info where First_Name=? ";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtSearch.getText());
            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                getValue();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex);

        }

        String sql1 = "select * from Student_info where Student_ID=? ";
        try {
            pst = connection.prepareStatement(sql1);
            pst.setString(1, txtSearch.getText());
            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                getValue();

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex);

        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtStudentId.setText(null);
        txtStudentFirstName.setText(null);
        txtStudentLastName.setText(null);
        txtStudentDept.setText(null);
        txtStudentSeries.setText(null);
        txtStudentAge.setText(null);
        txtStudentHeight.setText(null);
        txtStudentWeight.setText(null);
        comboStudentGender.setSelectedItem("FEMALE");
        txtStudentBlood.setText(null);


    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHelpActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Files\\HELP.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error Opening File..!!!!");
        }
    }//GEN-LAST:event_btnSearchHelpActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String sql = "insert into Student_Info(Student_ID, First_Name, Last_Name, Department,"
                + "Series,Age,Height, Weight,Gender,Blood) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtStudentId.getText());
            pst.setString(2, txtStudentFirstName.getText());
            pst.setString(3, txtStudentLastName.getText());
            pst.setString(4, txtStudentDept.getText());
            pst.setString(5, txtStudentSeries.getText());
            pst.setString(6, txtStudentAge.getText());
            pst.setString(7, txtStudentHeight.getText());
            pst.setString(8, txtStudentWeight.getText());
            pst.setString(9, (String) comboStudentGender.getSelectedItem());
            pst.setString(10, txtStudentBlood.getText());

            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Saved");

        } catch (Exception e3) {
            JOptionPane.showMessageDialog(rootPane, e3);
        }

        updateStudentInfoTbl();
        updateStdentShrtInfo();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:

        String sql = "UPDATE STUDENT_INFO SET First_Name=?, Last_Name=?, Department=?,"
                + "Series=?,Age=?,Height=?, Weight=?,Gender=?,Blood=? where Student_ID=?";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, txtStudentFirstName.getText());
            pst.setString(2, txtStudentLastName.getText());
            pst.setString(3, txtStudentDept.getText());
            pst.setString(4, txtStudentSeries.getText());
            pst.setString(5, txtStudentAge.getText());
            pst.setString(6, txtStudentHeight.getText());
            pst.setString(7, txtStudentWeight.getText());
            pst.setString(8, (String) comboStudentGender.getSelectedItem());
            pst.setString(9, txtStudentBlood.getText());

            pst.setString(10, txtStudentId.getText());

            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Updated");

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(rootPane, e2);
        }

        updateStudentInfoTbl();
        updateStdentShrtInfo();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        int p = JOptionPane.showConfirmDialog(rootPane, "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "Delete from Student_Info where Student_id=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, txtStudentId.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted");

            } catch (Exception e4) {
                JOptionPane.showMessageDialog(rootPane, e4);
            }
            updateStudentInfoTbl();
            updateStdentShrtInfo();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        try {
            saveScreenShot(panelStInfo, "Panel Img.png");
            JOptionPane.showMessageDialog(rootPane, "Image is Captured");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnSndMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSndMailActionPerformed
        // TODO add your handling code here:
        final String From = txtFrom.getText();
        final String password = txtPassword.getText();

        String To = txtTo.getText();
        
        String Subject = txtSub.getText();
        String txtMesage = tAMsgBody.getText();

        Properties pros = new Properties();
        pros.put("mail.smtp.host", "smtp.gmail.com");
        pros.put("mail.smtp.socketFactory.port", "587"); //SSL protocol port no. is 465
        pros.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.enable", "true");
        pros.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(pros, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(From, password);
            }
        });
        try {
            //message header

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(From));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);

            //code for set the text message
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(txtMesage);
            Multipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(messageBodyPart);
            //code for attach file

            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(txtAttchNme.getText());
            multiPart.addBodyPart(messageBodyPart);

            message.setContent(multiPart);
            Transport.send(message);

            JOptionPane.showMessageDialog(rootPane, "Message is Sent");

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } catch (MessagingException ex) {
            Logger.getLogger(EasyStatMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSndMailActionPerformed

    private void btnAttchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttchActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(rootPane);

        File f = chooser.getSelectedFile();
        filePath = f.getAbsolutePath();
        txtAttFile.setText(filePath);
        txtAttchNme.setText(filePath);
    }//GEN-LAST:event_btnAttchActionPerformed

    private void tblDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblDoc.getSelectedRow();
            String tableClick = (tblDoc.getModel().getValueAt(row, 0).toString());
            String sql = "select * from Doc_table where Doc_ID = '" + tableClick + "'  ";
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                txtDocId.setText(resultSet.getString("Doc_ID"));
                txtDocSId.setText(resultSet.getString("Student_ID"));
                txtDocName.setText(resultSet.getString("Doc_name"));
                txtDocAtch.setText(resultSet.getString("Path"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        try {
            int row = tblDoc.getSelectedRow();
            String tableClick = (tblDoc.getModel().getValueAt(row, 3).toString());
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + tableClick);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_tblDocMouseClicked

    private void tblDocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDocKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            try {
                int row = tblStudentShrtInfo.getSelectedRow();
                String tableClick = (tblStudentShrtInfo.getModel().getValueAt(row, 0).toString());
                String sql = "select * from STUDENT_INFO where Student_ID = '" + tableClick + "'  ";
                pst = connection.prepareStatement(sql);
                resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    getValue();

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_tblDocKeyReleased

    private void txtDocNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocNameActionPerformed

    private void btnDocAttchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocAttchActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(rootPane);

        File f = chooser.getSelectedFile();
        String fileDocPath = f.getAbsolutePath();
        txtDocAtch.setText(fileDocPath);

    }//GEN-LAST:event_btnDocAttchActionPerformed

    private void btnDocAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocAddActionPerformed
        // TODO add your handling code here:

        String sql = "insert into Doc_table(Doc_ID,Student_ID, Doc_name, Path)"
                + "values(?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txtDocId.getText());
            pst.setString(2, txtDocSId.getText());
            pst.setString(3, txtDocName.getText());
            pst.setString(4, txtDocAtch.getText());

            pst.execute();

            JOptionPane.showMessageDialog(rootPane, "Saved");

        } catch (Exception e3) {
            JOptionPane.showMessageDialog(rootPane, e3);
        }

        updateDoc();
    }//GEN-LAST:event_btnDocAddActionPerformed

    private void btnDocDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocDeleteActionPerformed
        // TODO add your handling code here:
        
        int p = JOptionPane.showConfirmDialog(rootPane, "Do you really want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "Delete from Doc_table where Doc_id=?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, txtDocId.getText());
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Deleted");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
            updateDoc();
        }
    }//GEN-LAST:event_btnDocDeleteActionPerformed

    private void btnDocClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocClearActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
        txtDocId.setText(null);
        txtDocName.setText(null);
        txtDocSId.setText(null);
        txtDocAtch.setText(null);
        
    }//GEN-LAST:event_btnDocClearActionPerformed
    /**/
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EasyStatMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EasyStatMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EasyStatMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EasyStatMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new EasyStatMain().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(EasyStatMain.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAttch;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDocAdd;
    private javax.swing.JButton btnDocAttch;
    private javax.swing.JButton btnDocClear;
    private javax.swing.JButton btnDocDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnSearchHelp;
    private javax.swing.JButton btnSndMail;
    private javax.swing.JComboBox<String> comboStudentGender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JMenuItem mItClose;
    private javax.swing.JMenuItem mItOffHelp;
    private javax.swing.JMenuItem mItWebHelp;
    private javax.swing.JMenu menuDate;
    private javax.swing.JMenu menuTime;
    private javax.swing.JPanel panelStInfo;
    private javax.swing.JTextArea tAMsgBody;
    private javax.swing.JTable tblDoc;
    private javax.swing.JTable tblStudentInfo;
    private javax.swing.JTable tblStudentShrtInfo;
    private javax.swing.JTextField txtAttFile;
    private javax.swing.JTextField txtAttchNme;
    private javax.swing.JTextField txtDocAtch;
    private javax.swing.JTextField txtDocId;
    private javax.swing.JTextField txtDocName;
    private javax.swing.JTextField txtDocSId;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStudentAge;
    private javax.swing.JTextField txtStudentBlood;
    private javax.swing.JTextField txtStudentDept;
    private javax.swing.JTextField txtStudentFirstName;
    private javax.swing.JTextField txtStudentHeight;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentLastName;
    private javax.swing.JTextField txtStudentSeries;
    private javax.swing.JTextField txtStudentWeight;
    private javax.swing.JTextField txtSub;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
