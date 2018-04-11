package test;

import javassist.gluonj.util.Loader;
import stone.env.BasicEvaluator;
import stone.env.BasicInterpreter;

public class Runner {
	public static void main(String[] args) throws Throwable {
		Loader.run(BasicInterpreter.class, args, BasicEvaluator.class);
	}
}
