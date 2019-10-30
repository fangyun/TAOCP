package cn.kiloword.taocp.ex1_1_8;

/**
 * Reference: https://readingtaocp.wordpress.com/2008/09/13/markov-algorithms-in-scala/
 * 
 * @author fangyun
 *
 */
public class Markov {
	private static Algorithm absDiff = new Algorithm(new StepParams[] { new StepParams("ab", "", 0, 1),
			new StepParams("a", "c", 1, 2), new StepParams("b", "c", 2, 3) });

	private static Algorithm min = new Algorithm(
			new StepParams[] { new StepParams("ab", "d", 1, 3), new StepParams("ad", "d", 2, 3),
					new StepParams("db", "dd", 1, 3), new StepParams("a", "", 3, 4), new StepParams("b", "", 4, 5) });

	// The gcd algorithm, Exercise 8, Section 1.1
	private static Algorithm gcd = new Algorithm(
			new StepParams[] { new StepParams("ab", "", 1, 2), new StepParams("", "c", 0, 2),
					new StepParams("a", "b", 2, 3), new StepParams("c", "a", 3, 4), new StepParams("b", "b", 0, 5) });

	public static void main(String[] args) {
		String in;
		if (args.length > 1) {
			in = new Markov().buildGcdString(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		} else {
			in = "aaabb";
		}
		System.out.println("absDiff: " + absDiff.exec(in).length());
		System.out.println("min    : " + min.exec(in).length());
		System.out.println("gcd    : " + gcd.exec(in).length());
	}

	public String replicate(int n, char c) {
		StringBuffer sb = new StringBuffer(n);
		for (int i = 1; i <= n; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

	public String buildGcdString(int m, int n) {
		return replicate(m, 'a') + replicate(n, 'b');
	}
}
