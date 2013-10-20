package binarytree;

public class Node {
        private int element;
        private Node left = null;
        private Node right = null;
        private Node parent = null;// just for careercup 4.6 , we actually didn't implement it

        public Node(){
        }
        
        public Node(int element){
                this.element = element;
        }
        
        public Node getParent(){
                return this.parent;
        }
        public int getElement() {
                return element;
        }
        
        public void setElement(int element) {
                this.element = element;
        }
        
        public Node getLeft() {
                return left;
        }
        
        public void setLeft(Node node) {
                left = node;
        }
        
        public Node getRight() {
                return right;
        }
        
        public void setRight(Node node) {
                right = node;
        }
        
        public static void main(String[]args){
        	Node n = new Node(3);
        	System.out.println(n.getElement());
        }
}

