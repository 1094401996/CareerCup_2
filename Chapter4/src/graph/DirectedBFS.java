package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DirectedBFS {
	private boolean[] marked;
    private int [] edgeTo;
    private final int source;
    private int count = 0;
    
    public DirectedBFS(Digraph dg, int s){
            marked = new boolean[dg.V()];
            edgeTo = new int[dg.V()];
            this.source = s;
            bfs(dg,s);
    }
    
    private void bfs(Digraph dg, int v){
    	Deque<Integer> queue = new LinkedList<Integer>();
    	marked[v] = true;
    	count ++;
    	
    	queue.offer(v);
    	while(!queue.isEmpty()){
    		int i = queue.poll();
    		for(int w : dg.adj(i)){
    			if(!marked[w]){
    				edgeTo[w] = i;
    				marked[w] = true;
    				count++;
    				queue.offer(w);
    			}
    		}
    	}
    }
    
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> PathTo(int v){
        if(!hasPathTo(v))
                return null;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for( int x = v; x != source; x = edgeTo[x]){
                stack.push(x);
        }
        stack.push(source);
        return stack;
    }
    
    public int count(){
    	return this.count;
    }
    
}
