package July_100;

public class Q30 {

	public static void main(String[] args) {
		int n = 3456;
		int sum = 0;
		for (int i = n; i > 0; i--) {
			sum += helper(i);
		}

		System.out.println(sum);
	}

	private static int helper(int n) {

		int counter = 0;
		int temp = n;
		while (temp > 0) {
			if (temp % 10 == 1)
				counter++;
			temp /= 10;
		}
		return counter;
	}

}
