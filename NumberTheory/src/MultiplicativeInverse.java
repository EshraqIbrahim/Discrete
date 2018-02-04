
public class MultiplicativeInverse {
	public static int theMultiplicativeInverse(int a, int n) {
		a = a % n;
		for (int i = 0; i < n; i++) {
			if ((a * i) % n == 1) {
				return i;
			}
		}
		return 0;
	}
}
