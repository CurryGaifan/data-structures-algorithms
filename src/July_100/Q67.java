package July_100;
import java.util.HashMap;
import java.util.Map;

public class Q67 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		int n = 3;

		getAll(n);

	}

	private static void getAll(int n) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = n; i < 6 * n + 1; i++) {
			for (int j = 1; j < 6 + 1 && j < i - n + 2; j++) {
				sum += j;
				helper(n - 1, i - j, j, map);
				sum -= j;
			}

		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue() + "/"
					+ (int) Math.pow(6, n));
		}

	}

	private static void helper(int n, int m, int sum, Map<Integer, Integer> map) {
		if (n == 0) {
			if (m == 0) {
				Integer obj = map.get(sum);
				if (obj == null) {
					map.put(sum, 1);
				} else {
					map.put(sum, obj + 1);
				}
				return;
			} else
				return;

		}
		for (int j = 1; j < 6 + 1 && j < m - n + 2; j++) {
			sum += j;
			helper(n - 1, m - j, sum, map);
			sum -= j;
		}

	}

}
