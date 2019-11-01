package cn.kiloword.taocp.ex1_1_8;

/**
 * Reference:
 * https://readingtaocp.wordpress.com/2008/09/13/markov-algorithms-in-scala/
 * 
 * @author fangyun
 *
 */
public class Markov {
	private static Algorithm absDiff = new Algorithm(new StepParams[] { //
			new StepParams("ab", "", 0, 1), // 分界上的ab抵消为0.循环此步骤。
			new StepParams("a", "c", 1, 2), // 替换全部a为c
			new StepParams("b", "c", 2, 3) }); // 替换全部b为c

	// 循环步骤2->1
	private static Algorithm min = new Algorithm(new StepParams[] { //
			new StepParams("ab", "d", 1, 3), // 分界上的ab抵消为单d=(m-1,1,n-1)
			new StepParams("ad", "d", 2, 3), // 消前缀=(m-2,1,n-1),(m-3,2,n-2)...
			new StepParams("db", "dd", 1, 3), // 换后缀=(m-2,2,n-2),(m-3,3,n-3)...(m-n,n,0)
			new StepParams("a", "", 3, 4), // 替换全部a
			new StepParams("b", "", 4, 5) }); // 替换全部b

	// The gcd algorithm, Exercise 8, Section 1.1
	private static Algorithm gcd = new Algorithm(new StepParams[] { //
			new StepParams("ab", "", 1, 2), // 分界上的ab抵消为0
			new StepParams("", "c", 0, 2), // 补充前缀c,转步骤0. 这样前两步得到：|m-n|
			new StepParams("a", "b", 2, 3), // 替换全部a为b
			new StepParams("c", "a", 3, 4), // 替换全部c为a
			new StepParams("b", "b", 0, 5) });

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
