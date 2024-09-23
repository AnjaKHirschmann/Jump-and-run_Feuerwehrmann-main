import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Feuer extends Actor
{
    public void act()
    {
        collision();
    }
    
    public void collision(){
        if(isTouching(Wasser.class)){
            //MyWorld a =(MyWorld) getWorld();
            //a.addScore();
            getWorld().removeObject(this.getOneIntersectingObject(Wasser.class));
            getWorld().removeObject(this);
            
        }

    }
    
    
    
}





