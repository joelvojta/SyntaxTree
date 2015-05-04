

public class VarDefStatement extends Object //invisible part extends Object //Object is the parent of anything with "invisible ink"
{
	private VarExpression theVarExpr;
	private MathExpression theMathExpr;
	
	public VarDefStatement(VarExpression theVarExpr, MathExpression theMathExpr)
	{
		this.theVarExpr = theVarExpr;
		this.theMathExpr = theMathExpr;
	}
	
	public String toString()
	{
		//getClass().getName() + '@' + Integer.toHexString(hashCode());
		
		return theVarExpr.toString() + "=" + theMathExpr.toString() + ";";
		//write this such that it rebuilds the String version
		//of the original statement.  You MAY NOT just use the
		//store string variable theStmt.
	}
}