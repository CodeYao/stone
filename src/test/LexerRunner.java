package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import stone.Lexer;
import stone.ParseException;
import stone.Token;

public class LexerRunner {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		InputStream in = new FileInputStream("/home/chenyao/eclipse-workspace/stone/src/test/test.txt");
		InputStreamReader reader = new InputStreamReader(in, Charset.forName("utf-8"));
		Lexer l = new Lexer(reader);
		for (Token t; (t = l.read()) != Token.EOF;) {
			System.out.println("=> " + t.getText());
		}
		
	}

}
