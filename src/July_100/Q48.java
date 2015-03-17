package July_100;

public class Q48 {

	public static void main(String[] args){
		int[] a ={4,3,2,1,13,12,11,10,9,8,7,6,5}; 
		System.out.println(new Q48().shiftedBinarySearch(a, 5, 13));
	}
	
	
	int shiftedBinarySearch(int a[], int k, int n) {
		return helper(a, k, 0, n - 1);
	}

	int helper(int a[], int k, int s, int t) {
		if (s > t)
			return -1;
		int m = s + (t - s) / 2;
		System.out.println(a[s]+" "+a[m]+" "+a[t]);
		if (a[m] == k)
			return m;
		else if (a[t] == k)
			return t;
		else if (a[s] == k)
			return s;
		else if(a[m] > a[s]){
			if(k<a[m]&&k>a[t])
				return helper(a, k, m + 1, t);
			else 
				return helper(a, k, s, m-1);
		}else if(a[m] < a[t] ){
			if(k<a[s]&&k>a[m])
				return helper(a, k, s, m-1);
			else 
				return helper(a, k, m + 1, t);
		}else if(a[s]>a[m]&& a[m]>a[t]){
			if(k>a[m])
				return helper(a, k, s, m-1);
			else 
				return helper(a, k, m + 1, t);
		}else 
			System.out.println("what happend");
		return -1;
	}
}
