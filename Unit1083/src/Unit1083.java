import java.util.Scanner;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.math.BigInteger;

public class Unit1083 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n    = in.nextInt();
		int k    = in.next().length();
		int last = (n % k != 0 ? n % k : k);
		int i    = 0;

		BigInteger sum  = BigInteger.ONE;
		while (n - i*k >= last) {
			sum = sum.multiply(
					new BigInteger(
						(new Integer(n - i*k)).toString()));
			i++;
		}

		out.println(sum);
		out.flush();

	}

}
