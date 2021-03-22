package sk.stuba.fei.uim.oop.chancecards;

import sk.stuba.fei.uim.oop.ZKlavesnice;
import sk.stuba.fei.uim.oop.initialization.Player;
import java.util.Random;

public abstract class ChanceBaseCard {
    protected int type;
    protected boolean used;
    protected char answer;
    protected int cost;
    protected int reward;
    protected int probability;
    protected StringBuilder builder;

    public ChanceBaseCard(){
        this.used = false;
        this.answer = 'N';
    }

    public String effect(int cost, int probability, String effect){
        builder = new StringBuilder();
        builder.append("You have ");
        builder.append(probability);
        builder.append("% chance to ");
        builder.append(effect);
        builder.append(" for ");
        builder.append(cost);
        builder.append("€");
        return builder.toString();
    }

    public boolean ask(){
        this.answer = ZKlavesnice.readChar("Y/N");
        if (answer == 'Y' || answer == 'y'){
            return true;
        }
        else if (answer == 'N' || answer == 'n'){
            System.out.println("You are right, better play it safe");
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
