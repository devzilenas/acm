/**
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Uses formula 
 *
 * S = S1 + S2;
 * S1 = 4*(a/2 * Math.sqrt(r^2-(a/2)^2)) //4 triangles area
 * S2 = 4*Math.PI*r^2*(90 - Math.arcos(a/(2*r)))/360 ; //4 segments area
 */

public class Unit1084 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static void main(String[] args) {
		double a = in.nextDouble();
		double r = in.nextDouble();
		double S = 0.0;

		if (r <= a/2.0d) {
			S = Math.PI*r*r;
		} else if (r >= Math.sqrt(2.0d*a*a)/2.0d) {
			S = a*a;
		} else {
			S = 4.0d*(a/2.0d) * Math.sqrt(r*r - (a/2.0d)*(a/2.0d))
				+ 4.0d*Math.PI*r*r*(Math.PI/2.0d - 2.0d*Math.acos(a/(2.0d*r) ) )/(2.0d*Math.PI);
		}

		out.format("%.3f", S);

		out.flush();
	}

}

