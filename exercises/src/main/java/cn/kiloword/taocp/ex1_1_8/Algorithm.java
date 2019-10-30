package cn.kiloword.taocp.ex1_1_8;

public class Algorithm {
	private StepParams[] params;

	public Algorithm(StepParams[] params) {
		this.params = params;
	}

	private boolean replaceIfPossible(StepParams p, StringBuilder s) {
		int i = s.indexOf(p.theta);
		if (i != -1) {
			s.replace(i, i + p.theta.length(), p.phi);
			return true;
		}
		return false;
	}

	private String execLoop(StringBuilder word, int step) {
		if (step == params.length)
			return word.toString();
		else if (replaceIfPossible(params[step], word))
			return execLoop(word, params[step].b);
		else
			return execLoop(word, params[step].a);
	}

	public String exec(String in) {
		return execLoop(new StringBuilder(in), 0);
	}
}
