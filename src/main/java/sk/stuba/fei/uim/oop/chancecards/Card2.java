package sk.stuba.fei.uim.oop.chancecards;

import sk.stuba.fei.uim.oop.initialization.*;
import sk.stuba.fei.uim.oop.tiles.Land;

import java.util.ArrayList;
import java.util.Random;


public class Card2 extends ChanceBaseCard {

    //This card will give you the chance illegally buy a land

    public Card2(){
        super();
        this.type = 2;
        this.cost = 10000;
        this.probability = 65; //65% chance

    }

    public ArrayList<Land> getFreeLands(Board board){
        ArrayList<Land> frees = new ArrayList<>();

        for (int i = 0; i < 24;i++){
            if(board.getTile(i) instanceof Land){
                Land current = ((Land) board.getTile(i));
                if (! current.isOwned()){
                    frees.add(current);
                }
            }
        }
        return frees;
    }

    public Land pickRandomLand(ArrayList<Land> frees){
        Random rand = new Random();
        int chosen = rand.nextInt(frees.size());
        return frees.get(chosen);
    }





    public void assignLandToPlayer(Player player, Board board){
        pickRandomLand(getFreeLands(board)).giveLand(player);
        System.out.println("Property given");
    }


    public void question(Player player,Board board){
        System.out.println(effect(cost,probability,"get a random land by bribing an accountant"));
        if(player.getMoney()>cost) {
            if(  ask()  ){
                if(playCard(player)){
                    assignLandToPlayer(player,board);
                }
                else{
                    System.out.println("Also, you are going to prison because you tried to bribe a person");
                    player.sendToPrison();
                }
            }
        }
        else{
            System.out.println("Oh you don't have the money for it anyway.");
        }



    }


}
