/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package remote.desktop;

/**
 *
 * @author Usuario
 */

import java.io.Serializable;
import java.util.ArrayList;

public class ComputerInfo implements Serializable {
    private String os_name;
    private ArrayList<DriveInfo> drives;

    public ComputerInfo(String os_name) {
        this.os_name = os_name;
        this.drives = new ArrayList<>();
    }

    public String getOsName() {
        return this.os_name;
    }

    public ArrayList<DriveInfo> getDrives() {
        return this.drives;
    }
}