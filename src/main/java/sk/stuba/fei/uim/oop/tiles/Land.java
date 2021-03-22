package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.Colors;
import sk.stuba.fei.uim.oop.ZKlavesnice;
import sk.stuba.fei.uim.oop.initialization.Player;

public class Land extends Tile {

    private Player owner;
    private int value;
    private int fine;


    public Land(){
        super();
        this.type = "Land";
        this.icon = "L";
        this.owner = null;
        this.value = 30000;
        this.fine = 5000;
    }

    public void offerToBuy(Player player){
        System.out.println("This land has no owner, do you want to buy it for "+value+"€?");
        if (player.getMoney() <= value){
            System.out.println("Oh you don't have the money for it anyway.");
        }
        else{
            char answer = ZKlavesnice.readChar("Y/N");
            if (answer == 'Y' || answer == 'y'){
                player.addMoney(-value);
                System.out.println("Land bought");
                player.addLandToPlayer(this);
                this.owner = player;
                this.icon = player.getColor()+"L" + Colors.chooseColor("RESET");
            }
            else if (answer == 'N' || answer == 'n'){
                System.out.println("Land was not bought");
            }
            else {
                System.out.println("Invalid answer.");
                offerToBuy(player);
            }
        }

    }

    public void giveLand(Player player){
        this.owner = player;
        this.icon = player.getColor()+"L" + Colors.chooseColor("RESET");
        player.addLandToPlayer(this);
    }

    public void setLandFree(){
        this.owner = null;
        this.icon = Colors.chooseColor("RESET") + "L";
    }

    public void steppedOn(Player player){

        if( owner == null) {
            offerToBuy(player);
        }
        else if (owner != player){
            player.addMoney(-fine);
            System.out.println(player.getName()+" is paying "+owner.getName()+" "+fine+"€");
            Player playerToReceivePayment = owner;
            playerToReceivePayment.addMoney(fine);
        }


    }

    public boolean isOwned(){
        if (owner == null){
            return false;
        }
        else return true;
    }

}
