public class MathExpression extends Expression
{
	private Expression leftOperand;
	private Expression rightOperand;
	private OpExpression operator;
	
	public MathExpression(Expression leftOperand, Expression rightOperand, OpExpression operator)
	{
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
	}
	
	public Expression getLeftOperand() {
		return leftOperand;
	}

	public Expression getRightOperand() {
		return rightOperand;
	}

	public OpExpression getOperator() {
		return operator;
	}

	public boolean isSpecial()
	{
		return this.rightOperand == null;
	}
	
	public int doMath(VariableEnvi env)
	{
		if(this.rightOperand == null)
		{
			return ((LitExpression)this.leftOperand).getTheLiteral();
		}
		
		int theLeftNum;
		int theRightNum;
		if(this.leftOperand instanceof VarExpression)
		{
			//hw crap here
			theLeftNum = env.resolve(((VarExpression) this.leftOperand).getVarName());
		}
		else if(this.leftOperand instanceof LitExpression)
		{
			theLeftNum = ((LitExpression) this.leftOperand).getTheLiteral();
		} 
		else
		{
			theLeftNum = ((MathExpression)this.leftOperand).doMath(env);
		}
		
		if(this.rightOperand instanceof VarExpression)
		{
			//hw crap here
			theRightNum = env.resolve(((VarExpression) this.rightOperand).getVarName());
		}
		else if(this.rightOperand instanceof LitExpression)
		{
			theRightNum = ((LitExpression) this.rightOperand).getTheLiteral();
		} 
		else
		{
			theRightNum = ((MathExpression)this.rightOperand).doMath(env);
		}
		return this.operator.applyOperator(theLeftNum, theRightNum);
	}
	
	public String toString()
	{
		String result = "";
		if(this.leftOperand instanceof MathExpression)
		{
			result += "(" + this.leftOperand.toString() + ")";
		}
		else
		{
			result += this.leftOperand.toString();
		}
		result += this.operator.toString();
		if(this.rightOperand instanceof MathExpression)
		{
			result += "(" + this.rightOperand.toString() + ")";
		}
		else
		{
			result += this.rightOperand.toString();
		}
		return result;
	}
}