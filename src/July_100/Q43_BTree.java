package July_100;
import java.util.Stack;


public class Q43_BTree {
	
	public static void main(String[] args){
		Q43_BTree bt = new Q43_BTree();
		
		
		//				 3
		//				/ \
		//			   4   13
		//			  /\   / \
		//			 8 12 16 14
		//			/  /\     \
		//		   1  7  9    17 
		//		  /
		//		 6
		TreeNode node = bt.new TreeNode(3,bt.new TreeNode(4,bt.new TreeNode(8,bt.new TreeNode(1,bt.new TreeNode(6,null,null),null),null),bt.new TreeNode(12,bt.new TreeNode(7,null,null),bt.new TreeNode(9,null,null))),bt.new TreeNode(13,bt.new TreeNode(16,null,null),bt.new TreeNode(14,null,bt.new TreeNode(17,null, null))));
		bt.preorderNonrecursive(node);
		System.out.println();
		bt.inorderNonrecursive(node);
		System.out.println();
		bt.postorderNonrecursive(node);
		
	}

	
	/**
	 * 
	 * @Title: postorderNonrecursive 
	 * @Description: elegant
	 * @param @param node
	 * @return void
	 * @throws
	 */
	void postorderNonrecursive(TreeNode node) {
		Stack<TreeNode> sTraverse = new Stack<TreeNode>();
		Stack<TreeNode> sVisit = new Stack<TreeNode>();
		sTraverse.push(node);
		while (!sTraverse.empty()) {
			TreeNode p = sTraverse.pop();
			sVisit.push(p);
			if (p.left != null)
				sTraverse.push(p.left);
			if (p.right != null)
				sTraverse.push(p.right);
		}
		while (!sVisit.empty()) {
			System.out.print(sVisit.pop().data + " ");
		}
	}
	
	
	
	/**
	 * 
	 * @Title: inorderNonrecursive 
	 * @Description: my inorderNonrecursive,not graceful. %>_<% 
	 * @param @param node
	 * @return void
	 * @throws
	 */
	void inorderNonrecursive(TreeNode node) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(node!=null){
			while(node.left!=null){
				s.push(node);
				node = node.left;
			}
			System.out.print(node.data + " ");
			while(node.right==null){
				if(s.empty())
					break;
				node = s.pop();
				System.out.print(node.data + " ");
				
			}
			node = node.right;
		}
	}
	
//	void inorderNonrecursive(TreeNode node) {
//		Stack<TreeNode> s = new Stack<TreeNode>();
//		TreeNode current = node;
//		while (!s.empty() || current != null) {
//			if (current != null) {
//				s.push(current);
//				current = current.left;
//			} else {
//				current = s.pop();
//				System.out.print(current.data + " ");
//				current = current.right;
//			}
//		}
//	}
	
	
	/**
	 * 
	 * @Title: preorderNonrecursive 
	 * @Description: My preorderNonrecursive,not graceful. %>_<% 
	 * @param @param node
	 * @return void
	 * @throws
	 */
	void preorderNonrecursive(TreeNode node) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(node!=null || !s.empty()){
			
			if(node == null ){
				node = s.pop();
			}
			System.out.print(node.data + " ");
			if(node.left!=null){
				if(node.right!=null)
					s.push(node.right);
				node= node.left;
			}else {
				node = node.right;
			}
		}
	}
	
//	void preorderNonrecursive(TreeNode node) {
//		Stack<TreeNode> s = new Stack<TreeNode>();
//		s.push(node);
//		while (!s.empty()) {
//			TreeNode n = s.pop();
//			System.out.print(n.data + " ");
//			if (n.right != null)
//				s.push(n.right);
//			if (n.left != null)
//				s.push(n.left);
//		}
//	}
	
	
	public class TreeNode{
		public TreeNode(){
			
		}
		public TreeNode(int data, TreeNode left, TreeNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public TreeNode getRight() {
			return right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		TreeNode right;
		TreeNode left;
		int data;
		
		
	}
	
	
	
}
