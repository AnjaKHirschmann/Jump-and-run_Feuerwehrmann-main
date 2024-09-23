import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Wasser extends Actor
{
    private int richtung;
    
    public void act()
    {
        move(richtung);
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
    public void setzeRichtung(int a){
        richtung = a;
    }
    
    
}





