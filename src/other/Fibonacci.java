package other;
public class Fibonacci {
	static int Fibonacci1(int n)//递归
	{

		if (n == 0 || n == 1) {
			return n;
		} else {
			return Fibonacci1(n - 1) + Fibonacci1(n - 2);
		}
	}

	static int Fibonacci2(int n)//额外空间
	{
		int result = 0;
		int a[] = { 0, 1 };
		if (n == 0 || n == 1) {
			return n;
		} else {
			for (int i = 1; i < n; i++) {
				result = a[0] + a[1];
				a[0] = a[1];
				a[1] = result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		long time1= System.currentTimeMillis();
		System.out.println(Fibonacci2(20));
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(Fibonacci1(20));
		long time3 = System.currentTimeMillis();
		System.out.println(time3 - time2);
	}

}
