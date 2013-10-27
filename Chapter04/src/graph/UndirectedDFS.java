package graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndirectedDFS {
	
	private boolean[] marked;
	private int[] edgeTo;
	private final int source;
	private int count;
	
	public UndirectedDFS(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.source = s;
		dfs(G,s);
	}
	
	private void dfs(Graph G , int v){
		marked[v] = true;
		count++;
		for(int w : G.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G,w);
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v))
			return null;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for(int i = v; i != source; i = edgeTo[i]){
			stack.push(i);
		}
		stack.push(source);
		return stack;
	}
	 public int count(){
		 return this.count;
	 }

}
