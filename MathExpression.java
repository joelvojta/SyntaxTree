public class MathExpression extends Expression
{
	private Expression leftOperand;  //MathExpression will contain the left, right, and operator
	private Expression rightOperand;
	private OpExpression operator;
	
	public MathExpression(Expression leftOperand, Expression rightOperand, OpExpression operator)
	{
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operator = operator;
	}
	
	public String toString()
	{
		if(leftOperand instanceof MathExpression && rightOperand instanceof MathExpression) //if both sides are a math expression, put parenthesis around both of them
		{
			return "(" + leftOperand.toString() + ")" + operator.toString() + "(" + rightOperand.toString() + ")";    
		}
		if(leftOperand instanceof MathExpression) //if the left is a math expression, put a parenthesis around that and continue
		{
			return "(" + leftOperand.toString() + ")" + operator.toString() + rightOperand.toString();
		}
		if(rightOperand instanceof MathExpression) //if the right is a math expression, put a parenthesis around that and continue
		{
			return leftOperand.toString() + operator.toString() + "(" + rightOperand.toString() + ")";
		}
		return leftOperand.toString() + operator.toString()+ rightOperand.toString();  //if the statement is normal, print it out normally
	}
}