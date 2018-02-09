import java.awt.*;
import hsa.Console;
//Saturn class is an extension of a base planet to customize the drawing of a ring
public class Saturn extends Planet
{
    Color secondColor;
    //ringSizeX is how much it sticks out of planet, ringSizeY is the width
    static int ringSizeX = 5, ringSizeY = 2;
    public Saturn (Color color, Color secondColor, int orbitRadius, int radius, int delay, int angleIncrement, Console c)
    {
	super (color, orbitRadius, radius, delay, angleIncrement, c);
	this.secondColor = secondColor;
    }


    public void drawMovingBasePlanet ()
    {
	orbitLib.drawfillCircle (super.circleX, super.circleY, super.radius, super.color, super.c);
	super.c.setColor (this.secondColor);
	super.c.fillOval ((super.circleX - (super.radius + this.ringSizeX)), super.circleY - (ringSizeY / 2), 2 * (super.radius + ringSizeX), ringSizeY);
	orbitLib.delay (super.delay);
	orbitLib.drawfillCircle (super.circleX, super.circleY, super.radius, OrbitConstants.backgroundColor, super.c);
	super.c.setColor (OrbitConstants.backgroundColor);
	super.c.fillOval ((super.circleX - (super.radius + this.ringSizeX)), super.circleY - (ringSizeY / 2), 2 * (super.radius + ringSizeX), ringSizeY);
    }
}
