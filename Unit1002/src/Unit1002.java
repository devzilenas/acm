/**
 * @author Marius Žilėnas <mzilenas@gmail.com>
 * 2013
 */
import java.util.Scanner      ;
import java.io.PrintWriter    ;
import java.util.ArrayList    ;
import java.lang.StringBuilder;

import mzilenas.trie.*;

public class Unit1002 {
	public static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	public static final String END       = "-1";
	public static final String NOSOLUTION= "No solution.";

	static PrintWriter out = new PrintWriter(
			System.out);
	static Scanner in ;

	public static String getData() {
		return "7325189087 5 it your reality real our 4294967296 5 it your reality real our -1";
	}

	public static boolean isOj() {
		return oj;
	}

	static void init() {
		if (isOj()) {
			in = new Scanner(System.in);
		} else {
			in = new Scanner(getData());
		}
	}

	public static void main(String[] args) {
		init();

		Trie   trie = new Trie();
		Word   word ;
		List<String> words = new ArrayList<String>();
		String number;
		int    n;

		for (;;) {
			/** read number */
			number = in.next();
			out.println("number:"+number);
			out.flush();

			/** Has testing ended? */
			if (number.equals(END)) {
				break;
			}

			n = in.nextInt();
			out.println("lines:"+n);

			for (int i=0 ; i < n; i++) {
				/** read a word and test it */
				word = new Word(in.next());
				out.println("word:"+word.asWord());
				out.println("encoded"+word);
				/** if has a word */
				if (-1 != number.indexOf(word)) {
					trie.put(word);
				}
			}
			trie.out.contents();
		} 
		out.flush();
	}

}

class Word {
	String word  ;
	String number;

	void setWord(String word) {
		this.word = word;
	}
	void setNumber(String number) {
		this.number = number;
	}
	String getNumber() {
		return number;
	}
	String getWord() {
		return word;
	}
	public String asNumber() {
		if (null == number) {
			setNumber(encoded(this));
		}
		return number;
	}
	public String encoded() {
		return asNumber();
	}
	public Word(String word) {
		setWord(word);
	}
	public String toString() {
		return encoded();
	}
	public String encoded(Word word) {
		StringBuilder code = new StringBuilder();
		int  x = 0;
		for (char c : word.toString().toCharArray()) {
			if ('i' == c || 'j' == c) {
				x = 1;
			} else if ('a' == c || 'b' == c || 'c' == c) {
				x = 2;
			} else if ('d' == c || 'e' == c || 'f' == c) {
				x = 3;
			} else if ('g' == c || 'h' == c) {
				x = 4;
			} else if ('k' == c || 'l' == c) {
				x = 5;
			} else if ('m' == c || 'n' == c) {
				x = 6;
			} else if ('p' == c || 'r' == c || 's' == c) {
				x = 7;
			} else if ('t' == c || 'u' == c || 'v' == c) {
				x = 8;
			} else if ('w' == c || 'x' == c || 'y' == c) {
				x = 9;
			} else if ('o' == c || 'q' == c || 'z' == c) {
				x = 0;
			}
			code.append(x);
		}

		return code.toString();
	}
}

