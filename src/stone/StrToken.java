package stone;

public class StrToken extends Token {
	private String literal;
	
	protected StrToken(int line, String str) {
		super(line);
		literal = str;
	}
	
	public boolean isIdentifier() {return true;}
	public String getText() {return literal;}
}
