public class LitExpression extends Expression
{
	private int theLiteral;
	
	public LitExpression(int theLiteral)
	{
		this.theLiteral = theLiteral;
	}
	
	public int getTheLiteral() {
		return theLiteral;
	}

	public String toString()
	{
		return "" + this.theLiteral;
	}
}