package foutdot5;

import binarytree.BinaryTree;

public class IsBST {
	public static void main(String[]args){
		int[]pre = {7,10,4,3,1,2,8,11};
		int[]in = {4,10,3,1,7,11,8,2};
		BinaryTree bt1 = new BinaryTree();
		bt1.reconstruction1(pre, in);
		System.out.println(bt1.isBST1(bt1.getRoot()));
		System.out.println(bt1.isBST2(bt1.getRoot()));
		int [] data = {1,2,3,4,5};
        BinaryTree mytree = new BinaryTree(data,true);
        mytree.levelorder(mytree.getRoot());
        System.out.println(mytree.isBST1(mytree.getRoot()));
        System.out.println(mytree.isBST2(mytree.getRoot()));
	}
}
