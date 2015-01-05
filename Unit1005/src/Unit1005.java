import java.util.Scanner;
import java.io.PrintWriter;
import java.lang.Math;

/**
 * Brute force approach.
 */
public class Unit1005 {
	public static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	public static boolean isOj() {
		return oj;
	}

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(
				System.out);
		Scanner in = new Scanner(
				System.in);

		int n = in.nextInt();
		int[] ws = new int[n];

		int i = 0;

		for (i = 0; i < n; i++) {
			ws[i] = in.nextInt();
		}

		/**
		 * Produce all possible binary numbers of length N.
		 */
		long min  = ws[0];
		long sum  = 0L;

		if (n > 1) {
			for (i = 1; i < Math.pow(2, n) - 1; i++) {
				// now calculate a sum
				sum = 0;
				for (int j = 0; j < n; j++) {
					/** each bit */
					sum = sum + ((i & (1 << j)) > 0 ? ws[j] : -ws[j]);
				}
				if (i != 1) {
					if (Math.abs(sum) < min) {
						min = Math.abs(sum);
					}
				} else {
					min = Math.abs(sum);
				}
			}
		} 
		out.println(min);
		out.flush();
	}

}
