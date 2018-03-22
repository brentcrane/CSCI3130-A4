/**
 * Represents a pendulum using the Euler algorithm approximation
 */
public class RegularPendulum extends AbstractPendulum {
    private double delta, iterations = 0;
    private double dissipation;
    private double lastVel, lastTheta, lastAccel;

    /**
     * Creates a new RegularPendulum instance
     */
    public RegularPendulum (double inLength, double inMass, double inTheta0, double inG, double inDelta, double inDiss) {
		super (inLength, inMass, inTheta0, inG);
		delta=inDelta;
		dissipation = inDiss;
		lastVel = 0;
		lastTheta = this.getMaxAngularDisplacement();
		lastAccel = -(this.getGravitationalField() / this.getStringLength ())*Math.sin (lastTheta);
    }

    public RegularPendulum (double inLength, double inMass, double inTheta0, double inGravity, double inDelta) {
		this (inLength, inMass, inTheta0, inGravity, inDelta, 0);
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
