package seventeenthdot13;

public class BSTtoDLL {
	
	
	public static void concat(BiNode x, BiNode y){
		x.node2 = y;
		y.node1 = x;
	}
	
	
	public NodePair convert(BiNode root){
		if(root == null)
			return null;
		
		NodePair part1 = convert(root.node1);
		NodePair part2 = convert(root.node2);
		
		if(part1 != null){
			concat(part1.tail,root);
			
		}
		
		if(part2 != null){
			concat(root,part2.head);
		}
		
		return new NodePair(part1 == null ?root:part1.head,part2 == null?root :part2.tail);
	}
	
	
	
	public BiNode convert2(BiNode root){
		if(root == null)
			return null;
		
		BiNode part1 = convert2(root.node1);
		BiNode part2 = convert2(root.node2);
		
		if(part1 != null){
			concat(getTail(part1),root);
			
		}
		
		if(part2 != null){
			concat(root,part2);
		}
		
		return part1 == null ? root : part1;
	}
	public static BiNode getTail(BiNode node){
		if(node == null){
			return null;
		}
		while(node.node2 != null){
			node = node.node2;
		}
		return node;
	}
}



class NodePair{
	BiNode head;
	BiNode tail;
	
	NodePair(BiNode head, BiNode tail){
		this.head = head;
		this.tail = tail;
	}
}


