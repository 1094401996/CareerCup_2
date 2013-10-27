/**CareerCup4.1
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, 
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never
 *  differ by more than one.
 *  method1： calculate the height of every node....
 *  method2: we don't need to calculate the height of every node....
 */


package fourdot1;

import binarytree.BinaryTree;

public class IsBalanced {
	public static void main(String[]args){
        int [] data1 = {1,3,2,5,4,8,6};
        int [] data2 = {10,5,15,3,6,12,18};
        BinaryTree mytree1 = new BinaryTree(data1);
        BinaryTree mytree2 = new BinaryTree(data2);
        System.out.println(mytree1.isBalanced1(mytree1.getRoot()));
        System.out.println(mytree1.isBalanced2(mytree1.getRoot()));
        System.out.println(mytree2.isBalanced1(mytree2.getRoot()));
        System.out.println(mytree2.isBalanced2(mytree2.getRoot()));        

}
}
