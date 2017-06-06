/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasks;

import java.util.*;

/**
 *
 * @author nezspencer
 */
public class Tasks {
    
    static Tasks iq;
    
    public Vertex breadthFS(Vertex startNode, Vertex nodeToFind){
        //add StartNode to queue
        Queue<Vertex> queue = new LinkedList<>();
        ArrayList<Vertex> visitedNodes = new ArrayList<>();
        queue.add(startNode);
        
        //check if queue is empty
        while (!queue.isEmpty()){
        
            //check if current node is equal to node sought for
            Vertex current = queue.remove();
            visitedNodes.add(current);
            if(current.equals(nodeToFind)){
            
                //return node
                System.out.print(visitedNodes);
                return current;
            }
            
            //add neighbours of current node to queue
            if(current.getNeighbours().isEmpty()){
                System.out.println(visitedNodes);
                return null;
            }
                
            
            queue.addAll(current.getNeighbours());
            
            
        }
        
        return null;
    }
    
    public Vertex depthFS(Vertex startNode, Vertex nodeToFind){
    
        //add startNode to stack
        Stack<Vertex> dfsStack = new Stack();
        ArrayList<Vertex> visitedNodes = new ArrayList<>();
        dfsStack.add(startNode);
        
        //if stack is empty return null 
        while(!dfsStack.isEmpty()){
        
            //check if current node is equal to the node sought for
            Vertex current = dfsStack.pop();
            visitedNodes.add(current);
            
            if(current.equals(nodeToFind)){
            
                //return current node
                System.out.print(visitedNodes);
                return current;
            }
            
            
            dfsStack.addAll(current.getNeighbours());
        }
        
        return null;
    }
    
    //Test data to test both DFS and BFS
    //just call this method in main() and
    // change line 109 as desired to implement BFS or DFS
    public static void addTestData(){
    
        Vertex v0 = new Vertex("zero");
        Vertex v1 = new Vertex("One");
        Vertex v2 = new Vertex("Two");
        Vertex v3 = new Vertex("Three");
        Vertex v4 = new Vertex("Four");
        Vertex v5 = new Vertex("Five");
        Vertex v6 = new Vertex("Six");
        Vertex v7 = new Vertex("Seven");
        Vertex v8 = new Vertex("Eight");
        
        v0.addNeighbour(v1);
        v0.addNeighbour(v2);
        
        v1.addNeighbour(v3);
        v1.addNeighbour(v4);
        
        v2.addNeighbour(v5);
        v2.addNeighbour(v6);
        
        v3.addNeighbour(v7);
        v4.addNeighbour(v8);
        
        iq = new Tasks();
        
        iq.breadthFS(v0, v5);
        
    }
    
    public static int[] performSelectionSort(int[] unsortedArray){
    
        int arraySize = unsortedArray.length;
        int positionOfSmallestItem;
        int swap;
        
        
        for(int i =0; i<arraySize -1; i++){
       
             positionOfSmallestItem = i;
             
            //iterate to get smallest number in the collection;
            for(int j =i + 1; j<arraySize; j++){
                
                if(unsortedArray[j] < unsortedArray[positionOfSmallestItem]){
           
                    positionOfSmallestItem = j;
            }
                
           
            }
            
            //place into sortedArray
            swap = unsortedArray[i];
            unsortedArray[i] = unsortedArray[positionOfSmallestItem];
            unsortedArray[positionOfSmallestItem] = swap;
            //repeat procedure n times n being the length of the array
            
        }
        
        return unsortedArray;
    }
    
    public static int[] performInsertionSort(int[] unsorted){
        
        
        int swapItem;
        
        for(int i=1; i<unsorted.length; i++){
        
            //take a number from top
            int item = unsorted[i];
            for(int j =i-1; j>=0; j--){
            
                //if number is greater than the number before it, swap them
                if(j-1 >=0 && unsorted[j-1] > unsorted[j]){
                
                    swapItem = unsorted[j-1];
                    unsorted[j-1] = unsorted[j];
                    unsorted[j] = swapItem;
                }
                
            }
        }
    
        //return sortedArray;
        return unsorted;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //addTestData();
        
        int [] array = {2,4,1,8,4,9};
        System.out.println(Arrays.toString(performInsertionSort(array)));
       
        
        
    }
    
}
