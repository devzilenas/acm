/** 
 * @author Marius Žilėnas <mzilenas@gmail.com>
 */
import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1044 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static int getDigitsSum(int number) {
		int tmp = number;
		int sum = 0;
		int rem = 0;
		while (tmp > 0) {
			rem = tmp % 10;
			tmp = (tmp - rem) / 10;
			sum += rem;
		}
		return sum;
	}

	public static void main(String[] args) {
		int n  = in.nextInt();
		int tn = (int) Math.pow(10, n/2); 
		int[] sum = new int[tn];
		int i = 0;
		int j = 0;
		int tmpSum = 0;
		int count  = 0;

		/** Calculate all sums */
		for (i = 0; i < tn; i++) {
			sum[i] = getDigitsSum(i);
		}

		/** Run through all sums and check for equal */
		for (i = 0; i < sum.length; i++) {
			tmpSum = sum[i];
			for (j = 0; j < sum.length; j++) {
				if (tmpSum == sum[j]) {
					count++;
				}
			}
		}

		out.println(count);
		out.flush();
	}

}

