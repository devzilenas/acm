import java.util.Scanner  ;
import java.io.PrintWriter;
import java.lang.Math     ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

/**
 * Q     = x*y*z*q;
 * x     = [1..9] ;
 * y,z,q = [0..9] ; 
 *
 */
public class Unit1014 { 
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	public static boolean isOj() {
		return oj;
	}

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static long prod(ArrayList<Integer> Q) {
		long prod = 1;
		/** each figure */ 
		for (Iterator<Integer> it = Q.iterator(); it.hasNext(); ) {
			prod = prod*it.next();
		}

		return prod;
	}

	public static void print(ArrayList<Integer> list) {
		for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
			out.print(it.next()+",");
		}
		out.println();
	}

	public static void main(String[] args) {
		
		int N  = in.nextInt();
		int tN = N;
		int q  = 2;
		ArrayList<Integer> qs = new ArrayList<Integer>();
		int minj;
		int j = 0;
		int i = 0;

		boolean zipped = false;
		while (q <= 9 && tN > 1) {
			while (tN % q == 0) {
				qs.add(q);
				tN = tN / q;
			}
			q++;
		}

		if (qs.size() > 1) do {
			zipped = false;
			for (i = qs.size() - 1; i >= 1; i--) {
				if (qs.get(i-1)*qs.get(i) <= 9) {
					qs.set(i-1, qs.get(i-1)*qs.get(i));
					qs.remove(i);
					zipped = true;
					break;
				}
			}
		} while (zipped);

		Collections.sort(qs);
		if (qs.size() > 0 && prod(qs) == N) {
			for (Iterator<Integer> it = qs.iterator(); it.hasNext(); ) {
				i = it.next();
				if (-1 != i) {
					out.print(i);
				}
			}
		} else if (N == 0) {
			out.print(10);
		} else if (N == 1) { 
			out.print(1);
		} else {
			out.print(-1);
		}
		out.flush();

	}
}

