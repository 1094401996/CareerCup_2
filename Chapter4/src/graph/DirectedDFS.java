package graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DirectedDFS {
	
	private boolean[] marked;
	private int[] edgeTo;
	private final int source;
	private int count;
	
	public DirectedDFS(Digraph dg, int s){
		marked = new boolean[dg.V()];
		edgeTo = new int[dg.V()];
		this.source = s;
		dfs(dg,s);
	}
	
	private void dfs(Digraph dg , int v){
		marked[v] = true;
		count++;
		for(int w : dg.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(dg,w);
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
