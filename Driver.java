public class Driver 
{
	public static void main(String[] args)
	{
		Parser p = new Parser("a=5;     apple =     (a *   7) - 3;");
		p.parse();
		VarDefStatement vds = p.getTheSytaxTree();
		System.out.println(vds);
		
		
		
		/*
		 * We need to be able to handle a new kind of statement.
		 * A var def statement can now handle having a literal on
		 * the right instead of just a math expression.  When this
		 * occurs, that variable/lit-value pair needs to be stored
		 * somewhere, so we can look it up later when we doMath.  You
		 * might choose to create a VariableEnvironment object that holds
		 * an array of Variable objects, where a Variable object
		 * holds a variable name and a integer value.  The VariableEnv
		 * should allow us to add variables to it, and retrieve the 
		 * value given a variable name.  Then finish doMath to support
		 * variables.  Note that your parser must now be able to parse
		 * multiple statements in a row. (ie things separated by ;)
		 */
		
		
		//variables and expressions are very similiar.  We should treat both variable naming and Math expressions the same, until
		// we meet a premature ;   Then, we make it a variable.
		//
	}
}