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

    public void steppedOn(Player player, Board board,Player[] players){

        for (var card : board.chanceBaseCardPack){
            if (!card.isUsed()){
                if (card instanceof Lotto){
                    ((Lotto)card).question(player);
                }
                else if (card instanceof BribeAccountant){
                    ((BribeAccountant)card).question(player,board);
                }
                else if (card instanceof RobPlayer){
                    ((RobPlayer)card).question(player,players);
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
