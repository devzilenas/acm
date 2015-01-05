import java.util.Scanner;
import java.io.PrintWriter;
public class Unit1025 {

	/** My bubble Sort algorithm :) */
	public static class BubbleSort {
		public static void sort(int[] a) {
			boolean swapped;
			int tmp;
			int minj;
			for (int i = 0; i < a.length; i++) {
				swapped = false;
				minj = i; 
				for (int j = i; j < a.length; j++) {
					if (a[j] < a[minj]) {
						minj = j;
					}
				}
				if (i != minj) {
					tmp = a[i];
					a[i] = a[minj];
					a[minj] = tmp;
					swapped = true;
				} else {
					swapped = false;
				}
				if (!swapped) {
					continue;
				}
			}
		}
	}

	public static int capture(int size) {
		return (size + size % 2) / 2;
	}

	/** 
	 * Sort groups by size, then fill all groups by one until more than half is captured. 
	 */

	public static void main(String[] args) {
		Scanner     in  = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int[] groups = new int[in.nextInt()];
		int sum = 0;

		if (groups.length > 0) {
			for ( int i = 0; i < groups.length; i++ ) { 
				groups[i] = in.nextInt();
			}

			BubbleSort.sort(groups);

			int half = (groups.length + groups.length % 2) / 2;
			for (int i = 0; i < half; i++) {
				sum += capture(groups[i]);
			}
		}

		out.println(sum);
		out.flush();

	}

}

