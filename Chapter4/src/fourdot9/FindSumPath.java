package fourdot9;

import binarytree.BinaryTree;


/**
 * CareerCup 4.9
 * You are given a binary tree in which each node contains a value. 
 * Design an algorithm to print all paths which sum to a given value.
 *  Note that a path can start or end anywhere in the tree.
 *  
 * 此题很好，综合使用了递归和一些编程的小技巧， 我这个智商果断没自己想出来。。。。答案是如此的优雅。。。。
 * 第一步：树的高度为N， 建立一个path数组，长度为N + 1
 * 第二步：递归遍历每个节点， 对每个节点都findsum函数， on every node, we look "up " to see if 
 * we have found the sum, that is rather than asking" does this node start a path
 * with the sum " , we ask, "does this node complete the path with the sum.This description
 * cited from solution is terrific. I must maintain the thinking pattern
 * @author gengchen
 * 
 *                			 3 
 *                      ___/ \___
 *                       2       1
 *                      / \     / \
 *                     4   5   9   6
 *                    /
 *                   0   
 */

public class FindSumPath {
	public static void main(String[] args){
		int[]pre = {3,2,4,0,5,1,9,6};
		int[]in = {0,4,2,5,3,9,1,6};
		BinaryTree bt = new BinaryTree();
		bt.reconstruction1(pre, in);
		bt.findSum(10);
	}
}
