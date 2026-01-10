package com.company;

import java.util.Random;

public class FlipCoin {

    public enum Coin {
        HEADS, TAILS;
    }

    public enum Game {
        WIN, LOSE;
    }

    private static Coin flip() {
        int random = new Random().nextInt(2);
        if (random == 0) {
            return Coin.HEADS;
        }
        return Coin.TAILS;
    }

    public static boolean flipFor(Coin picked) {
        System.out.println("Flipping...");
        Coin landed = flip();
        System.out.printf("Landed %s%n", landed);
        return  (landed == picked);
    }

    public static void main(String[] args) {
        Coin chose = Coin.HEADS;
        System.out.printf("You chose %s%n", chose);
        Game game = flipFor(chose) ? Game.WIN : Game.LOSE;
        System.out.printf("You %s!%n", game);
    }
}
