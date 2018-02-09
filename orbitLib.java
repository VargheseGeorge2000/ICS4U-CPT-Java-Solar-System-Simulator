import java.awt.*;
import hsa.Console;

//Has static customized draw methods which other classes call for reusability by putting console as parameter
public class orbitLib
{
    //Draws Sun/Space
    public static void drawBackground (Console c)
    {
	c.setColor (OrbitConstants.backgroundColor);
	c.fillRect (0, 0, c.maxx (), c.maxy ());
	drawfillCircle (OrbitConstants.orbitX, OrbitConstants.orbitY, 30, Color.orange, c);
	drawfillCircle (OrbitConstants.orbitX, OrbitConstants.orbitY, 25, Color.yellow, c);
	//Sunglasses and Face
	c.setColor (Color.black);
	//Bar
	c.fillRect (OrbitConstants.orbitX - 20, OrbitConstants.orbitY - 6, 40, 3);
	//Left
	c.fillRect (OrbitConstants.orbitX - 20, OrbitConstants.orbitY - 3, 15, 3);
	c.fillRect (OrbitConstants.orbitX - 17, OrbitConstants.orbitY, 9, 2);

	//Right
	c.fillRect (OrbitConstants.orbitX + 5, OrbitConstants.orbitY - 3, 15, 3);
	c.fillRect (OrbitConstants.orbitX + 8, OrbitConstants.orbitY, 9, 2);
	//Mouth
	c.fillRect (OrbitConstants.orbitX - 20, OrbitConstants.orbitY + 6, 40, 1);
	//Sparkle
	c.setColor (Color.white);
	c.fillRect (OrbitConstants.orbitX - 15, OrbitConstants.orbitY - 2, 2, 2);
	c.fillRect (OrbitConstants.orbitX - 13, OrbitConstants.orbitY - 4, 2, 2);
	c.fillRect (OrbitConstants.orbitX + 13, OrbitConstants.orbitY - 2, 2, 2);
	c.fillRect (OrbitConstants.orbitX + 15, OrbitConstants.orbitY - 4, 2, 2);

    }


    //Used in stars,planets,moons,asteroids thus they use this method to prevent repetitive methods
    public static void drawfillCircle (int circleX, int circleY, int radius, Color clr, Console c)
    {
	int xCord, yCord, diameter;
	xCord = Math.round (circleX - radius);
	yCord = Math.round (circleY - radius);
	diameter = (2 * radius);
	c.setColor (clr);
	c.fillOval (xCord, yCord, diameter, diameter);

    }


    //Orbit outlines of moons/planets referenced here
    public static void drawOrbit (int radius, Console c)
    {
	int xCord, yCord, diameter;
	xCord = Math.round (OrbitConstants.orbitX - radius);
	yCord = Math.round (OrbitConstants.orbitY - radius);
	diameter = (2 * radius);
	c.setColor (OrbitConstants.orbitColor);
	c.drawOval (xCord, yCord, diameter, diameter);

    }
    //drawOrbit does stationary centers, this is used for moons
    public static void drawCircle (int circleX, int circleY, int radius, Color clr, Console c)
    {
	int xCord, yCord, diameter;
	xCord = Math.round (circleX - radius);
	yCord = Math.round (circleY - radius);
	diameter = (2 * radius);
	c.setColor (clr);
	c.drawOval (xCord, yCord, diameter, diameter);

    }

    //Static delay method
    public static void delay (int delay)
    {
	try
	{
	    Thread.sleep (delay);
	}
	catch (InterruptedException e)
	{
	}

    }
}
