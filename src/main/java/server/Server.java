/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author Usuario
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import remote.desktop.IRemoteDesktopImpl;
import chat.ChatImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.*;  

import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author vijani
 */
public class Server {
    /**
     * @param args the command line arguments
     */
    public Server(){

    }

    public static void run(JLabel status) {
        /*          
        
        Runtime.getRuntime().exec("rmiregistry 2020");
        
        LocateRegistry.createRegistry(2020);

        try{  
            Adder stub=new AdderRemote();  
            Naming.rebind("rmi://localhost:2020/2020",stub);  
        }catch(Exception e){System.out.println(e);}  
        */
        try {
            System.out.println("comenzando Servidor");
            status.setText("starting Server");
            Runtime.getRuntime().exec("rmiregistry 2000");
            Registry registry = LocateRegistry.createRegistry(2000);

            
            registry.rebind("chatServer", new ChatImpl()); //creates the remote object and registers it
            registry.rebind("desktopServer", new IRemoteDesktopImpl());
            
            status.setText("Servidor comenzado");
            System.out.println("Server Started");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}