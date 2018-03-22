/**
 * Represents a pendulum exhibiting (approximately) simple harmonic motion
 */
public class SimplePendulum extends AbstractPendulum {

    private double angularFrequency, periodOfMotion;

    /**
     * Creates a new Simple Pendulum instance
     */
    public SimplePendulum (double inLength, double inMass, double inTheta0, GravityModel gModel) {
		super (inLength, inMass, inTheta0, gModel);
		angularFrequency = Math.sqrt (this.getGravitationalField () / this.getStringLength ());
		periodOfMotion = 2 * Math.PI * Math.sqrt (this.getStringLength () / this.getGravitationalField ());
    }

    /**
     * Provides this Pendulum's angular frequency
     */ 
    public double getAngularFrequency () { return angularFrequency; }

    /**
     * Provides this Pendulum's period of motion
     */ 
    public double getPeriodOfMotion () { return periodOfMotion; }

    /**
     * Provides the angular displacement of this Pendulum at time 't'
     */
    public double getTheta (double t) {
		return this.getMaxAngularDisplacement () * Math.cos (angularFrequency * t);
    }
}
