
public class GravityConstant implements GravityModel
{
	private double gravityConstant;

	public GravityConstant (double gc)
	{
		gravityConstant = gc;
	}
	
	public double getGravitationalField()
	{
		return gravityConstant;
	}
}