package main;

import java.util.Random;

public class Auto {
    /* ADATTAGOK */
    private static int objektumDb = 0; //osztály adattagja, lehet itt inicializálni
    private static Random rnd = new Random();
    /* objektum adattagokat a konstruktor inicializál: */
    private boolean uzemanyag; //példány v. másnéven az objektum adattagja
    private boolean beinditva; //példány v. másnéven az objektum adattagja
    private  int potkerek;
    private boolean defekt;
    
    /* TAGFÜGGVÉNYEK */
    /* kstr hívási lánc: túlterhelt kstr hívja a másik kstr-t */
    public Auto(){
        /* semmi nem lehet a kstr. hívás előtt, mert nem fordul le! */
        //int i = 7;
        
        /* kstr csak kstr-ból hívunk, this kulcsszóval, nem a nevével */
        this(true, false);
        
    }
    
    public Auto(boolean beinditva){
        this(false, beinditva);
    }
    
    public Auto(boolean uzemanyag, boolean beinditva){
        Auto.objektumDb++;
        potkerek = 5;
        System.out.println("*********************************");
        System.out.printf("********** %d. bemutató **********\n".formatted(Auto.objektumDb));
        this.uzemanyag = uzemanyag;
        this.beinditva = beinditva;
        final String VAN = "✔ (van)";
        final String NINCS = "❌ (nincs)";
        String info = uzemanyag ? VAN : NINCS;
        System.out.println("üzemanyag: " + info);
        info = beinditva ? VAN : NINCS;
        System.out.println("beindítva: " + info);
        System.out.println("-----------------");
        
    }
    
    public void setBeinditva(boolean beinditva){
        /* lehetne további ellenőrzés, pl.:
        csak akkor lehet beindítani, ha van üzemanyag
        */
        this.beinditva = beinditva;
        if(beinditva){
            System.out.println("A motor be van indítva.");
        }else{
            System.out.println("A motor le van állítva.");
        }
    }
    
    //setUzemanyag(false)
    public void megy(){
        if (beinditva && uzemanyag) {
            this.uzemanyag = false;
            System.out.println("Haladtunk, az autó megérkezett, de üres a tank.");
        }else if(!beinditva){
            System.out.println("Nem haladtunk, az autó nincs beindítva.");
        }else if(!uzemanyag){
            System.out.println("Nem haladtunk, mert üres a tank.");
        }
        int defektValoszinuseg = rnd.nextInt(1,2);
        if(defektValoszinuseg == 1){
            beinditva = false;
            defektVanE();
            if(getDefekt()){
                kerekCsere();
            }
        }
    }
    
    //setUzemanyag(true)
    public void tankol(){
        if (!beinditva) {
            this.uzemanyag = true;
            System.out.println("Sikerült tankolni, tele a tank.");
        }else{
            System.out.println("Sikertelen tankolás, mert be van indítva a motor.");
        }
    }
    public void defektVanE(){
            
            setDefekt(true);
            setBeinditva(false);
            
    }
    public void kerekCsere(){
        setPotkerek(5);
        if(getDefekt() && getPotkerek() > 0 ){
            System.out.println("kerek cserelve");
            setPotkerek(getPotkerek()-1);
            setDefekt(false);
        } else {
            System.out.println("Elfogyott a kerek");
        }
    }
    

    public void setPotkerek(int potkerek) {
        this.potkerek = potkerek;
    }

    public void setDefekt(boolean defekt) {
        this.defekt = defekt;
    }

    public int getPotkerek() {
        return potkerek;
    }

    public boolean getDefekt() {
        return defekt;
    }
    
        
}

