public class Parser 
{
	private String theStmt;
	private int pos; //where am I in the theStmt string
	private static final String legalVariableCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "; 
	private static final String legalOpCharacters = "+-*/% ";
	private VarDefStatement theSytaxTree;
	
	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.theSytaxTree = null;
		this.pos = 0;
	}
	
	public VarDefStatement getTheSytaxTree() {
		return theSytaxTree;
	}

	void parse()
	{
		this.theSytaxTree = this.parse_stmt();
	}
	
	private String getNextToken(char c)
	{
		while(pos < this.theStmt.length())
		{
			if(this.theStmt.charAt(pos) == c)
			{
				pos++;
				break;
			}
			pos++;
		}
		return "" + c;
	}
	
	private String getNextToken(String legalChars)
	{
		String token = "";
		while(pos < this.theStmt.length())
		{
			if(legalChars.indexOf(this.theStmt.charAt(pos)) != -1)
			{
				token += this.theStmt.charAt(pos);
			}
			else
			{
				//this means we are at the end of the token
				//We are always trimming leading and trailing spaces
				//move forward one
				break;
			}
			pos++;
		}
		return token.trim();
	}
	
	private VarDefStatement parse_stmt()
	{
		//Print each time it reads something like:
		// Read: VarName = a
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		System.out.println("Read VarName: " + varName);
		VarExpression theVE = new VarExpression(varName);
		
		//burn past the =
		this.getNextToken('=');
		System.out.println("Burned =");
		
		// Reading: Math-Expr
		MathExpression theME = this.parse_math_expr();
		
		//burn past the ;
		this.getNextToken(';');
		System.out.println("Burned ;");
		
		return new VarDefStatement(theVE, theME);
	}
	
	private MathExpression parse_math_expr()
	{
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		Expression leftOperand = null;
		Expression rightOperand = null;
		OpExpression theOpExpression = null;
		
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			System.out.println("Burned (");
			leftOperand = this.parse_math_expr();
			this.getNextToken(')');
			System.out.println("Burned )");
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			leftOperand = new VarExpression(varName);
		}
		String op = this.getNextToken(Parser.legalOpCharacters);
		System.out.println("Read Op: " + op);
		theOpExpression = new OpExpression(op.charAt(0));
		
		varName = this.getNextToken(Parser.legalVariableCharacters);
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			rightOperand = this.parse_math_expr();
			this.getNextToken(')');
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			rightOperand = new VarExpression(varName);
		}
		return new MathExpression(leftOperand, rightOperand, theOpExpression);
	}
}