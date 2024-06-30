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
 * @author Jose
 * 
* Este el servidor RMI de Java, aqui se llevaran todo las interfaces que use RMI aqui.
* por defecto se usara el port 20000 de llamarse el constructor por si solo.
     
 */
public class RMIServer {
    private String port;
    private String ip;
    /**
     * Este el servidor de acceso remoto de Java, aqui se llevaran todo las interfaces que use RMI aqui.
     * por defecto se usara el port 20000 de llamarse el constructor por si solo.
     */
    public RMIServer(){

    }

    /**
    * @param  status  Recibe el mensaje del panel grafico para poder cambiarlo desde el metodo
    * El metodo run enciende el servidor. Usando el ip y port adecuados del servidor.
     * @param port: El puerto que desea abrir para el RMI
     * 
    * 
    * @see         Image
    */
    public static void run(JLabel status, String port) {

        try {
            System.out.println("comenzando Servidor");
            status.setText("starting Server");
            Runtime.getRuntime().exec("rmiregistry " + port);
            Registry registry = LocateRegistry.createRegistry(Integer.parseInt(port));

            
            registry.rebind("chatServer", new ChatImpl()); //creates the remote object and registers it
            registry.rebind("desktopServer", new IRemoteDesktopImpl());
            
            status.setText("Servidor comenzado");
            System.out.println("Server Started");
        } catch (RemoteException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}