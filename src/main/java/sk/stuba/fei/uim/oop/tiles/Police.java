package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.initialization.Player;

public class Police extends Tile{

    public Police(){
        super();
        this.type = "Police";
        this.icon = "!";
    }

    public void steppedOn(Player player){
        player.sendToPrison();
        System.out.println("You messed with the police, now you are in jail");
    }

}
