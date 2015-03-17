package July_100;

public class Q11 {
//	    1
//	 /     \
//	 2     3
//	/     / \
// 4      6  7
//       /    \
//	    10    11
	
	
	
	public static void main(String[] args) {
		BTree b11 = null;
//		BTree b11 = new BTree();
		BTree b10 = new BTree();
		BTree b7 = new BTree(null, b11);
		BTree b6 = new BTree(b10, null);
		BTree b4 = null;
//		BTree b4 = new BTree();
		BTree b3= new BTree(b6, b7);
		BTree b2 = new BTree(b4, null);
		BTree b1= new BTree(b2, b3);
		
		System.out.println(getMax(b1).maxlength);
		
	}
	
	
	private static class BTree{
		BTree l;
		BTree r;
		public BTree() {
			super();
		}
		public BTree(BTree l, BTree r) {
			super();
			this.l = l;
			this.r = r;
		}
	}
	
	private static class Node{
		int deepth;
		int maxlength;
	}
	
	
	static Node getMax(BTree bt){
		
		return helper(bt);
	}
	
	static Node helper(BTree bt){
		if(bt == null){
			Node n = new Node();
			n.deepth = 0 ; 
			n.maxlength = 0 ;
			return n;
		}
		Node l = helper(bt.l);
		Node r = helper(bt.r);
		
		Node n = new Node();
		n.deepth = Math.max(l.deepth, r.deepth) + 1;
		n.maxlength = Math.max(Math.max(l.maxlength, r.maxlength), r.deepth + l.deepth);
		return n;  
	}

}
