/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqube;

import java.util.*;

/**
 *
 * @author nezspencer
 */
public class Vertex {
    
    private String name;
    private ArrayList<Vertex> neighbours;
    
    public Vertex(String name){
    
        this.name =name;
        neighbours = new ArrayList<>();
    }
    
    public void addNeighbour(Vertex vertex){
    
        neighbours.add(vertex);
    }
    
    public ArrayList<Vertex> getNeighbours(){
    return neighbours;
    }
    
    public String getName(){return name;}

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
}
