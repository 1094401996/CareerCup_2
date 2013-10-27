package binarytree;

import java.util.ArrayList;
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
	
	
	public Node findNode(int element){
        return findNode(root, element);
}

private Node findNode(Node n , int element){
        if(n == null){
                return null;
        }
        if(n.getElement() == element){
                return n;
        }
        Node left = findNode(n.getLeft(),element);
        Node right = findNode(n.getRight(),element);
        return left == null ? right : left;
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
	
	// 4.4 
	public LinkedList[] linkedTree(Node n){
		if( n == null)
			return null;
		
		int H = getHeight(n);
		
		LinkedList[] ll = new LinkedList[H + 1];
		
		for(int i = 0 ; i < H + 1; i++){
			ll[i] = new LinkedList();
		}
		
		ArrayList<Node> array = new ArrayList<Node>();
		array.add(n);
		int cur = 0 ;
		int last = 1;
		int level = 0;
		while(cur < array.size()){
			last = array.size();//the new level begins, 重新定位last于当前行最后一个节点的下一个位置
			while(cur < last){
				ll[level].add(array.get(cur));
				if(array.get(cur).getLeft()!= null){
					array.add((array.get(cur).getLeft()));
				}
				if(array.get(cur).getRight() != null){
					array.add(array.get(cur).getRight());
				}
				cur++;
			}
			level++;
		}
		return ll;
		
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
	
	// 4.7  method 1
	
	public Node lowestCommonAncester1(Node p , Node q){
		return lowestCommonAncester1(root,p,q);
	}
	private Node lowestCommonAncester1(Node n, Node p, Node q){
        if(!isDecendent(n,p) || !isDecendent(n,q)){
                return null;
        }
        else
                return lowestCommonAncester1Helper(n, p, q);
	}
	private boolean isDecendent(Node n, Node p){
		if(n == null){
			return false;
		}
		if(n == p){
			return true;
		}
		return isDecendent(n.getLeft(),p) || isDecendent(n.getRight(),p);
	}
	private Node lowestCommonAncester1Helper(Node n, Node p , Node q ){
		if(n == null)
			return null;
		if(n == p || n == q){
			return n;
		}
		
		boolean is_p_left = isDecendent(n.getLeft(),p);
		boolean is_q_left = isDecendent(n.getLeft(),q);
		
		if(is_p_left != is_q_left){
			return n;
		}
		
		Node child_side = is_p_left ? n.getLeft() : n.getRight();
		return lowestCommonAncester1Helper(child_side,p,q);
	
	}
	
// 4.7 method 2
	public Node lowestCommonAncester2(Node p, Node q ){
		Result s = lowestCommomAncestor2Helper(root,p,q);
		if(s.isAncestor){
			System.out.println("real");
			return s.node;
		}
		System.out.println("false");
		System.out.println(s.node.getElement());
		return null;
	}
	
	Result lowestCommomAncestor2Helper(Node n, Node p, Node q){

		if(n == null)
			return new Result(null, false);
		if(n == p && n == q){
			return new Result(n, true);
		}
		Result rleft = lowestCommomAncestor2Helper(n.getLeft(), p, q);
		if(rleft.isAncestor){
			return rleft;
		}
		Result rright = lowestCommomAncestor2Helper(n.getRight(), p, q);
		if(rright.isAncestor)
			return rright;
		
		if(rleft.node != null && rright.node != null){
			return new Result(n,true);
		}else if( n == p || n == q){
			/*
			 * we are currently at p or q, and we also fond one of those nodes
			 * in a subtree,then this is truly an ancester and the flag should be true
			 */
			boolean isAncester = rleft.node != null || rright.node != null ? true :false;
			return new Result(n,isAncester);
		}else{
			return new Result(rleft.node != null ? rleft.node :rright.node,false);
		}
	}
	
	
	class Result{
		Node node;
		boolean isAncestor;
		Result(Node node, boolean isAnc){
			this.node = node;
			this.isAncestor = isAnc;
		}
	}
	
	//4.8
	
	public boolean isSubtree( Node root){
		if(root == null)
			return true;
		return subtreehelper(this.root,root);
	}
	
	private boolean subtreehelper(Node n1, Node n2){
		if(n1 == null){
			return false;
		}
		if(n1.getElement() == n2.getElement()){
			if(match(n1,n2))
				return true;
		}
		return (subtreehelper(n1.getLeft(), n2) || subtreehelper(n1.getRight(),n2));
	}
	private boolean match(Node n1, Node n2){
		if(n1 == null && n2 == null)
			return true;
		if(n1 == null || n2 == null)
			return false;
		if(n1.getElement() != n2.getElement())
			return false;
		
		return (match(n1.getLeft(),n2.getLeft()) && match(n1.getRight(),n2.getRight()));
	}
	
	//4.9
	
	
	public void findSum(int sum){
		findSum(root, sum);
	}
	private void findSum(Node n ,int sum){
		int height = this.getHeight(n);
		int[]path = new int[height + 1];
		findSum(n,sum,path,0);
	}
	
	private void findSum(Node n, int sum, int[]path,int level){
		if(n == null){
			return ;
		}
		path[level] = n.getElement();
		
		
		int t = 0; 
		for(int i = level; i >= 0; i--){
			t+=path[i];
			if(t == sum){
				print(path,i,level);
			}
		}
		
		/*search nodes beneath this one*/
		this.findSum(n.getLeft(), sum, path, level + 1);
		this.findSum(n.getRight(), sum, path, level + 1);
		
		//remove current node fromm path. Not strickly necessary, since we would ignore the 
        // value, but it's a good practice
		
        path[level] = Integer.MIN_VALUE;
	}
	
	private void print(int[]path,int start, int end){
		for(int i = start; i <= end ; i++){
			System.out.print(path[i] +" ->");
		}
		System.out.println();
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

