package binarytree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * definition: the height of empty tree is -1, the height of the binary tree
 *  with only root node is 0, root node is no level 0, depth is 0
 * @author gengchen
 *
 */
public class BinaryTree {
	
	private Node root;
	
	public BinaryTree(){
		
	}
	
	public BinaryTree(int[] arr){
		initTree(arr);
	}
	//just for the 4.3
	public BinaryTree(int[]arr,boolean b){
		this.root = builtMinBST(arr,0,arr.length - 1);
	}
	
	private Node builtMinBST(int[] arr,int left, int right){
		if(left > right)
			return null;
		int mid = (left + right) / 2;
		Node n = new Node(arr[mid]);
		n.setLeft(builtMinBST(arr,left,mid - 1));
		n.setRight(builtMinBST(arr,mid + 1,right));
		return n;
	}
	private void initTree(int[]arr){
		if(arr == null)
			return;
		this.root = new Node(arr[0]);
		for(int i = 1; i < arr.length; i++){
			Node p = root;
			Node n = new Node(arr[i]);
			while(true){
				if(n.getElement() <= p.getElement()){
					if(p.getLeft() == null){
						p.setLeft(n);
						break;
					}
					else
						p = p.getLeft();
				}	
				else{
					if(p.getRight() == null){
						p.setRight(n);
						break;
					}
					else{
						p = p.getRight();
					}
				}
			}
		}
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	
	//the folowing methods are common traverse algorithms
	
	//1, preorder
	public void preorder(Node p){
		if(p == null)
			return;
		System.out.print(p.getElement()+ " ");
		preorder(p.getLeft());
		preorder(p.getRight());
	}
	
	//2,inorder
	public void inorder(Node p){
		if(p == null)
			return;
		inorder(p.getLeft());
		System.out.print(p.getElement()+ " ");
		inorder(p.getRight());
	}
	//3,postorder
	public void postorder(Node p){
		if( p == null){
			return;
		}
		postorder(p.getLeft());
		postorder(p.getRight());
		System.out.print(p.getElement()+ " ");
	}
	
	//4, levelorder
	public void levelorder(Node p){
		if( p == null)
			return ;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(p);
		while(queue.size() !=0){
			Node temp = queue.poll();
			System.out.print(temp.getElement() + " ");
			if(temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if(temp.getRight() != null)
				queue.offer(temp.getRight());
		}
	}
	
	//4.1
	
	public boolean isBalanced1(Node n){
		if(n == null){
			return true;
		}
		int leftChildHeight = getHeight(n.getLeft());
		int rightChildHeight = getHeight(n.getRight());
		int diff = Math.abs(leftChildHeight - rightChildHeight);
		if(diff > 1)
			return false;
		else
			return isBalanced1(n.getLeft()) && isBalanced1(n.getRight());
			
	}
	
	public  int getHeight(Node n){
		if (n == null){
			return -1;
		}
		return Math.max(getHeight(n.getLeft()),getHeight(n.getRight())) + 1;
	}
	public boolean isBalanced2(Node n){
		if(checkHeight(getRoot()) == -2)
			return false;
		return true;
	}
	//helper method for isBalanced2
	private int checkHeight(Node n){
		if(n == null){
			return -1;
		}
		int leftHeight = checkHeight(n.getLeft());
		if(leftHeight == -2)
			return -2;
		int rightHeight = checkHeight(n.getRight());
		if(rightHeight == -2)
			return -2;
		int diff = Math.abs(rightHeight - leftHeight);
		if(diff <= 1){
			return Math.max(leftHeight, rightHeight) + 1;
		}
		return -2;
	}
	
	
	
	//4.5
	class IntegerWapper{
		int last_visited = Integer.MIN_VALUE;

	}
	
	public boolean isBST1(Node n){
		IntegerWapper i = new IntegerWapper();
		return isBST1(n,i);
	}
	public boolean isBST1(Node n, IntegerWapper i){
		if(n == null)
			return true;
		if(!isBST1(n.getLeft(),i))
			return false;
		if(n.getElement() <  i.last_visited){
			return false;
		}
		i.last_visited = n.getElement();
		if(!isBST1(n.getRight(),i))
			return false;
		return true;
	}
	public boolean isBST2(Node n){
		return isBST2(n, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private boolean isBST2(Node n, int min, int max){
		if(n == null)
			return true;
		if(n.getElement() <= min || n.getElement() > max)
			return false;
		if(!isBST2(n.getLeft(),min,n.getElement()) || !isBST2(n.getRight(),n.getElement(),max))
			return false;
		
		return true;
	}
	
	
	
	//classic questions about tree
	public void reconstruction1(int[]pre,int[]in){
		root = reconstruction1(pre,in,0,pre.length - 1, 0);
	}
	private Node reconstruction1(int[]pre,int[] in, int left, int right, int offset){
		if(left > right)
			return null;
		Node n = new Node(pre[left]);
		int index = getIndex(in,pre[left]);
		int i =  index - offset;
		n.setLeft(reconstruction1(pre,in,left + 1,left   +i,offset));
		n.setRight(reconstruction1(pre,in,left + i + 1,right, index + 1));
		
		
		return n;
	}
	public void reconstruction2(int[]post,int[]in){
		root = reconstruction2(post,in,0,post.length - 1, 0);
	}
	private Node reconstruction2(int[]post,int[] in, int left, int right, int offset){
		if(left > right)
			return null;
		Node n = new Node(post[right]);
		int index = getIndex(in,post[right]);
		int i =  index - offset;
		n.setLeft(reconstruction2(post,in,left,left + i - 1,offset));
		n.setRight(reconstruction2(post,in,left + i ,right - 1, index  + 1));
		
		
		return n;
	}
	
	private int getIndex(int[]in, int val){
		int i = 0;
		for( i = 0 ; i < in.length ;i++){
			if(in[i] == val)
				break;
		}
		return i;
	}
	public static void main(String[]args){
		int[] arr = {1,3,2,5,4,8,6};
		BinaryTree bt = new BinaryTree(arr);
		bt.preorder(bt.getRoot());
		System.out.println();
		bt.inorder(bt.getRoot());
		System.out.println();
		bt.postorder(bt.getRoot());
		System.out.println();
		bt.levelorder(bt.getRoot());
	}
	

	
	
	
	
}

