/**
 * Represents a type of gravitational model: a simple, constant value
 */
public class GravityConstant implements GravityModel
{
	private double gravityConstant;
	
	/**
	 * Creates a new gravitational constant object
	 */
	public GravityConstant (double gc)
	{
		this.gravityConstant = gc;
	}
	
	/**
	 * Return the gravitational field value, which is simply a constant in this case
	 */
	public double getGravitationalField() { return gravityConstant; }
}