package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.initialization.Player;

public class Tax extends Tile{

    private int taxAmount = 4000;

    public Tax(){
        super();
        this.type = "Tax";
        this.icon = "€";
    }

    public void steppedOn(Player player){

        System.out.println("You are paying a tax in the amount of "+taxAmount+"€");
        player.addMoney(-taxAmount);
    }

}
