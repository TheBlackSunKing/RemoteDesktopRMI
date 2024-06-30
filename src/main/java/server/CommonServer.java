/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author Usuario
 */
public class CommonServer {
    RMIServer rmiServer;
    TCPServer tcpServer;
    public CommonServer(RMIServer rmiServer, TCPServer tcpServer){
        this.rmiServer = rmiServer;
        this.tcpServer = tcpServer;
    }
    public RMIServer getRmiServer(){
        return this.rmiServer;
    }
    
}
