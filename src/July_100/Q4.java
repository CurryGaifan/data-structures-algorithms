package July_100;

import java.util.Stack;

public class Q4 {
	
	public static void main(String[] args) {
		TreeNode e_4 = new TreeNode();
		e_4.data = 4;
		
		TreeNode e_7 = new TreeNode();
		e_7.data = 7;
		
		TreeNode e_12 = new TreeNode();
		e_12.data = 12;
		
		TreeNode e_5 = new TreeNode();
		e_5.data = 5;
		e_5.left = e_4;
		e_5.right = e_7;
		
		TreeNode e_10 = new TreeNode();
		e_10.data = 10;
		e_10.left = e_5;
		e_10.right = e_12;
		printPaths(e_10, 22);
	}
	
	private static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
	}
	
	private static void printPaths(TreeNode tn, int sum){
		
		helper(tn, 0, sum, new Stack<Integer>());
	}
	
	
	private static void helper(TreeNode tn, int tmpsum, int sum, Stack<Integer> s){
		int data = tn.data;
		tmpsum += data;
		s.push(data);
		if(tmpsum > sum){
			s.pop();
			return;
		}else if(tmpsum == sum){
			if(tn.left == null && tn.right == null){
				print((Stack<Integer>)s.clone());
				System.out.println();
				s.pop();
			}else {
				s.pop();
				
			}
		}else {
			if(tn.left!=null){
				helper(tn.left, tmpsum, sum, s);
			}
			if(tn.right!=null){
				helper(tn.right, tmpsum, sum, s);
			}
			s.pop();
		}
	}


	private static void print(Stack<Integer> s) {
		int data =  s.pop();
		if(!s.empty()){
			print(s);
		}
		
		System.out.print(data + " " );
		
	}

}
