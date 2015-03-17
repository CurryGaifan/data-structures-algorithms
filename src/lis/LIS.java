package lis;

public class LIS {
	public static void main(String[] args) {
		int[] a = { 3, 56, 43, 32, 5, 7, 4, 2, 4, 809, 3, 2, 78, 4532, 22222, 1 };
		// 1 2 2 2 2 3 2 1 2 4 2 1 4 5 6 1
		lis(a);
	}

	static void lis(int[] a) {
		int n = a.length;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j]) {
					max = getMax(max, dp[j] + 1);
				} else if (a[i] == a[j]) {
					max = getMax(max, dp[j]);
				}
			}
			dp[i] = max;
		}
		// for(int b :dp){
		// System.out.print(b+" ");
		// }
		// System.out.println();
		System.out.println(dp[n - 1]);
		int max = 1;
		int temp = max;
		int d[] = new int[max];
		for (int i = n - 1; i > -1; i--) {
			if (dp[i] > max) {
				max = dp[i];
				d = new int[max];

				temp = max - 1;
				d[temp] = a[i];

			} else if (dp[i] == temp) {
				d[--temp] = a[i];
			}

		}
		for (int i = 0; i < max; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();
	}

	private static int getMax(int max, int i) {
		if (max > i)
			return max;
		else
			return i;
	}

}
