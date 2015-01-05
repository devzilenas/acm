/**
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1023 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	/**
	 * 3 <= K <= 10^8
	 * 2 <= L < K
	 * Must find smallest divisor of K.
	 */
	public static void main(String[] args) {
		long K = in.nextInt();
		long d = 1;

		for (long i = 3; i <= K; i++) {
			if ( K % i == 0) {
				d = i;
				break;
			}
		}

		out.println(d-1);
		out.flush();
	}

}

