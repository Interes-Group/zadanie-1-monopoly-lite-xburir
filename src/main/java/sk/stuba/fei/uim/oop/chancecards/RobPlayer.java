package sk.stuba.fei.uim.oop.chancecards;

import sk.stuba.fei.uim.oop.ZKlavesnice;
import sk.stuba.fei.uim.oop.initialization.Player;

public class RobPlayer extends ChanceBaseCard{

    private Player target;

    public RobPlayer(){
        super();
        this.target = null;
        this.cost = 10000;
    }

    public void choosePlayerToRob(Player[] otherPlayers,Player playerOnMove){
        System.out.println("Choose a player to rob: ");

        for (var otherPlayer : otherPlayers){
            if (otherPlayer.playing){
                if (otherPlayer != playerOnMove){
                    System.out.print(otherPlayer.getName()+" ["+ otherPlayer.getMoney()+"] ");
                    if (ask()){
                        this.target = otherPlayer;
                        return;
                    }

                }
            }
        }
        System.out.println("You have not chosen anybody, do you want to choose again?");
        if (ask()){
            choosePlayerToRob(otherPlayers,playerOnMove);
        }
        else{
            this.target = null;
        }

    }

    public void setRewardAndProbability(){
        System.out.println("Choose the amount of money you want to rob from "+target.getName());
        this.reward = ZKlavesnice.readInt("");
        if (reward < 1){
            System.out.println("The number must be positive");
            setRewardAndProbability();
        }
        if(reward > target.getMoney()){
            System.out.println("This player does not have that much money!");
            setRewardAndProbability();

        }
        else{
            this.probability = 100;
            this.probability = probability - reward/500;
            System.out.println("The probability to rob this player successfully is "+this.probability+"%");
            System.out.println("Do you want to proceed?");
            if(!ask()){
                this.target = null;
            }
        }
    }

    public void question(Player playerOnMove, Player[] otherPlayers){
        System.out.println("You have a chance to rob a player by hiring a crew.\n" +
                "The chance to succeed decreases with the amount of money you want to rob.\nThe crew costs "+cost+"€");


        if(playerOnMove.getMoney()>cost) {
            if(  ask()  ){
                choosePlayerToRob(otherPlayers, playerOnMove);
                if (target == null){
                    System.out.println("You are right, better play it safe");
                }
                else{
                    setRewardAndProbability();
                    if (target != null){
                        if(playCard(playerOnMove)){
                            playerOnMove.addMoney(reward);
                            target.addMoney(-reward);
                        }
                        else{
                            System.out.println("Also, you are going to prison because you tried to rob a person");
                            playerOnMove.sendToPrison();
                        }
                    }
                    else{
                        System.out.println("You are right, better play it safe");
                    }

                }
            }
            else{
                System.out.println("You are right, better play it safe");
            }
        }
        else{
            System.out.println("Oh you don't have the money for it anyway.");
        }



    }



}
