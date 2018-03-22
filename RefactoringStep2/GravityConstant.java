
public class GravityConstant implements GravityModel
{
	private double gravityConstant;

	public GravityConstant (double gc)
	{
		this.gravityConstant = gc;
	}
	
	public double getGravitationalField()
	{
		return gravityConstant;
	}
}