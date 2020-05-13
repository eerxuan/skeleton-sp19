
public class NBody {
	
	public static String imageToDraw = "images/starfield.jpg";
	
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		double radius = in.readDouble();
		radius = in.readDouble();
		return radius;
	}
	
	public static Body[] readBodies(String fileName) {
		In in = new In(fileName);
		int leng = in.readInt();
		double radius = in.readDouble();
		Body[] items = new Body[leng];
		
		for (int i = 0; i < leng; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			items[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}

		return items;
	}
	
	public static void main(String[] args) {
		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
		String filename = args[2];
		Body[] bodies = readBodies(filename);
		double radius = readRadius(filename);
		double t = 0;
		double[] xForces = new double[bodies.length];
		double[] yForces = new double[bodies.length];
		
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		
		while (t <= T) {
			for (int i = 0; i < bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}
			for (int i = 0; i < bodies.length; i++) {
				bodies[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, imageToDraw);
			for (Body item : bodies) {
				item.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			t += dt;
		}
	}
}
