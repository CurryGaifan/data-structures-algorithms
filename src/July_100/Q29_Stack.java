package July_100;
import java.util.Stack;


public class Q29_Stack {
	public static void main(String[] args){
		int[] a = {1,2,3,4,5};
		int[] b = {3,2,4,5,1};
		System.out.println(isPoPSeries(a, b , 5));
	}

	private static int isPoPSeries(int[] a, int[] b, int n) {
		Stack<Integer> s = new Stack<Integer>();
		int h =0;
		int i = 0;
		while(i<n+1&&h<n){
			while(!s.empty()&& s.peek() == b[h]){
				h++;
				s.pop();
			}
			
			if(i<n)
				s.push(a[i]);
			i++;
		}
		if(s.empty()){
			return 1;
		}else{
			return 0;
		}
	}

}
