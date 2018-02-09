import java.awt.*;
import hsa.Console;
//Earth class is an extension of a base planet to customize the drawing of land mass
public class Earth extends Planet
{
    Color secondColor;
    //ringSizeX is how much it sticks out of planet, ringSizeY is the width
    static int ringSizeX = 5, ringSizeY = 2;
    public Earth (Color color, Color secondColor, int orbitRadius, int radius, int delay, int angleIncrement, Console c)
    {
	super (color, orbitRadius, radius, delay, angleIncrement, c);
	this.secondColor = secondColor;
    }


    public void drawMovingBasePlanet ()
    {
	orbitLib.drawfillCircle (super.circleX, super.circleY, super.radius, super.color, super.c);
	super.c.setColor (this.secondColor);
	orbitLib.drawfillCircle (super.circleX + 1, super.circleY - 2, super.radius - 3, this.secondColor, super.c);
	orbitLib.drawfillCircle (super.circleX - 1, super.circleY + 2, super.radius - 4, this.secondColor, super.c);
	orbitLib.delay (super.delay);
	orbitLib.drawfillCircle (super.circleX, super.circleY, super.radius, OrbitConstants.backgroundColor, super.c);
    }
}
