/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package remote.desktop;

/**
 *
 * @author Usuario
 */


//import com.gui.remote.ComputerInfo;
import java.rmi.Remote;
import java.rmi.RemoteException;

import java.rmi.Remote;

public interface IRemoteDesktop extends Remote {
    // Topa una captura de pantalla
    byte[] takeScreenshotServer(String quality) throws Exception;

    // TODO: Metodos para mover el raton
    void mouseMovedServer(int x, int y) throws RemoteException;
    void mousePressedServer(int buttons) throws RemoteException;
    void mouseReleasedServer(int buttons) throws RemoteException;
    void mouseWheelServer(int wheel_amt) throws RemoteException;

    // TODO: Metodos para las teclas
    void keyPressedServer(int keycode) throws RemoteException;
    void keyReleasedServer(int keycode) throws RemoteException;

    // Obtener informacion de hardware
    double getCpuLoadServer() throws RemoteException;
    double getRamUsageServer() throws RemoteException;
    long[] getRamMemories() throws RemoteException;
    int getCpus() throws RemoteException;
    ComputerInfo getComputerInformation() throws RemoteException;

}
