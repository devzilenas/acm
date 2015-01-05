import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Find sum of all numbers in range [1;N], for N is abs(N) < 10000 valid.
 */
public class Unit3 {
	public static void main(String args[]) {
		Scanner     in  = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int sum = 0;
		int N = in.nextInt();
		if (N > 0) {
			for (int i = 0; i <= N; i++) sum+=i; 
		} else if (N < 0) {
			for (int i = N; i <= 1; i++) sum+=i; 
		} else if (N==0) {
			sum = 1;
		}
		out.println( sum );
		out.flush();
	}
}

