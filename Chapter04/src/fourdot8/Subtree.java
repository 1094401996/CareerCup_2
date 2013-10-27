package fourdot8;

import binarytree.BinaryTree;

/**CareerCup 4.8
 * You have two very large binary trees: T1, with millions of nodes, and T2, 
 * with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree 
 * of n is identical to T2. That is, if you cut the tree at node n, the two trees would
 *  be identical.
 *  Method: traverse the larger tree(T1) first, if find the identical node to the root of 
 *  smaller tree(T2), then compare the subtree tO the smaller tree recursively...
 *  
 *  
 *  2013.3.26
 *  心得：很多书的问题在于遍历和递归
 */

public class Subtree {
	 public static void main(String [] args){
		 int [] pre1 = {7,10,4,3,1,2,8,11};
         int [] in1 = {4,10,3,1,7,11,8,2};
         BinaryTree bt1 = new BinaryTree();
         bt1.reconstruction1(pre1, in1);
         
         int[] pre2 = {10,4,3,1};
         int[] in2 = {4,10,3,1};
         BinaryTree bt2 = new BinaryTree();
         bt2.reconstruction1(pre2, in2);
         
         System.out.println(bt1.isSubtree(bt2.getRoot()));
 }
}	
