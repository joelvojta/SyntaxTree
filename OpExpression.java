
public class OpExpression 
{
	private char theOp;
	
	public OpExpression(char theOp)
	{
		this.theOp = theOp;
	}
	
	public String toString()
	{
		return "" + this.theOp;
	}
	
	public int applyOperator(int leftNum, int rightNum)
	{
		if(this.theOp == '+')
		{
			return leftNum + rightNum;
		}
		else if(this.theOp == '-')
		{
			return leftNum - rightNum;
		}
		else if(this.theOp == '*')
		{
			return leftNum * rightNum;
		}
		else if(this.theOp == '%')
		{
			return leftNum % rightNum;
		}
		else
		{
			return leftNum / rightNum;
		}
	}
}