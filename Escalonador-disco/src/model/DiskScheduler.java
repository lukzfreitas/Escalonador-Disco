/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 13205039
 */
public interface DiskScheduler {
    public int serviceRequests();
    public void printGraph(String filename);
}
