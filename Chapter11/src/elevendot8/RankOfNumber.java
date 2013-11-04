package elevendot8;

public class RankOfNumber {
	public static void main(String[] args){
		BST bst = new BST();
        int[] data = {5,1,4,4,5,9,7,13,3};
        for(int i = 0 ; i < data.length; i++){
        	System.out.println(bst.rank(data[i]));
        	bst.put(data[i]);
        }
	}
}



class Node{
	Node left;
	Node right;
	int val;
	int size;
	Node(int val){
		this.val = val;
		this.size = 1;
	}
}


class BST{
	Node root;
	
	int size(){
		return size(root);
	}
	
	int size(Node n){
		if(n == null){
			return 0;
		}else
			return n.size;
	}

	
	void put(int val){
		root = put(root,val);
	}
	
	
	Node put(Node n,int val){
		if(n == null)
			return new Node(val);
		int cmp = val - n.val;
		
		if(cmp <= 0){
			n.left = put(n.left,val);
		}else{
			n.right = put(n.right,val);
		}
		n.size = size(n.left) + size(n.right) + 1;
		return n;
	}
	
	 int rank(int val){
		return rank(root,val);
	}
	 
	 int rank(Node n, int val){
		 if(n == null)
			 return 0;
		 int cmp = n.val - val;
		 if(cmp == 0){
			 return size(n.left) + 1;
		 }else if(cmp < 0){
			 return rank(n.right,val) + size(n.left) + 1;
		 }else{
			 return rank(n.left,val) ;
		 }
	 }
}