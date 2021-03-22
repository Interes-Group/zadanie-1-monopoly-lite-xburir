package sk.stuba.fei.uim.oop.initialization;


import sk.stuba.fei.uim.oop.ZKlavesnice;
import sk.stuba.fei.uim.oop.tiles.*;

import java.util.Random;

public class Game {
    private GameSettings settings;
    private Board board;
    private boolean gameOn;


    public Game() {

        this.settings = new GameSettings();
        this.board = new Board();
        this.gameOn = true;

    }


    public void play() {

        while (gameOn) {
            for (var player : settings.players) {
                if (player.playing) {
                    if (!player.isInPrison()) {
                        System.out.println("\n\n\n\n\n");
                        board.printBoard(settings.players);
                        if (ZKlavesnice.readString(player.getName() + " ["+ player.getMoney() + "€]"  + " is throwing the dice, press enter").equals("oop")) {
                            int number = ZKlavesnice.readInt("What number would you like to cheat?");
                            throwDice(player, number);
                        } else {
                            throwDice(player);
                        }

                    } else {
                        System.out.println("Player " + player.getName() + " is in prison and is skipping the round.");
                    }
                    gameOn = checks(settings.players);
                    if (!gameOn){
                        break;
                    }
                }
            }

        }

        for (var player : settings.players) {
            if (player.playing) {
                System.out.println(player.getName() + " is the winner!");
            }
        }
    }


    public void throwDice(Player player, int number) {

        int distance = number;
        int oldPosition = player.getPosition();
        player.move(distance);
        if (oldPosition > player.getPosition()) {
            player.addMoney(GameSettings.ROUND_BONUS);
            System.out.println("Player " + player.getName() + " got the round bonus!");
        }
        steppedOn(player);
    }

    public void throwDice(Player player) {
        Random rand = new Random();
        int distance = rand.nextInt(6) + 1;
        System.out.println(player.getName() + " threw a " + distance);

        int oldPosition = player.getPosition();
        player.move(distance);
        if (oldPosition > player.getPosition()) {
            player.addMoney(GameSettings.ROUND_BONUS);
            System.out.println("Player " + player.getName() + " got the round bonus!");
        }

        steppedOn(player);
    }


    public void steppedOn(Player player) {
        int playerPos = player.getPosition();
        Tile current = board.getTile(playerPos);
        if (playerPos == 12) {
            ((Police) current).steppedOn(player);
        }

        if (current.getType().equals("Land")) {
            ((Land) current).steppedOn(player);
        }
        if (current.getType().equals("Chance")) {
            ((Chance) current).steppedOn(player, board);
        }
        if (current.getType().equals("Tax")) {
            ((Tax) current).steppedOn(player);
        }


    }

    public boolean checks(Player[] players) {
        int numberOfPlayingPlayers = 0;
        for (var player : players) {
            if (player.getMoney() <= 0) {
                if (player.playing) {
                    player.playing = false;
                    System.out.println("Player " + player.getName() + " lost all of his money and is now out of the game.");
                    player.removeLands();
                }
            }
            if (player.playing){
                numberOfPlayingPlayers++;
            }
        }

        return numberOfPlayingPlayers > 1;
    }

}
