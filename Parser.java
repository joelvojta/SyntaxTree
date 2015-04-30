public class Parser
{
	private String theStmt;
	private int pos; //where am I in the theStmt string
	private static final String legalVariableCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "; 
	private static final String legalOpCharacters = "+-*/% ";
	
	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		
		this.pos = 0;
	}
	
	void parse()
	{
		this.parse_stmt();
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
	
	private void parse_stmt()
	{
		//Print each time it reads something like:
		// Read: VarName = a
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		System.out.println("Read VarName: " + varName);
		VarExpression FirstVarExp = new VarExpression(varName);  //create variable that contains the varName
		
		
		//burn past the =
		this.getNextToken('=');
		System.out.println("Burned =");
		
		// Reading: Math-Expr
		MathExpression FirstMathExp = this.parse_math_expr();  //parse the first math expression and save it
		
		
		//burn past the ;
		this.getNextToken(';');
		System.out.println("Burned ;");
		
		//Build VarDefStatement here!!!!
		VarDefStatement FirstVarDefStmt = new VarDefStatement(FirstVarExp, FirstMathExp);	//the FirstVarDefStmt will contain the variables FirstVarExp and FirstMathExp
		System.out.println(FirstVarDefStmt);
	}
	
	private MathExpression parse_math_expr()  //we have to find three parts in this method:  The left, the right, and the middle
	{
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		Expression rightOperand = null; //start them off empty
		Expression leftOperand = null;
		
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			System.out.println("Burned (");
			this.parse_math_expr();
			this.getNextToken(')');
			System.out.println("Burned )");
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			leftOperand = new VarExpression(varName);  //fill in leftOperand variable
			
		}
		String op = this.getNextToken(Parser.legalOpCharacters);
		System.out.println("Read Op: " + op);
		OpExpression Op = new OpExpression(op);  //fill Op with the operator we found
		
		varName = this.getNextToken(Parser.legalVariableCharacters);
		if(varName.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			System.out.println("Burned (");
			this.parse_math_expr();
			this.getNextToken(')');
			System.out.println("Burned )");
		}
		else
		{
			System.out.println("Read VarName: " + varName);
			rightOperand = new VarExpression(varName);	//fill in rightOperand with what we found
		}
		return new MathExpression(leftOperand, rightOperand, Op);  //our MathExpression contains the leftOperand, rightOperand, and op
	}
}