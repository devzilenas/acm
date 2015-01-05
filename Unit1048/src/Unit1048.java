/**
 * Calculates the sum of two "super long":) numbers.
 *
 * For example (9555 + 0445 = 10000). Input:
 *
 * 4
 * 9 0
 * 5 4
 * 5 4
 * 5 5
 *
 * Output:
 * 100000
 *
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Unit1048 {

	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	public static final int NOVAL = -1;

	static PrintWriter out = new PrintWriter(
			System.out);

	static StreamTokenizer in = new StreamTokenizer(
			new BufferedReader(
				new InputStreamReader(
					System.in)));

	public static boolean isOj() {
		return oj;
	}

	public static int nextInt() throws IOException {
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) {
		try {
			int N = nextInt();
			int i = 0;

			int[] number = new int[N+1];

			number[0] = 0;

			for (i = 1; i <= N; i++) {
				number[i] = nextInt() + nextInt();
			}

			for (i = N; i > 0; i--) {
				if (number[i] >= 10) {
					number[i] -= 10 ;
					number[i-1] += 1;
				}
			}

			if (number[0] != 0) {
				out.print(number[0]);
			}
			for (i = 1; i <= N; i++) {
				if (NOVAL != number[i]) {
					out.print(number[i]);
				}
			}

			out.flush();
		} catch (IOException e) {
			out.print("error!");
		}
	}

}

