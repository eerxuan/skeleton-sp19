
public class Body {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	static final double G = 6.67e-11;
	
	public Body(double xP, double yP, double xV,
            double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}
	
	public double calcDistance(Body item) {
		double distance = Math.sqrt(Math.pow((xxPos - item.xxPos), 2) + Math.pow((yyPos - item.yyPos), 2));
		return distance;
	}
	
	public double calcForceExertedBy(Body item) {
		double distance = calcDistance(item);
		double force = G * mass * item.mass / Math.pow(distance, 2);
		return force;
	}
	
	public double calcForceExertedByX(Body item) {
		double distance = calcDistance(item);
		double force = calcForceExertedBy(item);
		double dx = item.xxPos - xxPos;
		double forceX = force * dx / distance;
		return forceX;
	}
	
	public double calcForceExertedByY(Body item) {
		double distance = calcDistance(item);
		double force = calcForceExertedBy(item);
		double dy = item.yyPos - yyPos;
		double forceY = force * dy / distance;
		return forceY;
	}
	
	public double calcNetForceExertedByX (Body[] items) {
		double netForceX = 0;
		for (Body item : items) {
			if (this.equals(item)) {
				continue;
			}
			netForceX += calcForceExertedByX(item);
		}
		
		return netForceX;
	}
	
	public double calcNetForceExertedByY (Body[] items) {
		double netForceY = 0;
		for (Body item : items) {
			if (this.equals(item)) {
				continue;
			}
			netForceY += calcForceExertedByY(item);
		}
		
		return netForceY;
	}
	
	public void update(double t, double fX, double fY) {
		double accX = fX / mass;
		double accY = fY/ mass;
		xxVel += accX * t;
		yyVel += accY * t;
		xxPos += xxVel * t;
		yyPos += yyVel * t;
	}
	
	public void draw() {
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	}
}