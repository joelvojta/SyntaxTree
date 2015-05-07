

public class VarDefStatement extends Object
{
	private VarExpression theVarExpr;
	private MathExpression theMathExpr;
	
	public VarDefStatement(VarExpression theVarExpr, MathExpression theMathExpr)
	{
		this.theVarExpr = theVarExpr;
		this.theMathExpr = theMathExpr;
	}
	
	public VarExpression getTheVarExpr() {
		return theVarExpr;
	}

	public MathExpression getTheMathExpr() {
		return theMathExpr;
	}

	public boolean isSpecialMathExpr()
	{
		return this.theMathExpr.isSpecial();
	}
	public String toString()
	{
		return this.theVarExpr.toString() + " = " + this.theMathExpr.toString() + ";";
	}
}