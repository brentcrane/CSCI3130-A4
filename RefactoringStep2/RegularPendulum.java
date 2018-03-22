/**
 * Represents a pendulum
 */
public class RegularPendulum extends AbstractPendulum {
    private double delta, iterations = 0;
    private double dissipation;
    private double lastTheta, lastVel, lastAccel;

    /**
     * Creates a new Pendulum instance 
     */
    public RegularPendulum (double inLength, double inMass, double inTheta0, GravityModel gModel, double inDelta, double inDiss) {
		//GravityModel gm = new GravityConstant (inG);
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

    public void step () {
		iterations++;
		lastTheta = lastTheta + lastVel*delta;
		lastVel = lastVel + lastAccel*delta;
		lastAccel = - dissipation*lastVel - this.getGravitationalField () / this.getStringLength () * Math.sin (lastTheta);
    }

    public double getLastTheta () { return lastTheta; }
    public double getLastVelocity () { return lastVel; }
    public double getLastAcceleration () { return lastAccel; }
    public double getLastTime () { return iterations*delta; }
    public double getDissipationConstant () { return dissipation; }
}
