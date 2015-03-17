package July_100;

import java.util.Stack;

public class Q21 {
	
	public static void main(String[] args) {
		int m = 10;
		int n = 8;
		
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 1; i<n;i++){
			helper(i, n , m, s);
		}
		
	}

	private static void helper(int start, int end, int m, Stack s) {
		
		if(start == m ){
			s.add(start);
			print((Stack)s.clone());
			System.out.println();
			s.pop();
			return;
		}
		
		for(int i = start+1 ; i<=end; i++ ){
			m = m - start;
			s.add(start);
			helper(i, end, m , s);
			s.pop();
			m = m + start;
		}
		
	}

	private static void print(Stack<Integer> s) {
		if(s.size() == 0)
			return;
		int a = s.pop();
		print(s);
		System.out.print(a + " ");
		
	}

	
}
