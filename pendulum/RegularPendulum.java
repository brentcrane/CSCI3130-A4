/**
 * Represents a pendulum using the Euler algorithm approximation
 */
public class RegularPendulum extends AbstractPendulum {

    private double delta, iterations = 0;
    private double dissipation;
    private double lastTheta, lastVel, lastAccel;

    /**
     * Creates a new Regular Pendulum instance 
     */
    public RegularPendulum (double inLength, double inMass, double inTheta0, GravityModel gModel, double inDelta, double inDiss) {
		super (inLength, inMass, inTheta0, gModel);
		delta=inDelta;
		dissipation = inDiss;
		lastVel = 0;
		lastTheta = this.getMaxAngularDisplacement ();
		lastAccel = -(this.getGravitationalField () / this.getStringLength ())*Math.sin (lastTheta);
    }
	
	/**
	 * Creates a new Pendulum instance, with the dissipation set to 0
	 */
    public RegularPendulum (double inLength, double inMass, double inTheta0, GravityModel gModel, double inDelta) {
		this (inLength, inMass, inTheta0, gModel, inDelta, 0);
    }
	
	/**
	 * Take one 'step' in physical movement for this pendulum
	 */
    public void step () {
		iterations++;
		lastTheta = lastTheta + lastVel*delta;
		lastVel = lastVel + lastAccel*delta;
		lastAccel = - dissipation*lastVel - this.getGravitationalField () / this.getStringLength () * Math.sin (lastTheta);
    }
	
	/**
	 * Return the last calculated theta value
	 */
    public double getLastTheta () { return lastTheta; }
	
	/**
	 * Return the last calculated velocity value
	 */
    public double getLastVelocity () { return lastVel; }
	
	/**
	 * Return the last calculated acceleration value
	 */
    public double getLastAcceleration () { return lastAccel; }
	
	/**
	 * Return the last time step
	 */
    public double getLastTime () { return iterations*delta; }
    
	/**
	 * Return the dissipation value
	 */
	public double getDissipationConstant () { return dissipation; }

}
