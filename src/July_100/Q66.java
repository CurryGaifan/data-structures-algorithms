package July_100;
import java.util.Stack;

public class Q66 {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s);
		reverse(s);
		System.out.println(s);

	}

	static void reverse(Stack stack) {
		if (stack.size() == 1)
			return;
		Object o = stack.pop();
		reverse(stack);
		putToBottom(stack, o);
	}

	static void putToBottom(Stack stack, Object o) {
		if (stack.isEmpty()) {
			stack.push(o);
			return;
		}
		Object o2 = stack.pop();
		putToBottom(stack, o);
		stack.push(o2);
	}

}
