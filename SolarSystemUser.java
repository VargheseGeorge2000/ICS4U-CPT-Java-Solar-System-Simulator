// The "SolarSystem" class.
// Varghese Rony George 2018 01 09
// User Class of 12 Comp Sci CPT
// The following project will simulate the solar system with planets/asteroids orbiting the sun, moons orbiting planets, and shining stars
import java.awt.*;
import hsa.Console;
public class SolarSystemUser
{
    static Console c;
    
    public static void main (String[] args)
    {
	//Console size
	c = new Console (37, 193);
	//Request orbit outlines
	c.println ("Show Orbit? Enter True or False");
	OrbitConstants.showOrbit = c.readBoolean ();
	//Orbit set to center of screen, variables are assigned with initializePlanets method
	OrbitConstants.initializePlanets (c);
	//Sun, Background
	orbitLib.drawBackground (c);

	//Each object in the array of asteroids, stars, planets, and moons, will have an individual/unique thread
	Asteroids[] belt = new Asteroids [OrbitConstants.numAsteroids];
	Thread[] tbelt = new Thread [OrbitConstants.numAsteroids];

	Stars[] stars = new Stars [OrbitConstants.numStars];
	Thread[] tstars = new Thread [OrbitConstants.numStars];

	Planet[] planet = new Planet [OrbitConstants.numPlanets];
	Thread[] tplanets = new Thread [OrbitConstants.numPlanets];

	Moons[] moons = new Moons [OrbitConstants.numMoons];
	Thread[] tmoons = new Thread [OrbitConstants.numMoons];

	//********************************************************
	//**********************PLANETS***************************
	//********************************************************

	//All the follow traits found in OrbitConstants, format of initalization parameters goes:
	//Basic Planet (Color, Orbit Radius, Planet Radius, Delay, Angle Increment, Console)
	//Special Planet(Primary Color, Secondary Color, Orbit Radius, Planet Radius, Delay, Angle Increment, Console)
	//Moon of Planet (Color, Orbit Radius , Moon Radius, Delay, Angle Increment, Console, Planet to Orbit);

	//Mercury
	planet [0] = new Planet (OrbitConstants.planetColor [0] [0], OrbitConstants.planetTrait [0] [0], OrbitConstants.planetTrait [0] [1], OrbitConstants.planetTrait [0] [2], OrbitConstants.planetTrait [0] [3], c);
	//Venus
	planet [1] = new Venus (OrbitConstants.planetColor [1] [0], OrbitConstants.planetColor [1] [1], OrbitConstants.planetTrait [1] [0], OrbitConstants.planetTrait [1] [1], OrbitConstants.planetTrait [1] [2], OrbitConstants.planetTrait [1] [3], c);
	//Earth
	planet [2] = new Earth (OrbitConstants.planetColor [2] [0], OrbitConstants.planetColor [2] [1], OrbitConstants.planetTrait [2] [0], OrbitConstants.planetTrait [2] [1], OrbitConstants.planetTrait [2] [2], OrbitConstants.planetTrait [2] [3], c);
	//Earth Moon 1
	moons [0] = new Moons (OrbitConstants.moonColor [0], OrbitConstants.moonTrait [0] [0], OrbitConstants.moonTrait [0] [1], OrbitConstants.moonTrait [0] [2], OrbitConstants.moonTrait [0] [2], c, planet [2]);
	//Mars
	planet [3] = new Planet (OrbitConstants.planetColor [3] [0], OrbitConstants.planetTrait [3] [0], OrbitConstants.planetTrait [3] [1], OrbitConstants.planetTrait [3] [2], OrbitConstants.planetTrait [3] [3], c);
	//Mars Moon 1
	moons [1] = new Moons (OrbitConstants.moonColor [1], OrbitConstants.moonTrait [1] [0], OrbitConstants.moonTrait [1] [1], OrbitConstants.moonTrait [1] [2], OrbitConstants.moonTrait [1] [2], c, planet [3]);
	//Jupiter
	planet [4] = new Jupiter (OrbitConstants.planetColor [4] [0], OrbitConstants.planetColor [4] [1], OrbitConstants.planetTrait [4] [0], OrbitConstants.planetTrait [4] [1], OrbitConstants.planetTrait [4] [2], OrbitConstants.planetTrait [4] [3], c);
	//Jupiter Moon 1
	moons [2] = new Moons (OrbitConstants.moonColor [2], OrbitConstants.moonTrait [2] [0], OrbitConstants.moonTrait [2] [1], OrbitConstants.moonTrait [2] [2], OrbitConstants.moonTrait [2] [2], c, planet [4]);
	//Jupiter Moon 2
	moons [3] = new Moons (OrbitConstants.moonColor [3], OrbitConstants.moonTrait [3] [0], OrbitConstants.moonTrait [3] [1], OrbitConstants.moonTrait [3] [2], OrbitConstants.moonTrait [3] [2], c, planet [4]);
	//Saturn
	planet [5] = new Saturn (OrbitConstants.planetColor [5] [0], OrbitConstants.planetColor [5] [1], OrbitConstants.planetTrait [5] [0], OrbitConstants.planetTrait [5] [1], OrbitConstants.planetTrait [5] [2], OrbitConstants.planetTrait [5] [3], c);
	//Saturn Moon 1
	moons [4] = new Moons (OrbitConstants.moonColor [4], OrbitConstants.moonTrait [4] [0], OrbitConstants.moonTrait [4] [1], OrbitConstants.moonTrait [4] [2], OrbitConstants.moonTrait [4] [2], c, planet [5]);
	//Saturn Moon 2
	moons [5] = new Moons (OrbitConstants.moonColor [5], OrbitConstants.moonTrait [5] [0], OrbitConstants.moonTrait [5] [1], OrbitConstants.moonTrait [5] [2], OrbitConstants.moonTrait [5] [2], c, planet [5]);
	//Uranus
	planet [6] = new Planet (OrbitConstants.planetColor [6] [0], OrbitConstants.planetTrait [6] [0], OrbitConstants.planetTrait [6] [1], OrbitConstants.planetTrait [6] [2], OrbitConstants.planetTrait [6] [3], c);
	//Uranus Moon 1
	moons [6] = new Moons (OrbitConstants.moonColor [6], OrbitConstants.moonTrait [6] [0], OrbitConstants.moonTrait [6] [1], OrbitConstants.moonTrait [6] [2], OrbitConstants.moonTrait [6] [2], c, planet [6]);
	//Neptune
	planet [7] = new Planet (OrbitConstants.planetColor [7] [0], OrbitConstants.planetTrait [7] [0], OrbitConstants.planetTrait [7] [1], OrbitConstants.planetTrait [7] [2], OrbitConstants.planetTrait [7] [3], c);
	//Neptune Moon 1
	moons [7] = new Moons (OrbitConstants.moonColor [7], OrbitConstants.moonTrait [7] [0], OrbitConstants.moonTrait [7] [1], OrbitConstants.moonTrait [7] [2], OrbitConstants.moonTrait [7] [2], c, planet [7]);
	
	//Make threads of planets
	for (int k = 0 ; k < tplanets.length ; k++)
	{
	    tplanets [k] = new Thread (planet [k]);
	    tplanets [k].start ();
	}
	//Make threads of planet moons
	for (int l = 0 ; l < tmoons.length ; l++)
	{
	    tmoons [l] = new Thread (moons [l]);
	    tmoons [l].start ();
	}
	
	//Make a set of stars
	for (int i = 0 ; i < tstars.length ; i++)
	{
	    stars [i] = new Stars (c);
	    tstars [i] = new Thread (stars [i]);
	    tstars [i].start ();
	}
	
	//Generate an Asteroid belt between orbits of Mars/Jupiter
	for (int j = 0 ; j < tbelt.length; j++)
	{
	    belt [j] = new Asteroids (OrbitConstants.asteroidColor, ((int) (20 * Math.random () + 130)), (int) (3 * Math.random ()), ((int) (20 * Math.random () + 50)), OrbitConstants.asteroidIncrement, c);

	    tbelt [j] = new Thread (belt [j]);
	    tbelt [j].start ();
	}

    } // main method



} // SolarSystem class
