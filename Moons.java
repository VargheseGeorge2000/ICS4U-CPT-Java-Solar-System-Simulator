import java.awt.*;
import hsa.Console;
//Extension of planet, except it would need to change the orbit center to updated planet (x,y)
public class Moons extends Planet
{
    protected Color color;
    protected double rotationAngle;
    private Planet planet;
    public Moons (Color color, int orbitRadius, int radius, int delay, int angleIncrement, Console c, Planet planet)
    {
	super (color, orbitRadius, radius, delay, angleIncrement, c);
	this.planet = planet;
    }






    public void multiplyCircle ()
    {
	int planetX, planetY;
	if (OrbitConstants.showOrbit)
	{
	    while (true)
	    {
		//Prevents the issue of circle updating coordinates before fully erasing the past orbit outline leaving a messy trail
		planetX = this.planet.getPlanetX ();
		planetY = this.planet.getPlanetY ();

		orbitLib.drawCircle (planetX, planetY, super.orbitRadius, OrbitConstants.orbitColor, super.c);
		orbitLib.delay (9);
		this.rotateMoon (planet);
		orbitLib.drawCircle (planetX, planetY, super.orbitRadius, OrbitConstants.backgroundColor, super.c);


	    }
	}
	while (true)
	{
	    this.rotateMoon (planet);
	}
    }
}



