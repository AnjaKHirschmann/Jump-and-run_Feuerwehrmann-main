import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Knopf extends Actor
{
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            MyWorld a =(MyWorld) getWorld();    
            Greenfoot.setWorld(new MyWorld2(a.getFeuerwehrmann(), a.getScore()));
            }
    }
}
