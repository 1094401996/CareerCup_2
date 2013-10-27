package fourdot3;

import binarytree.BinaryTree;

public class MinBST {
	 public static void main(String[] args) {
         int [] data = {1,2,3,4,5};
         BinaryTree mytree = new BinaryTree(data,true);
         //the implementation is in the BinaryTree.java
         mytree.preorder(mytree.getRoot());
         System.out.println();
         mytree.inorder(mytree.getRoot());
         System.out.println();
         mytree.postorder(mytree.getRoot());
         System.out.println();
         mytree.levelorder(mytree.getRoot());

}
}
