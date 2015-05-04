public class Driver 
{
	public static void main(String[] args)
	{
		Parser p = new Parser("     apple =     (a *   b) - c;");
		p.parse();
		VarDefStatement vds = p.getTheSytaxTree();
		System.out.println(vds);
	}
}