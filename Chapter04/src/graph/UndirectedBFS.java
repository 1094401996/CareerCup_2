package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class UndirectedBFS {
	private boolean[] marked;
    private int [] edgeTo;
    private final int source;
    private int count = 0;
    
    public UndirectedBFS(Graph G, int s){
            marked = new boolean[G.V()];
            edgeTo = new int[G.V()];
            this.source = s;
            bfs(G,s);
    }
    
    private void bfs(Graph G, int v){
    	Deque<Integer> queue = new LinkedList<Integer>();
    	marked[v] = true;
    	count ++;
    	
    	queue.offer(v);
    	while(!queue.isEmpty()){
    		int i = queue.poll();
    		for(int w : G.adj(i)){
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
