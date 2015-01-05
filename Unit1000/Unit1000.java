import java.util.Scanner;
import java.io.PrintWriter;

public class Unit1000 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int a = in.nextInt();
		int b = in.nextInt();

		out.println(a+b);
		
		out.flush();
	}
}

