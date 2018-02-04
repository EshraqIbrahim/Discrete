import java.util.Scanner;

public class ChineseRemainderTheory {

	private static Scanner scan = new Scanner(System.in);
	private static int[] modMemory;
	private static int[] mInverseMemory;
	private static int[] aMemory;
	private static int[] bMemory;
	private static int[] mMemory;

	public static int[] insertValues(int[] reqArray) {
		for (int i = 0; i < reqArray.length; i++) {
			reqArray[i] = scan.nextInt();
		}
		return reqArray;
	}

	public static int getM(int[] reqArray) {
		int M = 1;
		for (int i = 0; i < reqArray.length; i++) {
			M *= reqArray[i];
		}
		return M;
	}

	public static int[] setM(int[] mMemory, int[] modMemory, int M) {
		for (int i = 0; i < modMemory.length; i++) {
			mMemory[i] = (M / modMemory[i]);
		}
		return mMemory;
	}

	public static int[] setMInverse(int[] mInverseMemory, int[] modMemory, int[] mMemory) {
		for (int i = 0; i < modMemory.length; i++) {
			mInverseMemory[i] = MultiplicativeInverse.theMultiplicativeInverse(mMemory[i], modMemory[i]);
		}
		return mInverseMemory;

	}

	public static int chineseRemainderTherom(int[] aMemory, int[] mMemory, int[] mInverseMemory, int M) {
		int ans = 0;
		for (int i = 0; i < aMemory.length; i++) {
			ans += (aMemory[i] * mMemory[i] * mInverseMemory[i]);
		}
		ans = ans % M;
		return ans;
	}

	public static int multiplicationFirstMethod(int a, int b, int M) {
		return ((a * b) % M);
	}

	public static int additionFirstMethod(int a, int b, int M) {
		return ((a + b) % M);
	}

	public static int multiplicationSecondMethod(int[] aMemory, int[] bMemory, int M) {
		long multiplicationStartTime = System.nanoTime();
		int[] multiplyMemory = new int[aMemory.length];
		for (int i = 0; i < aMemory.length; i++) {
			multiplyMemory[i] = aMemory[i] * bMemory[i];
		}
		int ans = chineseRemainderTherom(multiplyMemory, mMemory, mInverseMemory, M);
		long multiplicationStopTime = System.nanoTime();
		long multiplicationElapsedTime = multiplicationStopTime - multiplicationStartTime;
		System.out.println("Multiplication time in nanoseconds : " + multiplicationElapsedTime);
		return ans;

	}

	public static int additionSecondMethod(int[] aMemory, int[] bMemory, int M) {
		long additionStartTime = System.nanoTime();
		int[] additionMemory = new int[aMemory.length];
		for (int i = 0; i < aMemory.length; i++) {
			additionMemory[i] = aMemory[i] + bMemory[i];
		}

		int ans = chineseRemainderTherom(additionMemory, mMemory, mInverseMemory, M);
		long additionStopTime = System.nanoTime();
		long additionElapsedTime = additionStopTime - additionStartTime;
		System.out.println("addition time in nanoseconds : " + additionElapsedTime);
		return ans;

	}

	public static void main(String[] args) {

		boolean check = false;
		do {
			System.out.println("Enter the size of elements in 'm' :");
			int n = scan.nextInt();
			modMemory = new int[n];
			mInverseMemory = new int[n];
			aMemory = new int[n];
			bMemory = new int[n];
			mMemory = new int[n];
			System.out.println("Enter the values of 'a' :");
			aMemory = insertValues(aMemory);
			System.out.println("Enter the values of 'm' :");
			modMemory = insertValues(modMemory);
			int M = getM(modMemory);
			mMemory = setM(mMemory, modMemory, M);
			mInverseMemory = setMInverse(mInverseMemory, modMemory, mMemory);
			System.out.println("Enter the values of 'b' :");
			bMemory = insertValues(bMemory);
			int multiplication = multiplicationSecondMethod(aMemory, bMemory, M);
			System.out.println("The multiplication answer is : " + multiplication);
			int addition = additionSecondMethod(aMemory, bMemory, M);
			System.out.println("The addition answer is : " + addition);
			long additionStartTime = System.nanoTime();
			int aAnswer = chineseRemainderTherom(aMemory, mMemory, mInverseMemory, M);
			int bAnswer = chineseRemainderTherom(bMemory, mMemory, mInverseMemory, M);
			int c = multiplicationFirstMethod(aAnswer, bAnswer, M);
			long additionStopTime = System.nanoTime();
			long additionElapsedTime = additionStopTime - additionStartTime;
			System.out.println("multiplication time in nanoseconds : " + additionElapsedTime);
			additionStartTime = System.nanoTime();
			aAnswer = chineseRemainderTherom(aMemory, mMemory, mInverseMemory, M);
			bAnswer = chineseRemainderTherom(bMemory, mMemory, mInverseMemory, M);
			c = additionFirstMethod(aAnswer, bAnswer, M);
			additionStopTime = System.nanoTime();
			additionElapsedTime = additionStopTime - additionStartTime;
			System.out.println("addition time in nanoseconds : " + additionElapsedTime);
		} while (!check);
	}
}
