package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.chancecards.*;
import sk.stuba.fei.uim.oop.initialization.*;


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

    public void steppedOn(Player player, Board board,Player[] players, Game game){

        for (var card : board.chanceBaseCardPack){
            if (!card.isUsed()){
                card.setUsed(true);
                if (card instanceof Lotto){
                    ((Lotto)card).question(player);
                }
                else if (card instanceof BribeAccountant){
                    ((BribeAccountant)card).question(player,board);
                }
                else if (card instanceof RobPlayer){
                    ((RobPlayer)card).question(player,players);
                }
                else if (card instanceof ControlledMove){
                    ((ControlledMove)card).question(player,game,players);
                }
                else if (card instanceof TaxImmunity){
                    ((TaxImmunity)card).question(player,board);
                }

                return;
            }
        }
        int numberOfCards = board.chanceBaseCardPack.length;
        if (board.chanceBaseCardPack[numberOfCards-1].isUsed()){
            reshuffle(board);
            steppedOn(player,board,players,game);
        }

    }
}
