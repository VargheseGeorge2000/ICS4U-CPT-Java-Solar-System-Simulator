import java.awt.*;
import hsa.Console;
//To organize constants and access them from one class (reduce floating numbers in code when edits are needed)
public class OrbitConstants
{

    final static Color orbitColor = new Color (20, 20, 50);
    final static Color backgroundColor = new Color (0, 0, 25);
    final static Color asteroidColor = new Color (100, 100, 100);
    final static int asteroidIncrement = 500;
    final static int numStars = 30;
    final static int numPlanets = 8;
    final static int numAsteroids = 30;
    final static int numMoons = 8;

    static int[] [] planetTrait = new int [8] [4]; //planetTrait will have all the variables to initialize in order of Orbit Radius, Shape Radius, Delay, and Rotational Increment Modifier
    static Color[] [] planetColor = new Color [8] [2]; // For planets with extra colors
    static int[] [] moonTrait = new int [8] [4]; //Some planets have extra stuff to add, Goes in order of primary (base color), secondary, and so on
    static Color[] moonColor = new Color [8];


    static boolean showOrbit;

    static int orbitX, orbitY;

    public static void initializePlanets (Console c)
    {
	//In Columns: [0]= Orbit Radius, [1] = Shape Radius, [2] = Delay, and [3] = Rotational Increment Modifier
	int delayModifier = 2; //Instead of scrolling through changing every value
	int angleIncrementModifier = 2; //As stated in comment above
	//Setting center of orbit
	orbitX = (c.maxx () / 2);
	orbitY = (c.maxy () / 2);
	//Mercury
	planetColor [0] [0] = Color.gray;//Base color
	planetTrait [0] [0] = 37; //Orbit Radius
	planetTrait [0] [1] = 2; //Planet Radius
	planetTrait [0] [2] = 36 * delayModifier; //Delay
	planetTrait [0] [3] = 30 * angleIncrementModifier;
	//Venus
	planetColor [1] [0] = new Color (255, 150, 0);//Base color
	planetColor [1] [1] = Color.orange;
	planetTrait [1] [0] = 50; //Orbit Radius
	planetTrait [1] [1] = 6; //Planet Radius
	planetTrait [1] [2] = 45 * delayModifier; //Delay
	planetTrait [1] [3] = 60 * angleIncrementModifier; //Angle Increment
	//Earth (Add green color with blue)
	planetColor [2] [0] = new Color (100, 220, 255);
	planetColor [2] [1] = new Color (0, 100, 0); // Land
	planetTrait [2] [0] = 70; //Orbit Radius
	planetTrait [2] [1] = 6; //Planet Radius
	planetTrait [2] [2] = 50 * delayModifier; //Delay
	planetTrait [2] [3] = 90 * angleIncrementModifier; //Angle Increment
	//Earth Moon
	moonColor [0] = Color.gray;//Base color
	moonTrait [0] [0] = 10; //Orbit Radius
	moonTrait [0] [1] = 1; //Planet Radius
	moonTrait [0] [2] = 27 * delayModifier; //Delay
	moonTrait [0] [3] = 50 * angleIncrementModifier; //Angle Increment
	//Mars
	planetColor [3] [0] = new Color (255, 100, 100);//Base color
	planetTrait [3] [0] = 100; //Orbit Radius
	planetTrait [3] [1] = 4; //Planet Radius
	planetTrait [3] [2] = 55 * delayModifier; //Delay
	planetTrait [3] [3] = 200 * angleIncrementModifier; //Angle Increment
	//Mars Moon 1
	moonColor [1] = Color.gray;//Base color
	moonTrait [1] [0] = 7; //Orbit Radius
	moonTrait [1] [1] = 1; //Planet Radius
	moonTrait [1] [2] = 17 * delayModifier; //Delay
	moonTrait [1] [3] = 50 * angleIncrementModifier; //Angle Increment
	//Jupiter
	planetColor [4] [0] = new Color (255, 200, 150);//Base color
	planetColor [4] [1] = Color.red;//Red Dot
	planetTrait [4] [0] = 190; //Orbit Radius
	planetTrait [4] [1] = 13; //Planet Radius
	planetTrait [4] [2] = 55 * delayModifier; //Delay
	planetTrait [4] [3] = 250 * angleIncrementModifier; //Angle Increment
	//Jupiter Moon 1
	moonColor [2] = Color.orange;//Base color
	moonTrait [2] [0] = 18; //Orbit Radius
	moonTrait [2] [1] = 2; //Planet Radius
	moonTrait [2] [2] = 30 * delayModifier; //Delay
	moonTrait [2] [3] = 50 * angleIncrementModifier; //Angle Increment
	//Jupiter Moon 2
	moonColor [3] = Color.gray;//Base color
	moonTrait [3] [0] = 17; //Orbit Radius
	moonTrait [3] [1] = 1; //Planet Radius
	moonTrait [3] [2] = 35 * delayModifier; //Delay
	moonTrait [3] [3] = 60 * angleIncrementModifier; //Angle Increment

	//Saturn
	planetColor [5] [0] = new Color (255, 230, 100);//Base color
	planetColor [5] [1] = new Color (155, 130, 130); //Ring
	planetTrait [5] [0] = 240;//Orbit Radius
	planetTrait [5] [1] = 8; //Planet Radius
	planetTrait [5] [2] = 60 * delayModifier; //Delay
	planetTrait [5] [3] = 300 * angleIncrementModifier; //Angle Increment
	//Saturn Moon 1
	moonColor [4] = Color.red;//Base color
	moonTrait [4] [0] = 18; //Orbit Radius
	moonTrait [4] [1] = 1; //Planet Radius
	moonTrait [4] [2] = 32 * delayModifier; //Delay
	moonTrait [4] [3] = 80 * angleIncrementModifier;//Angle Increment
	//Saturn Moon 2
	moonColor [5] = Color.white;//Base color
	moonTrait [5] [0] = 16; //Orbit Radius
	moonTrait [5] [1] = 1; //Planet Radius
	moonTrait [5] [2] = 23 * delayModifier; //Delay
	moonTrait [5] [3] = 100 * angleIncrementModifier;//Angle Increment

	//Uranus
	planetColor [6] [0] = new Color (100, 255, 200);//Base color
	planetTrait [6] [0] = 280; //Orbit Radius
	planetTrait [6] [1] = 7; //Planet Radius
	planetTrait [6] [2] = 65 * delayModifier; //Delay
	planetTrait [6] [3] = 350 * angleIncrementModifier;//Angle Increment
	//Uranus Moon 1
	moonColor [6] = Color.orange;//Base color
	moonTrait [6] [0] = 10; //Orbit Radius
	moonTrait [6] [1] = 1; //Planet Radius
	moonTrait [6] [2] = 37 * delayModifier; //Delay
	moonTrait [6] [3] = 60 * angleIncrementModifier;//Angle Increment



	//Neptune
	planetColor [7] [0] = new Color (100, 155, 255);//Base color
	planetTrait [7] [0] = 310; //Orbit Radius
	planetTrait [7] [1] = 7; //Planet Radius
	planetTrait [7] [2] = 70 * delayModifier; //Delay
	planetTrait [7] [3] = 400 * angleIncrementModifier;//Angle Increment
	//Neptune Moon 1
	moonColor [7] = Color.green;//Base color
	moonTrait [7] [0] = 14; //Orbit Radius
	moonTrait [7] [1] = 1; //Planet Radius
	moonTrait [7] [2] = 42 * delayModifier; //Delay
	moonTrait [7] [3] = 80 * angleIncrementModifier;//Angle Increment
    }




}
