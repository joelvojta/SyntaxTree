public class Parser 
{
	private String theStmt;
	private int pos; //where am I in the theStmt string

	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.pos = 0;
	}
	
	void parse()
	{
		this.parse_stmt();
	}
	
	private void parse_stmt()
	{
		theStmt = theStmt.replaceAll("\\s","");  //this will take away all the empty spaces, making it easier to navigate
		String theVar = ""; //the first variable
		
		for (int i = this.pos; i < theStmt.indexOf("="); i++)  //in case the variable has multiple characters
		{
			theVar = theVar + theStmt.charAt(pos);
			pos++;
		}
		pos++;
		System.out.println("Read: Varname = " + theVar);
		String mathExpr = theStmt.substring(pos);   //finds the expression and makes it into string
		System.out.println("Reading Math Expr: " + mathExpr);
		parse_math_expr();
		}
	
		//Print each time it reads something like:
		// Read: VarName = a
		// Reading: Math-Expr
		
		//read a var name
		//read a math_expr
	
	private void parse_math_expr()
	{
		String inside = "";  //create a string for expressions within ()
		String theLeft = "";
		String theRight = "";
		
		//THIS IS THE PART WHERE THINGS MESS UP FOR ME
		if(theStmt.indexOf("(") == pos) //is there another math expression here?
		{
			for(int i = pos + 1; i < theStmt.indexOf(")"); i++) //only pay attention to what's inside the ()
			{
				inside = inside + theStmt.charAt(i); //create the inside expression string
				System.out.println(inside);  
				pos++;  
				parse_math_expr(); //restart loop with string inside
			}
		}
		
		//THIS PART SEEMS TO WORK OK, FOR THE MOST PART
		else 
		{
			//theLeft variable is everything up to the next operator
			for (int i = this.pos; i < theStmt.indexOf("*") || i < theStmt.indexOf("/") || i < theStmt.indexOf("+") || i < theStmt.indexOf("-") || i < theStmt.indexOf("%");  i++)  
			{
				theLeft = theLeft + theStmt.charAt(pos);
				pos++;
			}
			System.out.println("Reading Left: " + theLeft);
			System.out.println("Reading Operator: " + theStmt.charAt(pos));
			pos++;
			//the right variable ends before the ) or the ;
			for (int i = this.pos; i < theStmt.indexOf(")") || i < theStmt.indexOf(";");  i++)  
			{
				theRight = theRight + theStmt.charAt(pos);
				pos++;
			}
			System.out.println("Reading Right: " + theRight);
		}
	}
}



	