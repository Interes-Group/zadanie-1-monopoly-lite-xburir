package sk.stuba.fei.uim.oop.initialization;

import sk.stuba.fei.uim.oop.Colors;
import sk.stuba.fei.uim.oop.tiles.Land;

import java.util.ArrayList;

public class Player {
    private int position;
    private final String name;
    private int money;
    public boolean playing;
    private int lapsInPrison;
    private final String mark;
    private final String color;
    private ArrayList<Land> lands;


    public Player(int position, String name, int money, String color){
        lands = new ArrayList<>();
        this.position = position;
        this.money = money;
        this.playing = true;
        this.lapsInPrison = 0;
        this.color = color;
        this.mark = Colors.chooseColor(color) + name.charAt(0)+Colors.chooseColor("RESET");
        this.name = Colors.chooseColor(color) + name + Colors.chooseColor("RESET");
    }

    public void addMoney(int amount){
        this.money = getMoney()+amount;
    }

    public int getMoney(){
        return money;
    }

    public void move(int steps){
        this.position = (this.position+steps)%24;
    }

    public int getPosition(){
        return position;
    }

    public void sendToPrison(){
        this.position = 6;
        this.lapsInPrison = GameSettings.PRISON_TIME;
    }

    public boolean isInPrison(){
        if (this.lapsInPrison > 0 ){
            this.lapsInPrison--;
            return true;
        }
        else{
            return false;
        }
    }

    public String getName(){
        return name;
    }

    public String getMark(){
        return mark;
    }

    public String getColor(){
        return Colors.chooseColor(color);
    }

    public void addLandToPlayer(Land land){
        lands.add(land);
    }

    public void removeLands(){

        for(var iter : lands){
            iter.setLandFree();
        }


    }

}

