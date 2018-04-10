package test;

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

public class ParserRunner {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		InputStream in = new FileInputStream("/home/chenyao/eclipse-workspace/stone/src/test/test.txt");
		InputStreamReader reader = new InputStreamReader(in, Charset.forName("utf-8"));
		Lexer l = new Lexer(reader);
		BasicParser bp = new BasicParser();
		while (l.peek(0) != Token.EOF) {
			ASTree ast = bp.parse(l);
			System.out.println("=> " + ast.toString());
		}
		
	}
}
