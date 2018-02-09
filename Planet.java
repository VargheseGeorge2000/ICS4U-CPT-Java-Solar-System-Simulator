import java.awt.*;
import hsa.Console;
//Parent class for most other objects, basic features of a circle orbiting a point
public class Planet implements Runnable
{
    protected Color color;
    static Console c;
    protected int radius, orbitRadius, delay, circleX, circleY;
    protected double rotationAngle, angleIncrement;
    public Planet (Color color, int orbitRadius, int radius, int delay, int angleIncrementRate, Console c)
    {
	this.orbitRadius = orbitRadius;
	this.radius = radius;
	this.color = color;
	this.c = c;
	this.delay = delay;
	this.angleIncrement = Math.PI / angleIncrementRate;
	//Always randomize the starting angle of the planets so it doesn't perfectly line up with other planets at start
	this.rotationAngle = 6.28 * Math.random ();

    }


    public void run ()
    {
	multiplyCircle ();
    }


    //Draw planet, delay so its visible, draw over planet, repeat
    public void drawMovingBasePlanet ()
    {
	orbitLib.drawfillCircle (this.circleX, this.circleY, this.radius, this.color, this.c);
	orbitLib.delay (this.delay);
	orbitLib.drawfillCircle (this.circleX, this.circleY, this.radius, OrbitConstants.backgroundColor, this.c);
    }



    public void rotatePlanet ()
    {
	//Make the new (x,y) position of the circle based on the angle given, then use the drawCirclle method
	this.circleX = OrbitConstants.orbitX + (int) (this.orbitRadius * Math.cos (this.rotationAngle));
	this.circleY = OrbitConstants.orbitY - (int) (this.orbitRadius * Math.sin (this.rotationAngle));
	//Generate a set of RGB for the color object to randomize colors
	drawMovingBasePlanet ();
	this.rotationAngle += this.angleIncrement;
	//Radius of smaller circles is half the value of a chord between the two center points of the circles


    }


    //Used for moon objects
    public void rotateMoon (Planet planet)
    {
	//Make the new (x,y) position of the circle based on the angle given, then use the drawCirclle method
	this.circleX = planet.getPlanetX () + (int) (this.orbitRadius * Math.cos (this.rotationAngle));
	this.circleY = planet.getPlanetY () - (int) (this.orbitRadius * Math.sin (this.rotationAngle));
	//Generate a set of RGB for the color object to randomize colors
	drawMovingBasePlanet ();
	this.rotationAngle += this.angleIncrement;
	//Radius of smaller circles is half the value of a chord between the two center points of the circles

    }


    //Make the if statement before loop so its one less thing in repetition
    public void multiplyCircle ()
    {
	//Checks boolean statement once if it wants to run the orbit
	if (OrbitConstants.showOrbit)
	{
	    while (true)
	    {
		orbitLib.drawOrbit (this.orbitRadius, c);
		rotatePlanet ();

	    }
	}

	while (true)
	{
	    rotatePlanet ();
	}

    }


    //Following two methods used to return moon center of orbit
    public int getPlanetX ()
    {
	return this.circleX;
    }


    public int getPlanetY ()
    {
	return this.circleY;
    }
}
