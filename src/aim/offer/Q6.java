package aim.offer;

import java.util.Stack;

public class Q6 {
	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] middle = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BTree b = getBTreeByPreorM(pre, 0, pre.length - 1, middle, 0,
				middle.length - 1);
		
		System.out.println("preorder:");
		preorderNonrecursive(b);
		System.out.println("inorder:");
		inorderNonrecursive(b);
		System.out.println("postorder:");
		postorderNonrecursive(b);
		
	}

	static class BTree {
		int data;
		BTree left;
		BTree right;

		public BTree(int value, BTree l, BTree r) {
			super();
			this.data = value;
			this.left = l;
			this.right = r;
		}
	}

	// pre:12473568, middle:47215386
	// pre:247 472
	static BTree getBTreeByPreorM(int[] pre, int p_start, int p_end,
			int[] middle, int m_start, int m_end) {
		if(p_start == p_end){
			return new BTree(pre[p_start] , null, null);
		}
		
		
		int root = pre[p_start];
		int root_m_index = getRoot_m_index(middle, m_start, m_end, root);
		System.out.println(root+" "+ root_m_index);
		BTree l = null;
		if (root_m_index > m_start) {
			l = getBTreeByPreorM(pre, p_start + 1, p_start + root_m_index - m_start,
					middle, m_start, root_m_index - 1);
		}
		BTree r = null;
		if (root_m_index < m_end) {
			r = getBTreeByPreorM(pre, p_start + root_m_index + 1 - m_start, p_end,
					middle, root_m_index + 1, m_end);
		}

		BTree b = new BTree(root, l, r);
		return b;

	}

	private static int getRoot_m_index(int[] middle, int m_start, int m_end,
			int root) {
		for (int i = m_start; i <= m_end; i++) {
			if (middle[i] == root)
				return i;
		}
		return -1;
	}

	
	static void postorderNonrecursive(BTree node) {
		Stack<BTree> sTraverse = new Stack<BTree>();
		Stack<BTree> sVisit = new Stack<BTree>();
		sTraverse.push(node);
		while (!sTraverse.empty()) {
			BTree p = sTraverse.pop();
			sVisit.push(p);
			if (p.left != null)
				sTraverse.push(p.left);
			if (p.right != null)
				sTraverse.push(p.right);
		}
		while (!sVisit.empty()) {
			System.out.print(sVisit.pop().data + " ");
		}
		System.out.println();
	}
	
	static void inorderNonrecursive(BTree node) {
		Stack<BTree> s = new Stack<BTree>();
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
		System.out.println();
	}
	
	
	/**
	 * 
	 * @Title: preorderNonrecursive 
	 * @Description: My preorderNonrecursive,not graceful. %>_<% 
	 * @param @param node
	 * @return void
	 * @throws
	 */
	static void preorderNonrecursive(BTree node) {
		Stack<BTree> s = new Stack<BTree>();
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
		System.out.println();
	}
}
