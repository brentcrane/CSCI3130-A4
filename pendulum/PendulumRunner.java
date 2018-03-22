import java.text.NumberFormat;

/** 
 * Compares the values of a simple pendulum using the harmonic motion equation,
 * versus the Euler algorithm approximation
 */
public class PendulumRunner {
	
	/**
	 * The main method will perform a simulation with different gravitational models
	 * Allows for command-line input to assign 'delta' and 'initial gravity' values
	 */
    public static void main (String [] args) {
	
		NumberFormat nf = NumberFormat.getInstance ();
		nf.setMaximumFractionDigits (3);

		double gravity = (args.length < 2) ? 9.80665 : Double.parseDouble (args[1]);
		GravityConstant gravityConstant = new GravityConstant(gravity);
		double delta = (args.length == 0) ? .1 : Double.parseDouble (args[0]);
		double sLen = 10, pMass = 10, theta0 = Math.PI/30;
		
		RegularPendulum rp = new RegularPendulum (sLen, pMass, theta0, gravityConstant, delta);
		SimplePendulum sp = new SimplePendulum (sLen, pMass, theta0, gravityConstant);
		RegularPendulum rpCoarse = new RegularPendulum (sLen, pMass, theta0, gravityConstant, .1);

		// Prints out difference in displacement in 1 second intervals, for 20 seconds
		int iterations = (int) (1/delta);
		System.out.println ("analytical vs. numerical displacement (fine, coarse)");
		for (int second = 1; second <= 20; second++) {
			if (second == 10)
			{
				System.out.println("\nChanging gravity model to Jupiter Constant (24.79)\n");
				GravityConstant jupiterGravity = new GravityConstant(24.79);
				rp.setGravityModel(jupiterGravity);
				rpCoarse.setGravityModel(jupiterGravity);
				sp.setGravityModel(jupiterGravity);
			}
			for (int i = 0; i < iterations; i++) rp.step ();
			for (int i = 0; i < 10; i++) rpCoarse.step (); 
			System.out.println ("t=" + second + "s: \t" + 
					nf.format (Math.toDegrees (sp.getTheta (second))) 
					+ "\t" +
					nf.format (Math.toDegrees (rp.getLastTheta ()))
					+ "\t" + 
					nf.format (Math.toDegrees (rpCoarse.getLastTheta ())));
		}
    }
}

