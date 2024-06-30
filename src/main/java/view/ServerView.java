/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import chat.ChatInterface;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Enumeration;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import server.RMIServer;
import server.TCPServer;

/**
 *  La vista del Servidor
 * @author Usuario
 */
public class ServerView extends javax.swing.JPanel {
    JFrame frame;
    RMIServer Rmiserver;
    TCPServer TcpServer;
    /**
     * Crear nueva forma ServerView y inicializa los servidores.
     * @param frame: Recibe el framde en donde se creo.
     */
    
    public ServerView(JFrame frame) {
        TcpServer = new TCPServer();
        Rmiserver = new RMIServer();
        
        frame.setSize(300, 400);
        this.frame = frame;
        initComponents();
        this.setVisible(true);
        this.setSize(600,400);
        this.getServerIp();
        this.jButton1.setEnabled(false);
        
        //server.run(Status);
        
    }
    /**
     * Crear nueva forma ServerView
     * @param frame: Recibe el framde en donde se creo.
     * @param server: Recibe el servidor activo
     */
    public ServerView(JFrame frame, RMIServer server) {
        frame.setSize(300, 400);
        this.frame = frame;
        initComponents();
        this.Rmiserver = server;
        
        this.setVisible(true);        
        this.setSize(600,400);
        //server.run(Status);
        //this.getServerIp();
    }
    public void getServerIp(){
        String ip;
        ipListComboText.removeAllItems();
        
        try {
            Vector<String> ipv4_addresses = TcpServer.getAllIpv4AddressesOnLocal();
            for(String ipv4 : ipv4_addresses) {
                this.ipListComboText.addItem(ipv4);
            }
        } catch (SocketException ex) {
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
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
        Status = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        portTextField = new javax.swing.JTextField();
        ipListComboText = new javax.swing.JComboBox<>();
        startServerButton = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Status.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Status.setForeground(new java.awt.Color(255, 255, 255));
        Status.setText("Sin Iniciar");
        jPanel1.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ESTADO DE SERVIDOR:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 31, -1, -1));

        jButton1.setText("Entrar al Chat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, 20));

        portTextField.setText("2000");
        portTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(portTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 110, -1));

        ipListComboText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(ipListComboText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        startServerButton.setText("Encender Servidor");
        startServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(startServerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        Password.setText("jPasswordField1");
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jLabel3.setText("Puerto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {        
            Registry registry = LocateRegistry.getRegistry(Integer.parseInt(this.portTextField.getText()));
            ChatInterface chat = (ChatInterface)registry.lookup("chatServer");  //getting a remote reference       
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new ChatClientView(frame,chat,"Servidor", Rmiserver));
        } catch (Exception e) {
           e.printStackTrace();
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void portTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portTextFieldActionPerformed

    private void startServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerButtonActionPerformed
        
        Rmiserver.run(this.Status,this.portTextField.getText());        // TODO add your handling code here:
        String selectedItem = this.ipListComboText.getSelectedItem().toString();
        int port = Integer.parseInt(portTextField.getText());
        System.out.println(selectedItem);
        String passwordString =  new String(this.Password.getPassword());
        try {
            this.TcpServer.startListeningOnTcpServer(selectedItem, port, passwordString );
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(() -> {
            while (!this.TcpServer.getis_has_partner())
                try {
                    this.TcpServer.waitingConnectionFromClient();
                } catch (IOException ex) {
                    Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
                }
        }).start();
        //this.ipListComboText.getSelectedItem().toString().trim(),
        this.startServerButton.setEnabled(false);
        this.jButton1.setEnabled(true);
    }//GEN-LAST:event_startServerButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel Status;
    private javax.swing.JComboBox<String> ipListComboText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton startServerButton;
    // End of variables declaration//GEN-END:variables
}
