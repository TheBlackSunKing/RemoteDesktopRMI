/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package remote.desktop;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class DriveInfo implements Serializable {
    private String name;
    private long free;
    private long total;

    public DriveInfo(String name, long free, long total) {
        this.name = name;
        this.free = free;
        this.total = total;
    }

    public String getName() {
        return this.name;
    }

    public long getFreeSpace() {
        return this.free;
    }

    public long getTotalSpace() {
        return this.total;
    }
}