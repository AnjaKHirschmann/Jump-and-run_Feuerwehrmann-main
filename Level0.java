import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level0 extends World
{

    /**
     * Constructor for objects of class Level0.
     * 
     */
    public Level0()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 850, 1); 
        
        Startknopf_Level0 startknopf_Level0 = new Startknopf_Level0();
        addObject(startknopf_Level0,700,300);
    }
}
