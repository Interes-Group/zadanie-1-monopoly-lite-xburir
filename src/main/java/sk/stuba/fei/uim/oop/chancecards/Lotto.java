package sk.stuba.fei.uim.oop.chancecards;

import sk.stuba.fei.uim.oop.initialization.*;

public class Lotto extends ChanceBaseCard {

    //This card will give you the chance to bet money, you can win or lose


    public Lotto(){
        super();
        this.cost = 5000;
        this.reward = 50000;
        this.probability = 10; //10% chance


   }

    public void question(Player player){
        System.out.println("You have "+probability+" chance to win "+reward+"€ by buying a lotto for "+cost+"€");
        if (player.getMoney()>=cost){
            if(  ask()  ){
                if(playCard(player)){
                    player.addMoney(reward);
                }
            }
            else{
                System.out.println("Better play it safe");
            }
        }
        else{
            System.out.println("Oh you don't have the money for it anyway.");
        }


    }



}
