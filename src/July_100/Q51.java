package July_100;

public class Q51 {
	
	public static void main(String[] args){
		
		
		int a = 120010;
		System.out.println(new Q51().findConsecutiveSequence(a));
		System.out.println(new Q51().findConsecutiveSequence1(a));
	}

	
	int findConsecutiveSequence1(int n){
		int count = 0;
		if(n%2==1){
			System.out.println(n/2 + "-" + (n/2+1));
			count ++;
		}
		for(int i = 3 ; i<n; i+=2){
			if(n%i==0){
				System.out.println(((n/i-i/2)<1?(1-(n/i-i/2)):(n/i-i/2)) + "-" + (n/i+i/2));
				count ++;
			}
		}
		return count;
	}
	
	
	
	int findConsecutiveSequence(int n) {
		int count = 0;
		for (int i = 1; i <= n / 2; i++) {
			double sqroot = Math.sqrt(4 * i * i + 8 * n - 4 * i + 1);
			if (sqroot == -1)
				continue;
			if ((sqroot % 1) == 0) {
				System.out.println(i + "-" + (int)((sqroot - 1) / 2));
				count++;
			}
		}
		return count;
	}
}
