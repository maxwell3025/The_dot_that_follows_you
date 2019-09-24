package followers;

public class followball {
	private double x;
	private double y;
	private double xvel;
	private double yvel;
	private double speed;
	public followball(double X, double Y, double XVelocity, double YVelocity) {
		setX(X);
		setY(Y);
		setXvel(XVelocity);
		setYvel(YVelocity);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getXvel() {
		return xvel;
	}

	public void setXvel(double xvel) {
		this.xvel = xvel;
	}

	public double getYvel() {
		return yvel;
	}

	public void setYvel(double yvel) {
		this.yvel = yvel;
	}

	public void tick(double targetx, double targety) {
		// x = x+xvel;
		// y = y+yvel;
		speed = speed+0.0001;
		y = y + ((targety - y) / Math.abs(Math.abs(targety - y) + Math.abs(targetx - x)))*(1+speed);
		x = x + ((targetx - x) / Math.abs(Math.abs(targety - y) + Math.abs(targetx - x)))*(1+speed);
	}

}
