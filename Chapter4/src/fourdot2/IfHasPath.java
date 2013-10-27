package fourdot2;

import graph.*;

/**
 * CareerCup 4.2
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 * 
 * method:  BFS 
 */

public class IfHasPath {
	public static void main(String[] args) throws Exception{
        int [] data = {13,22,4,2,2,3,3,2,6,0,0,1,2,0,11,12,12,9,9,10,9,11,8,9,10,12,11,4,4,3,3,5,7,8,8,7,5,4,0,5,6,4,6,9,7,6};
        Digraph dg = new Digraph(data);
        
        int source = 6;
        int destination = 4;
        
        DirectedBFS BFSpaths = new DirectedBFS(dg,source);
        
        if(BFSpaths.hasPathTo(destination)){
        	for(int v : BFSpaths.PathTo(destination)){
        		System.out.print(v + "-->");
        	}
        }
        
        System.out.println();
        DirectedDFS DFSpaths = new DirectedDFS(dg,source);
        
        
        if(DFSpaths.hasPathTo(destination)){
        	for(int v : BFSpaths.PathTo(destination)){
        		System.out.print(v + "-->");
        	}
        }
        
        
	}
	
}
