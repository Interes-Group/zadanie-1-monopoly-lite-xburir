package sk.stuba.fei.uim.oop.chancecards;

import sk.stuba.fei.uim.oop.initialization.Board;
import sk.stuba.fei.uim.oop.initialization.Player;
import sk.stuba.fei.uim.oop.tiles.Tax;

public class TaxImmunity extends ChanceBaseCard{

    public TaxImmunity(){
        super();
        this.cost = 2000;

    }

    public void question(Player player, Board board){
        System.out.println("You can buy immunity for the taxes."+cost+"€");
        if (player.getMoney()>=cost){
            if(  ask()  ){
                player.addMoney(-cost);
                Tax tile = (Tax)board.getTile(player.getPosition());
                tile.addPlayersToList(player);
            }
        }
        else{
            System.out.println("Oh you don't have the money for it anyway.");
        }


    }

}
