/**
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.ArrayList;

class Graph {
	/** vertexes */
	final int v;
	int e;

	ArrayList<Integer>[] adj;

	public Graph(int v) {
		this.v = v;
		this.e = 0;

		adj = (ArrayList<Integer>[]) new ArrayList[v]; 

		for (int i = 0 ; i < v ; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		/** directed */
		//adj[w].add(v);
		e++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public int v() {
		return v;
	}
	
	public int e() {
		return e;
	}

}

class DepthFirstOrder {
	boolean[] marked;

	ArrayList<Integer> pre;
	ArrayList<Integer> post;
	Stack<Integer> reversePost;

	public DepthFirstOrder(Graph g) {
		reversePost = new Stack<Integer>();
		pre = new ArrayList<Integer>();
		post = new ArrayList<Integer>();

		marked = new boolean[g.v()];

		for (int v = 0; v < g.v() ; v++) {
			if (!marked[v]) {
				dfs(g, v);
			}
		}
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;

		pre.add(v);
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w);
			}
		}
		post.add(v);
		reversePost.push(v);
	}

	public Iterable<Integer> reversePost() {
		return reversePost;
	}

	public Iterable<Integer> pre() {
		return pre;
	}

	public Iterable<Integer> post() {
		return post;
	}

}

public class Unit1022 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in = new Scanner(
			System.in);

	public static boolean isOj() {
		return oj;
	}

	public static void main(String[] args) {
		int v = in.nextInt();
		int x = 0;
		Graph g = new Graph(v);

		for (int i = 0; i < v; i++) {
			while (0 != (x = in.nextInt())) {
				g.addEdge(x-1, i);
			}
		}

		DepthFirstOrder dfs = new DepthFirstOrder(g);
		Iterable<Integer> order = dfs.reversePost();
		Iterable<Integer> pre   = dfs.pre();
		Iterable<Integer> post  = dfs.post();

		for (int j : order) {
			out.println(j+1);
		}

		out.flush();
	}

}

