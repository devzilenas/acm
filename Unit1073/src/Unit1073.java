/**
 * Find the lowest number of numbers so that N is the sum of squares of those numbers.
 *
 * N = a^a + b^b + c^c + d^d 
 * 
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1073 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	public static final int MAXN = 60;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static int zero(int a) {
		return a == 0 ? a : 1;
	}

	/**
	 * Use Lagrange's 4 Square theorem, check only (this is short-cut) for 1, 2, 3. If no squares found, then output 4.
	 */
	public static int bruteForceLagrange(int N) {
		int min = 4;
		int temp = 0;
		int a;
		int b;
		for (int i = (int) Math.sqrt(N); i > 0; i--) {
			a = i*i;
			for (int j = 0; j <= (int) Math.sqrt(N - a); j++) {
				b = a + j*j;
				for (int k = 0; k <= (int) Math.sqrt(N - b); k++) {
					if (b + k*k == N) {
						if (!isOj()) {
							out.format("%1$d %2$d %3$d", i, j, k);
							out.println();
						}
						temp = zero(i) + zero(j) + zero(k);
						if (min > temp) {
							min = temp;
						}
					}
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int N     = in.nextInt();
		out.println(bruteForceLagrange(N));
		out.flush();
	}

}

