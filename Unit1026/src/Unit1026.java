/**
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1026 {

	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	public static int maxN  = 5000 + 1;
	public static int NOVAL = 0;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static void main(String[] args) {
		int   N = in.nextInt();
		int[] numbers = new int[maxN];
		int   i = 0;

		for (i = 0 ; i < maxN; i++) {
			numbers[i] = NOVAL;
		}

		int n = 0;
		for (i = 0; i < N; i++) {
			n = in.nextInt();
			numbers[n]++;
		}

		/** skip ### */
		in.next();
		int K = in.nextInt();
		int x = 0;

		for (i = 0; i < K; i++) {
			x = in.nextInt();

			/** skip x numbers */
			int count = 0;
			int j     = 0;
			while (count < x) {
				count += numbers[j];
				j++;
			}
			out.println(j-1);
		}
		out.flush();
	}

}

