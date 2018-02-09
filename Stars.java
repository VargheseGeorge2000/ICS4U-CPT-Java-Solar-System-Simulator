import java.awt.*;
import hsa.Console;
//Designed to draw blinking stars at random points in space
public class Stars implements Runnable
{
    private Color color;
    static Console c;
    private int starCoordx, starCoordy;
    private int randEffect;

    public Stars (Console c)
    {
	this.c = c;
	//To prevent drawing on top of planets/sun
	do
	{
	    this.starCoordx = (int) (c.maxx () * Math.random ());
	}
	while (this.starCoordx > (OrbitConstants.orbitX - OrbitConstants.planetTrait [7] [0]) && this.starCoordx < (OrbitConstants.orbitX + OrbitConstants.planetTrait [7] [0]));

	this.starCoordy = (int) (c.maxy () * Math.random ());
	this.color = new Color ((int) (205 * Math.random () + 50), (int) (205 * Math.random () + 50), (int) (205 * Math.random () + 50));
    }


    public void run ()
    {
    //To make it blink randomly or brighten by increasing radius by 1
	while (true)
	{
	    orbitLib.delay ((int) (1000 * Math.random () + 500));
	    randEffect = (int) (3 * Math.random ());
	    if (randEffect == 1)
	    {
		orbitLib.drawfillCircle (this.starCoordx, this.starCoordy, 2, color, c);
	    }
	    else
	    {
		orbitLib.drawfillCircle (this.starCoordx, this.starCoordy, 2, OrbitConstants.backgroundColor, c);

	    }
	    orbitLib.delay ((int) (10000 * Math.random () + 500));
	    orbitLib.drawfillCircle (starCoordx, starCoordy, 1, color, c);
	}
    }
}





