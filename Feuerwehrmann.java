import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Feuerwehrmann extends Actor
{
    private int vertikal;
    private long letztesWasser;
    private int ausrichtung;
    private int gerettetePerson;
    private long letzterSprung;

    public void act()
    {
        if(Greenfoot.isKeyDown("RIGHT")){
            move(6);
            setImage("Feuerwehrmann_rechts.png");
            ausrichtung = 1;
        }
        if(Greenfoot.isKeyDown("LEFT")){
            move(-6);
            setImage("Feuerwehrmann_links.png");
            ausrichtung = -1;
        }
        if(Greenfoot.isKeyDown("UP") && System.currentTimeMillis()>letzterSprung+600){
            if(beruehrtBoden()){
                Greenfoot.playSound("sprung.mp3");
                springen();
            }
        }
        if(beruehrtBoden() == false){
            fallen();
        }
        if(Greenfoot.isKeyDown("F") && System.currentTimeMillis()>letztesWasser+400){
            schiesen();
        }

        gameOver();

        retten();

    }

    public void fallen(){
        setLocation(getX(), getY() + vertikal);
        vertikal = vertikal + 1;                    //für realistische Flugkurve
    }

    public boolean beruehrtBoden(){
        Actor untergrund;   // Boden drunter
        untergrund = getOneObjectAtOffset(0, 38+vertikal/4, Boden.class);

        Actor obergrund;    // Boden drüber
        obergrund = getOneObjectAtOffset(0, -30, Boden.class);

        if(untergrund != null){                             // Wenn nach unten anstößt
            setLocation(getX(), untergrund.getY()-38);      // Figur richtig positionieren. -63, weil works best
            vertikal = 1;
            return true;
        } else{
            if(obergrund != null){                          // Wenn nach oben anstößt
                setLocation(getX(), obergrund.getY()+38);   // Figur richtig positionieren. 70, weil works best
                vertikal = 1;
            }
            return false;
        }

        /*if(isTouching(Boden.class)){
        vertikal = 0;
        return true;
        }
        else {
        return false;
        }*/
    }

    public void schiesen(){
        Wasser wasser = new Wasser();
        if(ausrichtung == 1){   // nach rechts
            wasser.setImage("Wasser_rechts.png");
            wasser.setzeRichtung(7);
        } else if(ausrichtung == -1){                 // nach links
            wasser.setImage("Wasser_links.png");
            wasser.setzeRichtung(-7);
        }else{
            wasser.setImage("Wasser_rechts.png");
            wasser.setzeRichtung(7);    //kommt nur am Start vor.
        }
        getWorld().addObject(wasser, getX(), getY());
        this.letztesWasser = System.currentTimeMillis(); // für warten nach letztem Schuss.
        Greenfoot.playSound("wasser.mp3");
    }

    public void springen(){
        vertikal = -15;     //negative Beschleunigung setzten
        this.letzterSprung = System.currentTimeMillis(); // für warten nach letztem Sprung,um weniger Gefahr mit Feuer nach Doppelsprung.
        fallen();
    }

    public void gameOver(){
        if(isAtEdge() || isTouching(Feuer.class)){      // Spielende
            getWorld().showText("GameOver", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.playSound("gameover.mp3");
            Greenfoot.stop();
        }
    }

    public void retten(){
        if(isTouching(Person.class)){
            MyWorld a =(MyWorld) getWorld();

            //getWorld().removeObject(this.getOneIntersectingObject(Feuerwehrmann.class));
            getWorld().removeObject(getOneIntersectingObject(Person.class));
            a.addScore();
            if(gerettetePerson < a.getAnzahlZuRettenderPersonen()-1){    
                Greenfoot.playSound("gerettet.mp3");
            } else {
                Knopf knopf = new Knopf();
                //gerettetePerson = 0;
                getWorld().addObject(knopf,600,500);
                gerettetePerson = 0;
                Greenfoot.playSound("geschafft.mp3");
            }
            gerettetePerson++;

        }

        
    }

}


