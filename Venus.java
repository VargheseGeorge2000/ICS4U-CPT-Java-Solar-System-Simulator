import java.awt.*;
import hsa.Console;
public class Venus extends Planet
{
    Color secondColor;
    //ringSizeX is how much it sticks out of planet, ringSizeY is the width
    static int ringSizeX = 5, ringSizeY = 2;
    public Venus (Color color, Color secondColor, int orbitRadius, int radius, int delay, int angleIncrement, Console c)
    {
	super (color, orbitRadius, radius, delay, angleIncrement, c);
	this.secondColor = secondColor;
    }


    public void drawMovingBasePlanet ()
    {
	orbitLib.drawfillCircle (super.circleX, super.circleY, super.radius, super.color, super.c);
	super.c.setColor (this.secondColor);
	orbitLib.drawfillCircle (super.circleX, super.circleY, super.radius - 3, this.secondColor, super.c);
	orbitLib.delay (super.delay);
	orbitLib.drawfillCircle (super.circleX, super.circleY, super.radius, OrbitConstants.backgroundColor, super.c);
    }
}
