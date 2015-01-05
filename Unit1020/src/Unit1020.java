import java.util.Scanner  ;
import java.io.PrintWriter;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Unit1020 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	public static boolean isOj() {
		return oj;
	}

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static double s(Point2D p1, Point2D p2) {
		return Math.sqrt( 
				Math.pow(p2.getX() - p1.getX(), 2)
				+ Math.pow(p2.getY() - p1.getY(), 2));
	}

	public static void main(String args[]) {
		int N = in.nextInt();
		double R = in.nextDouble(); 
		double sum = 0.0d;
		Point2D.Double[] points = new Point2D.Double[N];

		Point2D.Double p;
		for (int i = 0; i < N; i++) {
			points[i] = new Point2D.Double(
					in.nextDouble(),in.nextDouble());
		}

		for(int i = 0; i < N - 1; i++) {
			sum += s(points[i], points[i+1]);
		}
		if (N > 1) {
			/** last and first */
			sum += s(points[0], points[points.length-1]);
		}
		/** add R of one circle */
		sum += 2*Math.PI*R;
		
		out.format("%.2f", sum);
		out.flush();
	}

}

