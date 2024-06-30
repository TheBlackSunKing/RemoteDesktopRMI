/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import view.ChatClientView;

/**
 *
 * @author Usuario
 */
public class TCPClient extends Thread{
    private ChatClientView main_chat_panel;

    private Socket client;
    private boolean is_connected_server;

    public TCPClient(ChatClientView main_chat_panel) {
        this.client = null;
        this.is_connected_server = false;
        this.main_chat_panel = main_chat_panel;
    }

    public void startConnectingToTcpServer(String host, int port, String password) throws IOException {
        System.out.println("Comenzando a conectar con el servidor");
        if(this.is_connected_server == false) {
            this.client = new Socket(host, port);
            DataOutputStream dos = new DataOutputStream(this.client.getOutputStream());
            DataInputStream dis = new DataInputStream(this.client.getInputStream());
            
            dos.writeUTF(password);
            String result = dis.readUTF();

            if(result.equals("true")) {
                //ChatBus chat_bus = new ChatBus(this.client);
                //this.main_chat_panel.addNewConnection(chat_bus);
                this.is_connected_server = true;
            }
            else if(result.equals("false")) {
                this.client.close();
                
                throw new IOException("Wrong password of server");
            }
        }
    }

    public void stopConnectingToTcpServer() throws IOException {
        if(this.is_connected_server = true) {
            this.client.close();
            //this.chat_bus.setSocket(null);
            this.is_connected_server = false;
        }
    }

    public boolean isConnectedServer() {
        return this.is_connected_server;
    }

    public void setConnectedServer(boolean b) {
        this.is_connected_server = b;
    }

    public Socket getClient() {
        return this.client;
    }
}
