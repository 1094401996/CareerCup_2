package fourdot6;


/**CareerCup 4.6
 * Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in
 *  a binary search tree. You may assume that each node has a link to its parent.
 * @author gengchen
 * 
 * pseudocode
 * Node inorderSucc (Node n){
 *         if( n has a right subtree)
 *                 return leftmost child of right subtree) 
 *        else{
 *                while( n is a right child of n.parent){
 *                        n = n.parent
 *                }
 *                return n.parent;
 *                
 *                
 *                */

import binarytree.BinaryTree;
import binarytree.Node;

public class NextInorderNode {
	
	public static void main(String[] args){
		int[] data = {1,3,2,5,4,8,6};
		BinaryTree bt = new BinaryTree(data);
		
	}
	
	public Node getNext(Node n){
		
		if(n == null)
			return null;
		if(n.getRight() != null){
			Node p = n; 
			while( p != null){
				p = p.getLeft();
			}
			return p;
		}
		else{
			Node parent = n.getParent();
			while(parent != null){
				if(parent.getLeft() == n)
					return parent;
				n = parent;
				parent = parent.getParent();
			}
			return null;
		}
	}

}
