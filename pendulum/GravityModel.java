/**
 * Interface to implement various interchangeable gravitational models
 */
public interface GravityModel
{
	/**
	 * Return the gravitational field of the implemented gravitational model
	 */
	public double getGravitationalField();
}