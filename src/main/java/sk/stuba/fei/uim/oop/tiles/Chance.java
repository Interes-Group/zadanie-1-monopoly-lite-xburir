package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.chancecards.*;
import sk.stuba.fei.uim.oop.initialization.Board;
import sk.stuba.fei.uim.oop.initialization.Player;

public class Chance extends Tile{

    public Chance(){
        super();
        this.type = "Chance";
        this.icon = "?";
    }

    public void reshuffle(Board board){
        System.out.println("Reshuffling cards");
        for (var card:board.chanceBaseCardPack){
            card.setUsed(false);
        }
    }

    public void steppedOn(Player player, Board board){

        for (var card : board.chanceBaseCardPack){
            if (!card.isUsed()){
                if (card instanceof Card1){
                    ((Card1)card).question(player);
                }
                else if (card instanceof Card2){
                    ((Card2)card).question(player,board);
                }
                card.setUsed(true);
                return;
            }
        }
        int numberOfCards = board.chanceBaseCardPack.length;
        if (board.chanceBaseCardPack[numberOfCards-1].isUsed()){
            reshuffle(board);
        }

    }
}
