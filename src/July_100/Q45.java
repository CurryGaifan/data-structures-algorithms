package July_100;

public class Q45 {

	
	int maxShares(int a[], int n) {
		int sum = 0;
		int i, m;
		for (i = 0; i < n; i++)
			sum += a[i];
		for (m = n; m >= 2; m--) {
			if (sum % m != 0)
				continue;
			int[] aux = new int[n];
			for (i = 0; i < n; i++)
				aux[i] = 0;
			if (testShares(a, n, m, sum, sum / m, aux, sum / m, 1) == 1)
				return m;

		}
		 return 1;
	}
	
	int testShares(int a[], int n, int m, int sum, int groupsum, int[] aux,
			int goal, int groupId) {
		if (goal == 0) {
			groupId++;
			if (groupId == m + 1)
				return 1;
		}
		for (int i = 0; i < n; i++) {
			if (aux[i] != 0)
				continue;
			aux[i] = groupId;
			if (testShares(a, n, m, sum, groupsum, aux, goal - a[i], groupId)==1) {
				return 1;
			}
			aux[i] = 0;
		}
		return 1;
	}
}
