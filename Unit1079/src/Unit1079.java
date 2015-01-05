/** 
 * @author Marius Žilėnas <mzilenas@gmail.com> 
 */
import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1079 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static int   max       = 0;
	public static int[] a;
	public static final int MAX_N = 99999;
	public static final int NOVAL = -1;

	public static boolean isOj() {
		return oj;
	}

	public static void init() {
		a = new int[MAX_N+1];
		a[0] = 0;
		a[1] = 1;
		for (int i = 2; i < a.length; i++) {
			a[i] = -1;
		}
	}

	public static void checkMax(int n) {
		if (max < n) {
			max = n;
		}
	}

	public static int an(int n) {
		int res = a[n];
		if (NOVAL != res) {
			checkMax(res);
			return res;
		} else if(n % 2 == 0) {
			checkMax(an(n/2));
			return a[n] = an(n/2);
		} else {
			checkMax( an((n-1)/2) 
					+ an((n-1)/2 + 1) );
			return a[n] = (an((n-1)/2) + an((n-1)/2 + 1));
		}

	}

	public static void main(String[] args) {
		int n;
		init();

		while ( (n = in.nextInt()) != 0 ) {
			max = 0;
			for (int i = 0; i <= n; i++) {
				an(i);
			}
			out.println(max);
		}

		out.flush();
	}

}

