package sk.stuba.fei.uim.oop.chancecards;

import sk.stuba.fei.uim.oop.initialization.*;

public class Card1 extends ChanceBaseCard {

    //This card will give you the chance to bet money, you can win or lose


    public Card1(){
        super();
        this.type = 1;
        this.cost = 5000;
        this.reward = 50000;
        this.probability = 10; //10% chance


   }

    public void question(Player player){
        System.out.println(effect(cost,probability,"win "+reward+"€"));
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
