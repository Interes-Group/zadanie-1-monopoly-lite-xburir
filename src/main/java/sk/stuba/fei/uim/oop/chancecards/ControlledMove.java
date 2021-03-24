package sk.stuba.fei.uim.oop.chancecards;

import sk.stuba.fei.uim.oop.ZKlavesnice;
import sk.stuba.fei.uim.oop.initialization.Player;
import sk.stuba.fei.uim.oop.initialization.Game;

public class ControlledMove extends ChanceBaseCard{

    public ControlledMove(){
        super();
        this.cost = 500;


    }

    public void question(Player player,Game game, Player[] players){
        System.out.println("For only "+cost+"€ you can choose to throw with a \"cheat\" dice");
        System.out.println("You wont get the round bonus if you pass the start with this move");
        if (player.getMoney()>=cost){
            if(  ask()  ){
                player.addMoney(-cost);
                int number = 0;
                while (number < 1 || number > 6){
                     number = ZKlavesnice.readInt("Choose number from 1-6");
                }
                player.move(number);
                game.steppedOn(player,players);
            }
        }
        else{
            System.out.println("Oh you don't have the money for it anyway.");
        }


    }

}
