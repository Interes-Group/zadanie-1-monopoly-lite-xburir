package sk.stuba.fei.uim.oop.initialization;

import sk.stuba.fei.uim.oop.chancecards.*;
import sk.stuba.fei.uim.oop.tiles.*;

public class Board {
    private Tile[] board;
    public ChanceBaseCard[] chanceBaseCardPack;


    public Board(){

        this.board = new Tile[24];
        this.chanceBaseCardPack = new ChanceBaseCard[5];
        fillBoard();
        fillChanceCards();
    }

    public void fillChanceCards(){
        for (int i = 0; i < 5;i++){
            if (i%5 == 0){
                chanceBaseCardPack[i] = new Lotto();
            }
            else if (i%5 == 1){
                chanceBaseCardPack[i] = new BribeAccountant();
            }
            else if (i%5 == 2){
                chanceBaseCardPack[i] = new RobPlayer();
            }
            else{
                chanceBaseCardPack[i] = new RobPlayer();
            }
        }
    }

    public void fillBoard(){
        for (int i = 0; i < 24 ; i++ ){
            if (i == 0){
                board[i] = new Start();
            }
            else if (i == 3 || i == 9 || i == 15 || i == 21){
                board[i] = new Chance();
            }
            else if (i==6){
                board[i] = new Prison();
            }
            else if (i==18){
                board[i] = new Tax();
            }
            else if (i==12){
                board[i] = new Police();
            }
            else {
                board[i] = new Land();
            }

        }
    }

    public void printBoard(Player[] players){
        for (Tile i : this.board){
            System.out.print(i.getIcon());
        }
        System.out.print("\n");
        String[] spaces = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
        boolean onTheSameSpot = false;
        for(var player:players){
            if (player.playing){
                if (spaces[(player.getPosition())%24] != " "){
                    onTheSameSpot = true;
                }
                spaces[(player.getPosition())%24] = player.getMark();
            }
        }
        for (String i : spaces){

            System.out.print(i);
        }
        if (onTheSameSpot){
            System.out.print("\nThere are more players on the same spot\n\n");
        }
        else{
            System.out.println("");
        }

    }

    public Tile getTile(int i){
        return board[i];
    }



}
