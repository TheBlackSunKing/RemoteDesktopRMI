/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package remote.desktopview;

import javax.swing.JFrame;
import remote.desktop.IRemoteDesktop;
import server.CommonServer;
import server.RMIServer;
import server.TCPServer;

/**
 *
 * @author Usuario
 * Visor de informacion del equipo 
 */
public class DesktopViewInfo extends JFrame {
    private IRemoteDesktop remote_obj;
    private CommonServer commonServer;
    public DesktopViewInfo(RMIServer rmiServer, TCPServer tcpserver){
        this.commonServer = new CommonServer(rmiServer,tcpserver);
    }
    private void initcomponent(){
        
    }
}
