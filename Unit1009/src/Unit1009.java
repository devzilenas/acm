import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1009 {

	public static int bruteForce(int N, int K) {
		int[] number = new int[N];

		/**
		 * Init
		 */
		number[N-1] = 1;
		for (int i = 0; i < N; i++) {
			number[i] = 0;
		}

		/** Generate and reverse */
		int count = 0;
		/**
		 * Current position.
		 *   j 
		 * XXXXKKX
		 */
		int j     = N - 1;
		int k     = 0;
		boolean found = false;
		boolean found0 = false;
mainloop:
		do {
			/** 
			 * find last K-th number and start from it
			 */
			found = false;
			while (!found && j > 0) {
				if (number[j] == K - 1) {
					found = true;
				}
				j--;
				if ( j < 0 && !found) {
					break mainloop;
				}
			}
			/**
			 * Overflow detected:
			 *  - zeros to the left
			 *  - increase to the right
			 */
			/**
			 * Zeros to the left
			 */
			k = j;
			while (k > 0) {
				number[k] = 0;
				k--;
			}
			/**
			 * Increase to the right.
			 */
			k = j;
			while (number[k] + 1 == K) {
				number[k] = 0;
				k++;
				if (k == N) {
					/** last index position reached and overflow */
					break mainloop;
				}
			}
			number[k]++;

			/** skip if has leading zero */
			if (number[N - 1] == 0) {
				continue;
			}

			/** check zeros */
			found0  = false;
			for (int i = N - 1; i >= 0; i--) {
				if ( i > 0 && number[i]==0 && number[i-1] == 0) {
					found0 = true;
				}
			}
			if (!found0) {
				count++;
			}
		} while (true);

		return count;
	}

	public static int clever(int N, int K) {
		int res = 0;
		if (N == 2) {
			res = K*(K-1);
		} else if (N == 1) {
			res = K-1;
		} else {
			res = clever(N-1, K)*(K-1) + clever(N-2, K)*(K-1);
		}
		return res;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(
				System.in);
		PrintWriter out = new PrintWriter(
				System.out);

		int N = in.nextInt();
		int K = in.nextInt();

		out.println(clever(N, K));
		out.flush();
	}

}

