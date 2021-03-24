package sk.stuba.fei.uim.oop.chancecards;

import sk.stuba.fei.uim.oop.ZKlavesnice;
import sk.stuba.fei.uim.oop.initialization.Player;
import java.util.Random;

public abstract class ChanceBaseCard {
    protected boolean used;
    protected char answer;
    protected int cost;
    protected int reward;
    protected int probability;

    public ChanceBaseCard(){
        this.used = false;
        this.answer = 'N';
    }



    public boolean ask(){
        this.answer = ZKlavesnice.readChar("Y/N");
        if (answer == 'Y' || answer == 'y'){
            return true;
        }
        else if (answer == 'N' || answer == 'n'){
            return false;
        }
        else{
            ask();
        }
        return false;
    }


    public boolean playCard(Player player){
        player.addMoney(-cost);
        Random rand = new Random();
        int random = rand.nextInt(100);
        if (random < probability) {
            System.out.println("Your luck worked this time.");
            return true;
        }
        else{
            System.out.println("Your luck did not work this time.");
            return false;
        }
    }

    public boolean isUsed(){
        return used;
    }

    public void setUsed(boolean answer){
        used = answer;
    }

}
