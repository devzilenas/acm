/**
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1017 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	public static long[] fs;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static void f(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n;  j >= i; j--) {
				fs[j] += fs[j-i];
			}
		}
	}

	public static void main(String[] args) {
		int N = in.nextInt(); 
		fs = new long[N+1];
		for (int i = 1 ; i <= N; i++) {
			fs[i] = 0;
		} 
		fs[0] = 1;
		f(N);
		out.println(fs[N]-1);
		out.flush();
	}


}

