package fourdot4;
/**
 * Given a binary tree, design an algorithm which creates a linked 
 * list of all the nodes at each depth (e.g., if you have a tree with depthD, you’ll have D linked lists).
 * 
 * 方法： 本质上是变形的层次遍历。。。。。。。。
 * 
 * useful link: http://www.cnblogs.com/miloyip/archive/2010/05/12/binary_tree_traversal.html
 */

import java.util.LinkedList;

import binarytree.BinaryTree;
import binarytree.Node;

public class LinkedTree {
	public static void main(String[] args){
		int[] data = {1,3,2,5,4,8,6};
		BinaryTree bt = new BinaryTree(data);
		LinkedList<Node>[] ll = bt.linkedTree(bt.getRoot());
		for(int i = 0 ; i < ll.length;i++){
			for(Node n : ll[i]){
				System.out.print(n.getElement()+" ");
			}
			System.out.println();
		}
	}
}
