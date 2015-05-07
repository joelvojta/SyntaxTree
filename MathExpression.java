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
	
	public int doMath()
	{
		int theLeftNum;
		int theRightNum;
		if(this.leftOperand instanceof VarExpression)
		{
			Variable Va = this.leftOperand
			
			
			
			
			//create a new variable
			//hw crap here
			theLeftNum = -1;
		}
		else if(this.leftOperand instanceof LitExpression)
		{
			theLeftNum = ((LitExpression) this.leftOperand).getTheLiteral();
		} 
		else
		{
			theLeftNum = ((MathExpression)this.leftOperand).doMath();
		}
		
		if(this.rightOperand instanceof VarExpression)
		{
			
			
			
			
			
			
			
			
			
			//hw crap here
			theRightNum = -1;
		}
		else if(this.rightOperand instanceof LitExpression)
		{
			theRightNum = ((LitExpression) this.rightOperand).getTheLiteral();
		} 
		else
		{
			theRightNum = ((MathExpression)this.rightOperand).doMath();
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