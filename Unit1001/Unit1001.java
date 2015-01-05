import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.Iterator;
import java.lang.Math;
import java.math.BigInteger;

public class Unit1001 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Stack stack = new Stack<BigInteger>(); 

		while(in.hasNextBigInteger()) {
			stack.push(in.nextBigInteger());
		}

		for (Iterator<BigInteger> it = stack.iterator(); it.hasNext(); ) {
			out.format("%.4f", Math.sqrt(((BigInteger) stack.pop()).doubleValue()));
			out.println();
		}
		out.flush();
	}

}

