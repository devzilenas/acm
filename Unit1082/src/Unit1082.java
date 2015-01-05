import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1082 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static void main(String[] args) {
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			out.print(i+" ");
		}
		out.flush();
	}

}

