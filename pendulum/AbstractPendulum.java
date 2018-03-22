/**
 * Represents an abstract pendulum
 */
public abstract class AbstractPendulum implements GravityModel{

    private double stringLength, pointMass;
    protected double theta0;
    protected GravityModel g;

    /**
     * Creates a new Pendulum instance
	 * Verifies that given values are valid
     */
    public AbstractPendulum (double inLength, double inMass, double inTheta0, GravityModel gModel) {
		if (validStringLength (inLength))
			stringLength = inLength;
		else
			throw new IllegalArgumentException ("invalid string length: " + inLength);
			
		if (validPointMass(inMass))
			pointMass = inMass;
		else
			throw new IllegalArgumentException ("invalid point mass: " + inMass);
			
		if (validDisplacement (inTheta0))
			theta0 = inTheta0;
		else
			throw new IllegalArgumentException ("invalid angular displacement: " + inTheta0);
			
		if (validGC (gModel.getGravitationalField()))
			g = gModel;
		else
			throw new IllegalArgumentException ("invalid local gravitational field: " + gModel.getGravitationalField());
    }

    private boolean validDisplacement (double val) { return (val >= 0); }
    private boolean validPointMass (double val) { return (val > 0); }
    private boolean validStringLength (double val) { return (val > 0); }
    private boolean validGC (double grav) { return (grav >= 0); }

	/**
	 * Return the maximum angular displacement value
	 */
    public double getMaxAngularDisplacement () { return theta0; }

	/**
	 * Return the point-mass value
	 */
    public double getPointMass () { return pointMass; }

	/**
	 * Return the string length value
	 */
    public double getStringLength () { return stringLength; }
	
	/**
	 * Return the value of the gravitational model's gravity value
	 */
    public double getGravitationalField () { return g.getGravitationalField(); }
	
	/**
	 * Set a new value for the gravitational model of the pendulum
	 */
	public void setGravityModel (GravityModel gm) { this.g = gm; }
}