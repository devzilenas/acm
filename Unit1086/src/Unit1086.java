/** 
 * @author Marius Žilėnas <mzilenas@gmail.com>
 */
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Unit1086 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static boolean isPrime(int n) {
		boolean isPrime = true; 
		/** check if n is prime */
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0 && i != n) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static void makePrimes(int maxCount) {
		int count = maxCount;
		int n = 2;
		do {
			if (isPrime(n)) {
				primes.add(n);
				count--;
			}
			n++;
		} while (count > 0);
	}

	public static void main(String[] args) {
		int k = in.nextInt();
		int i = 0;
		int maxPrimes = 0;
		int[] ns = new int[k];

		/** Find primes up to count */
		for (i = 0; i < k; i++) {
			ns[i] = in.nextInt();
			if (ns[i] > maxPrimes) {
				maxPrimes = ns[i];
			}
		}

		makePrimes(maxPrimes);

		for (i = 0; i < k; i++) {
			out.println(primes.get(ns[i]-1));
		}

		out.flush();
	}

}


