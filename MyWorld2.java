import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld2 extends World
{
    private int score;
    private Feuerwehrmann feuerwehrmann;
    
    public MyWorld2(Feuerwehrmann altF, int altScore)
    {    
        super(1200, 850, 1);
        
        feuerwehrmann = altF;
        score = altScore;
        addObject(feuerwehrmann, 616, 777);
        
        Boden boden = new Boden();
        addObject(boden,865,817);
        
        Boden boden2 = new Boden();
        boden2.setImage("Boden_kurz_Level 1.png");
        addObject(boden2,632,585);
        
        Boden boden3 = new Boden();
        boden3.setImage("Boden_kurz_Level 1.png");
        addObject(boden3,1015,585);
        
    }
    
    public void act(){
        showText("Score: "+score, getWidth()/2, getHeight()/12);
    }
    
    public void addScore(){
        score = score +100;
    }
    
    public Feuerwehrmann getFeuerwehrmann(){
        return feuerwehrmann;
    }
    
    public int getScore(){
        return score;
    }
}





