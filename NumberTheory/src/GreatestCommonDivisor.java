
public class GreatestCommonDivisor {
	public static int gcd(int a, int n) {
		if (n == 0) {
			return a;
		}
		return gcd(n, a % n);
	}

	public static boolean checkIfRelativelyPrime(int a, int n) {
		int x = gcd(a, n);
		if (x == 1) {
			return true;
		}
		return false;
	}
}
