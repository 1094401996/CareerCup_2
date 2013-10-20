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

