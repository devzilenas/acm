/**
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1021 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static final int MAGIC = 10000;
	public static final int N     = 76000;
	public static final int NOVAL  = -32769;
	public static final int MAXVAL = 32767; 

	public static boolean isOj() {
		return oj;
	}

	public static boolean isMagic(int a, int b) {
		return MAGIC == a+b;
	}

	public static int toIndex(int n) {
		return n + MAXVAL;
	}

	public static void main(String[] args) {
		int n    = in.nextInt();
		int[] n1 = new int[N];
		int tn = 0;
		int nn = 0;
		int i  = 0;
		boolean found = false; 
		
		for ( i = 0; i < N; i++) {
			n1[i] = NOVAL;
		}

		for (i = 0; i < n; i++) {
			nn = in.nextInt();
			n1[toIndex(nn)] = nn;
		}

		nn = in.nextInt();
		for (i = 0; i < nn; i++) {
			tn = in.nextInt();

			/** tn + n = 10000 */
			if (!found && NOVAL != n1[toIndex(MAGIC - tn)]) {
				found = true;
			}
		}

		out.print(found ? "YES" : "NO");
		out.flush();
	}

}

