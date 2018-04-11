package stone.env;

import stone.BasicParser;
import stone.CodeDialog;
import stone.Lexer;
import stone.ParseException;
import stone.Token;
import stone.ast.ASTree;
import stone.ast.NullStmnt;
import stone.env.BasicEvaluator.ASTreeEX;

public class BasicInterpreter {
	public static void main(String[] args) throws ParseException {
		run(new BasicParser(), new BasicEnv());
	}

	private static void run(BasicParser basicParser, BasicEnv basicEnv) throws ParseException {
		Lexer lexer = new Lexer(new CodeDialog());
		while(lexer.peek(0) != Token.EOF) {
			ASTree t = basicParser.parse(lexer);
			if(!(t instanceof NullStmnt)) {
				Object r = ((ASTreeEX)t).eval(basicEnv);
				System.out.println("=> " + r);
			}
		}
	}
}
