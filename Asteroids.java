import java.awt.*;
import hsa.Console;
//Asteroid has same properties as planet, but does not need an orbit outline
public class Asteroids extends Planet
{
    protected Color color;
    static Console c;
    protected int radius, orbitRadius, delay, circleX, circleY;
    protected double rotationAngle, angleIncrement;
    public Asteroids (Color color, int orbitRadius, int radius, int delay, int angleIncrement, Console c)
    {
	super (color, orbitRadius, radius, delay, angleIncrement, c);
    }




    //Method overide remove showOrbit check
    public void multiplyCircle ()
    {
	super.rotationAngle = 6.28 * Math.random ();
	while (true)
	{
	    super.rotatePlanet ();
	    super.rotationAngle += super.angleIncrement;
	}

    }



}
