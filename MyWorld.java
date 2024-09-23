import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private int score;
    private Feuerwehrmann feuerwehrmann;
    private int anzahlZuRettenderPersonen; // später ohne "= 1"
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 850, 1); 

        feuerwehrmann = new Feuerwehrmann();
        addObject(feuerwehrmann, 616, 762);

        Boden boden = new Boden();
        //boden.getImage().scale(boden.getImage().getWidth(), boden.getImage().getHeight());
        addObject(boden,838,800);
        
        Boden boden2 = new Boden();
        addObject(boden2,430,675);
        
        Boden boden3 = new Boden();
        addObject(boden3,838,554);
        
        Boden boden4 = new Boden();
        boden4.setImage("Boden_kurz_Level 1.png");
        addObject(boden4,987,433);
        
        Boden boden5 = new Boden();
        boden5.setImage("Boden_kurz_Level 1.png");
        addObject(boden5,708,317);
        
        //--------------------------------
        
        Feuer feuer = new Feuer();
        addObject(feuer,1014,759);
        
        Feuer feuer2 = new Feuer();
        addObject(feuer2,240,633);
        
        Feuer feuer3 = new Feuer();
        addObject(feuer3,1029,511);
        
        Feuer feuer4 = new Feuer();
        addObject(feuer4,820,275);
        
        //--------------------------------
        
        Person person = new Person();
        addObject(person,1076,758);
        anzahlZuRettenderPersonen++;
        
        Person person2 = new Person();
        addObject(person2,189,633);
        anzahlZuRettenderPersonen++;
        
        Person person3 = new Person();
        addObject(person3,1085,513);
        anzahlZuRettenderPersonen++;
        
        Person person4 = new Person();
        addObject(person4,752,275);
        anzahlZuRettenderPersonen++;
        
        
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
    
    public int getAnzahlZuRettenderPersonen(){
        return anzahlZuRettenderPersonen;
    }
    
}




