/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package remote.desktopview;

import chat.ChatInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import remote.desktop.IRemoteDesktop;
import view.ChatClientView;
import view.WelcomeView;

/**
 * Cliente del RMI que busca especificamente el acesso al objeto remoto IRemotDesktop del servidor para enviarlo a la vista DesktopView
 * @author Usuario
 */
public class DesktopClient {
    private IRemoteDesktop desktopClient;
    public DesktopClient(String IpNumber, int port) {
        
        // TODO add your handling code here:
        //this.setVisible(false);
        //String IpNumber = "localhost";
        try {        
            Registry registry = LocateRegistry.getRegistry(IpNumber, port);
            desktopClient = (IRemoteDesktop)registry.lookup("desktopServer");  //getting a remote reference       
            System.out.println("Conectado a Servidor");

        } catch (Exception e) {
           //this.setVisible(true);
          // this.ErrorMessage.setText("Error de conexion");
           e.printStackTrace();
        }        
        SwingUtilities.invokeLater
        (() -> {
            JFrame frame = new JFrame();
            
            DesktopView desktopView = new DesktopView(desktopClient, frame);
            //JPanel serverView = new ServerView(frame);            
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(desktopView);
            //DesktopView.run();
           
            //frame.setResizable(false);
            
            //frame.getContentPane().add(serverView);
            //frame.getContentPane().add(serverView, "serverView");
            frame.setSize(1500,900);
            //frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
            desktopView.setFrameSize();
            
        });
    }  
}
