package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.initialization.Player;

import java.util.ArrayList;

public class Tax extends Tile{

    private int taxAmount = 4000;
    private ArrayList<Player> immunePlayers;

    public Tax(){
        super();
        this.immunePlayers = new ArrayList<>();
        this.type = "Tax";
        this.icon = "€";
    }

    public void addPlayersToList(Player player){
        immunePlayers.add(player);
    }

    public void steppedOn(Player player){

        System.out.println("You are paying a tax in the amount of "+taxAmount+"€");
        for(var p : immunePlayers){
            if (p == player){
                System.out.println(player.getName()+" was immune to taxes so he is not paying anything");
                return;
            }
        }
        player.addMoney(-taxAmount);

    }

}
