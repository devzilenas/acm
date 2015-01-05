/**
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Unit1012 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static long f(int N, int K) {
		if (1 == N) {
			return K-1;
		} else if (2 == N) {
			return (K-1)*K;
		} else {
			return f(N-1, K)*(K-1) + f(N-2, K)*(K-1);
		}
	}

	public static void main(String[] args) {
		int N = in.nextInt();
		int K = in.nextInt(); 
		BigInteger k1 = new BigInteger((new Integer(K-1)).toString());
		BigInteger k  = new BigInteger((new Integer(K)).toString());
		BigInteger[] register = new BigInteger[3];
		/** fill register and calculate */
		register[0] = k1;
		register[1] = k1.multiply(k);

		for (int i = 2; i < N; i++) {
			register[2] = register[1].multiply(k1).
					add(register[0].multiply(k1));
			register[0] = register[1];
			register[1] = register[2];
		}

		out.println(register[1]);
		out.flush();
	}

}

