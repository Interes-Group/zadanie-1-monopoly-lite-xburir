package sk.stuba.fei.uim.oop.initialization;


import sk.stuba.fei.uim.oop.Colors;
import sk.stuba.fei.uim.oop.ZKlavesnice;

import java.util.*;

public class GameSettings {
    private int numberOfPlayers;
    public final Player[] players;
    private static final int STARTING_MONEY = 100000;
    public static final int PRISON_TIME = 3;
    public static final int ROUND_BONUS = 50000;
    private ArrayList<String> freecolors;


    GameSettings() {
        initializeNamesOfColors();


        this.numberOfPlayers = ZKlavesnice.readInt("How many players will be playing? 2 - 11");
        this.players = new Player[numberOfPlayers];

        while(numberOfPlayers > 11 || numberOfPlayers < 2){
            System.out.println("Invalid number");
            this.numberOfPlayers = ZKlavesnice.readInt("How many players will be playing? 2 - 11");
        }

        for (int i = 0; i < numberOfPlayers; i++) {

            String name = ZKlavesnice.readString("Name of player number " + (i+1));
            printFreeColors(freecolors);
            String color = ZKlavesnice.readString("Color of player number "+ (i+1));
            color = color.toUpperCase();
            if(freecolors.contains(color)){
                players[i] = new Player(0, name, STARTING_MONEY, color);
                freecolors.remove(color);
            }
            else{
                System.out.println("Invalid color, using first available");
                color = freecolors.get(0);
                freecolors.remove(0);
                players[i] = new Player(0, name, STARTING_MONEY, color);
            }


        }
    }

    public void initializeNamesOfColors(){
        this.freecolors = new ArrayList<>();
        freecolors.add("TEAL");
        freecolors.add("RED");
        freecolors.add("GREEN");
        freecolors.add("YELLOW");
        freecolors.add("BLUE");
        freecolors.add("PURPLE");
        freecolors.add("CYAN");
        freecolors.add("LIGHT_GREEN");
        freecolors.add("LIGHT_BLUE");
        freecolors.add("ORANGE");
        freecolors.add("BROWN");
    }

    public void printFreeColors(ArrayList<String> freecolors){
         Iterator<String> iter = freecolors.iterator();
        System.out.print("Color available: ");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println("");

    }


}
