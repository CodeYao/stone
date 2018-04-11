package stone.env;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import stone.BasicParser;
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
		InputStream in = null;
		try {
			in = new FileInputStream("/home/chenyao/eclipse-workspace/stone/src/test/test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader reader = new InputStreamReader(in, Charset.forName("utf-8"));
		Lexer lexer = new Lexer(reader);
		while(lexer.peek(0) != Token.EOF) {
			ASTree t = basicParser.parse(lexer);
			if(!(t instanceof NullStmnt)) {
				Object r = ((ASTreeEX)t).eval(basicEnv);
				System.out.println("=> " + r);
			}
		}
	}
}
