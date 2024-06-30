/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;




import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.Vector;

import java.net.ServerSocket;
import java.net.Socket;

import java.net.InetSocketAddress;

import java.io.DataInputStream;

import java.io.DataOutputStream;
/**
 * Es la clase que maneja las conexiones TCP por parte del servidor
 * @author Usuario
 */
public class TCPServer {
    //private MainChatPanel main_chat_panel;

    private ServerSocket server;
    private Socket client;
    private String password;

    private boolean is_listening;
    private boolean is_has_partner;


    public TCPServer() {
        this.server = null;
        this.client = null;
        this.password = null;
        this.is_listening = false;
        this.is_has_partner = false;
        //this.main_chat_panel = main_chat_panel;
    }
    /**
     * Empieza a correr Listening to tcpServer
     * Al crear un servidor se usa el puerto seleciconado +1 debido a que no se puede tener el RMI y el TCP en el mismo port
     * @param host: Recibe el Ip local del servidor.
     * @param port: Recibe el puerto por el que se desea abrir.
     * @param password: Recibe la contraseña.
     * 
     * @throws IOException
     * 
     */
    public void startListeningOnTcpServer(String host, int port, String password) throws IOException {
        if(this.is_listening == false) {
            InetSocketAddress endpoint = new InetSocketAddress(host, port+1);
            this.password = password;
            this.server = new ServerSocket();
            this.server.bind(endpoint);
            this.is_listening = true;
            System.out.println("Servidor TCP Creado");
        }
    }

    public void stopListeningOnTcpServer() throws IOException {
        if(this.is_listening == true) {
            this.server.close();
            if(this.client != null) this.client.close();
            this.is_listening = false;
            this.is_has_partner = false;
        }
    }

    public void waitingConnectionFromClient() throws IOException {
        this.client = this.server.accept();
        DataOutputStream dos = new DataOutputStream(this.client.getOutputStream());
        DataInputStream dis = new DataInputStream(this.client.getInputStream());
        String password = dis.readUTF();
        String result = null;

        if(this.password.equals(password)) {
            result = "true";
            //ChatBus chat_bus = new ChatBus(this.client);
            //this.main_chat_panel.addNewConnection(chat_bus);
            this.is_has_partner = true;
        }
        else result = "false";
        dos.writeUTF(result);
    }
    
    public boolean getis_has_partner(){
        return this.is_has_partner;
    }
    
    public Vector<String> getAllIpv4AddressesOnLocal() throws SocketException {
        Vector<String> ipv4_addresses = new Vector<>();
        Enumeration networks = NetworkInterface.getNetworkInterfaces();
        while(networks.hasMoreElements()) {
            NetworkInterface sub_networks = (NetworkInterface) networks.nextElement();
            Enumeration inet_addresses = sub_networks.getInetAddresses();
            while(inet_addresses.hasMoreElements()) {
                try {
                    Inet4Address ipv4 = (Inet4Address) inet_addresses.nextElement();
                    ipv4_addresses.add(ipv4.getHostAddress());
                }
                catch(Exception e) {
                    // TODO: pass ip version 6
                }
            }
        }
        return ipv4_addresses;
    }

    public boolean isListening() {
        return this.is_listening;
    }

    public boolean isHasPartner() {
        return this.is_has_partner;
    }

    public void setHasPartner(boolean b) {
        this.is_has_partner = b;
    }

    public ServerSocket getServer() {
        return this.server;
    }
}