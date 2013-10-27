package classic_question_about_tree;

import binarytree.BinaryTree;

public class ReconstructionTree {
	public static void main(String[]args){
		int[]pre = {7,10,4,3,1,2,8,11};
		int[]in = {4,10,3,1,7,11,8,2};
		int[]post={4, 1, 3, 10, 11, 8 ,2 , 7 };
		BinaryTree bt1 = new BinaryTree();
		bt1.reconstruction1(pre, in);
		bt1.preorder(bt1.getRoot());
		System.out.println();
		bt1.inorder(bt1.getRoot());
		System.out.println();
		bt1.postorder(bt1.getRoot());
		
		System.out.println();

		
		BinaryTree bt2 = new BinaryTree();
		bt2.reconstruction2(post, in);
		bt2.preorder(bt2.getRoot());
		System.out.println();
		bt2.inorder(bt2.getRoot());
		System.out.println();
		bt2.postorder(bt2.getRoot());
	}
}
