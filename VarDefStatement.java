
public class VarDefStatement 
{
	private VarExpression theVarExpr; //the first part
	private MathExpression theMathExpr;//the second part
	
	public VarDefStatement(VarExpression theVarExpr, MathExpression theMathExpr) //all the components of the VarDefStatement
	{
		this.theVarExpr = theVarExpr;
		this.theMathExpr = theMathExpr;
	}
}